package pe.com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import pe.com.cibertec.entity.UsuarioEntity;
import pe.com.cibertec.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/registrar_usuario")
    public String mostrarCuenta(Model model) {
    	model.addAttribute("usuario", new UsuarioEntity());
        return "registrar_usuario";
    }
	
	@PostMapping("/registrar_usuario")
	public String registrarCuenta(@ModelAttribute("usuario") UsuarioEntity newUsuario,
			Model model, @RequestParam("foto") MultipartFile foto) {
    	usuarioService.registrarUsuario(newUsuario, foto);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String mostrarLogin(Model model) {
	    return "login";
	}
    
	@PostMapping("/login")
	public String iniciarSesion(@RequestParam String correo, @RequestParam String password, Model model, HttpSession session) {
	    String resultadoLogin = usuarioService.validarUsuario(correo, password);
	    if (!resultadoLogin.equals("Logrado")) {
	        model.addAttribute("error", resultadoLogin);
	        return "login";
	    }
	    UsuarioEntity usuario = usuarioService.buscarPorCorreo(correo);
	    session.setAttribute("usuarioLogeado", usuario.getNombres());
	    
	    return "redirect:/listaProductos";
	}
	
	@GetMapping("/logout")
	public String cerrarSesion(HttpSession session) {
	    session.invalidate();
	    return "redirect:/login";
	}
}
