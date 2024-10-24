package pe.com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pe.com.cibertec.entity.UsuarioEntity;
import pe.com.cibertec.repository.UsuarioRepository;
import pe.com.cibertec.service.UsuarioService;
import pe.com.cibertec.utils.Utilitarios;

public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public String validarUsuario(String correo, String password) {
		// TODO Auto-generated method stub
		UsuarioEntity usuario = usuarioRepository.findById(correo).get();
		if (usuario == null) {
			return "La cuenta no existe";
		} else if (!Utilitarios.checkPassword(password, usuario.getPassword())) {
			return "Contraseña incorrecta";
		} else {
			return "Logrado";
		}
	}

	@Override
	public boolean registrarUsuario(UsuarioEntity newUser) {
		// TODO Auto-generated method stub
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

}
