package com.example.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entidades.Pedido;
import com.example.entidades.Producto;
import com.example.entidades.Rol;
import com.example.entidades.Usuario;
import com.example.servicios.ProductoServicio;
import com.example.servicios.RolService;
import com.example.servicios.UsuarioServicio;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioControlador {

	@Autowired
	RolService rolService;
	
	@Autowired
	UsuarioServicio usuarioService;

	@GetMapping("/signup")
	public String showForm() {
		return "usuario/registro";
	}

	@GetMapping("/login")
	public String inicio(HttpServletRequest request) {

		HttpSession session = request.getSession();

		if (session != null && session.getAttribute("idUsuario") != null)
			return "redirect:/usuario/perfil/" + session.getAttribute("idUsuario");
		else
			return "/usuario/inicio";
	}
	

	@PostMapping("/login")
	public String iniciarSesion(@RequestParam("nombre") String nombre, @RequestParam("contraseña") String contraseña,
			HttpServletRequest request) {

		Usuario usuario = usuarioService.iniciarSesion(nombre);
		request.getSession().setAttribute("idUsuario", usuario.getIdUsuario());
		return "redirect:/usuario/myprofile";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/myprofile")
	public String perfilPersonal(HttpServletRequest request) {

		HttpSession session = request.getSession();

		if (session != null && session.getAttribute("idUsuario") != null)
			return "redirect:/usuario/perfil/" + session.getAttribute("idUsuario");
		else
			return "redirect:/usuario/login";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/perfil/{id}")
	public ModelAndView perfilProfesor(@PathVariable("id") long idUsuario, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Usuario usuario = usuarioService.obtenerUsuario(idUsuario);
		Boolean propietario = false;

		if (request.getSession().getAttribute("idUsuario") != null) {
			long idSession = (long) request.getSession().getAttribute("idUsuario");
			propietario = idSession == idUsuario;
		}

		mav.addObject("propietario", propietario);
		mav.addObject("usuario", usuario);
		mav.setViewName("usuario/perfil");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registro")
	public String crearUsuario(@RequestParam("nombre") String nombreUser,
			@RequestParam("apellidos") String apellidoUser, @RequestParam("contraseña") String contraseñaUser,
			@RequestParam("correo") String emailUser, @RequestParam("fecha") String fechaUser,
			@RequestParam("tarjeta") int tarjetaUser, @RequestParam("titular") String titularUser,
			@RequestParam("codigo") int codigoUser, @RequestParam("facturacion") String direccionUser,
			HttpServletRequest request) {

		Usuario usuario = new Usuario(nombreUser, apellidoUser, contraseñaUser, emailUser, fechaUser, tarjetaUser,
				titularUser, codigoUser, direccionUser);
		Rol rol=rolService.obtenerRol(1);
		usuario.anadirRol(rol);
		usuarioService.crearUsuario(usuario);
		return "redirect:/index";
	}



	@GetMapping("/logOut")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/index";
	}
	
	@RequestMapping("/accesoDenegado")
	public String noPermisos(Model modelo) {
		return "usuario/accesoDenegado";
	}
}
