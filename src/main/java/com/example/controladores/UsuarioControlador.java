package com.example.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entidades.Usuario;
import com.example.servicios.UsuarioServicio;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioControlador {
	
	@Autowired
	UsuarioServicio usuarioService;
	
	@GetMapping("/registro")
	public String showForm() {
		return "usuario/registro";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registro")
	public String crearUsuario(
			@RequestParam("nombre") String nombreUser, 
			@RequestParam("apellidos") String apellidoUser,
			@RequestParam("contraseña") String contraseñaUser,
			@RequestParam("correo") String emailUser,
			@RequestParam("fecha") String fechaUser,
			@RequestParam("tarjeta") int tarjetaUser,
			@RequestParam("titular") String titularUser,
			@RequestParam("codigo") int codigoUser,
			@RequestParam("facturacion") String direccionUser,
			HttpServletRequest request) {
		
		Usuario usuario = new Usuario(nombreUser,apellidoUser,contraseñaUser,emailUser,fechaUser,tarjetaUser,titularUser,codigoUser,direccionUser);
		usuarioService.crearUsuario(usuario);
		return "redirect:/index";
	}
	
}
