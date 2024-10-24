package pe.com.cibertec.service;

import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.entity.UsuarioEntity;

public interface UsuarioService {
	
	boolean registrarUsuario(UsuarioEntity newUser, MultipartFile foto);
	String validarUsuario(String correo, String password);
	UsuarioEntity buscarPorCorreo(String correo);
}
