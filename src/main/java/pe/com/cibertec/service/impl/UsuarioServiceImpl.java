package pe.com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.entity.UsuarioEntity;
import pe.com.cibertec.repository.UsuarioRepository;
import pe.com.cibertec.service.UsuarioService;
import pe.com.cibertec.utils.Utilitarios;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public String validarUsuario(String correo, String password) {
		// TODO Auto-generated method stub
		UsuarioEntity usuario = usuarioRepository.findById(correo).orElse(null);
		if (usuario == null) {
			return "La cuenta no existe";
		} else if (!Utilitarios.checkPassword(password, usuario.getPassword())) {
			return "Contraseña incorrecta";
		} else {
			return "Logrado";
		}
	}

	@Override
	public boolean registrarUsuario(UsuarioEntity newUser, MultipartFile foto) {
		// TODO Auto-generated method stub
		String nombreFoto = Utilitarios.guardarImagen(foto);
		newUser.setUrl(nombreFoto);
		String passwordHash = Utilitarios.extraerHash(newUser.getPassword());
		newUser.setPassword(passwordHash);
		try {
			usuarioRepository.save(newUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public UsuarioEntity buscarPorCorreo(String correo) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(correo).get();
	}
	
	

}
