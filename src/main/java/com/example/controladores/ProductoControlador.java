package com.example.controladores;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.entidades.Imagen;
import com.example.entidades.Pregunta;
import com.example.entidades.Producto;
import com.example.entidades.ProductoCarrito;
import com.example.entidades.Usuario;
import com.example.servicios.ProductoServicio;
import com.example.servicios.UsuarioServicio;

@Controller
@RequestMapping(value = "/Producto")
public class ProductoControlador {

	@Autowired
	ProductoServicio productoService;

	@Autowired
	UsuarioServicio usuarioService;
	
	@RequestMapping("/prueba")
	public String hola(Model modelo) {
		return "Producto/Prueba";
	}
	
	@RequestMapping(value = "/preguntas/{preguntaSubir}/{idProducto}", method = RequestMethod.POST)
	@ResponseBody
	public String anadirPregunta(@PathVariable("preguntaSubir") String pregunta,
			@PathVariable("idProducto") String idProducto,
			HttpServletRequest request) {
	
		Usuario usuario = usuarioService.obtenerUsuario((long) request.getSession().getAttribute("idUsuario"));
		
		String nombreUsuario = usuario.getNombreUsuario();
		
		Date fecha = new Date();
		
		Pregunta preguntaCompleta = new Pregunta(pregunta,nombreUsuario,fecha.toString());

		
		
		String prueba = pregunta + idProducto;
		
		return prueba;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView perfilProducto(@PathVariable("id") long idProducto, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Producto producto = productoService.obtenerProducto(idProducto);
		Boolean propietario = false;

		if (request.getSession().getAttribute("idUsuario") != null) {
			long idSession = (long) request.getSession().getAttribute("idUsuario");
			propietario = idSession == idProducto;
		}

		Imagen img = null;
		if (!producto.getImagen().isEmpty()) {
			for (Imagen i : producto.getImagen()) {
				img = i;
				break;
			}
		}

		mav.addObject("imagen", img);
		mav.addObject("propietario", propietario);
		mav.addObject("producto", producto);
		mav.setViewName("producto/datos");
		return mav;
	}

	@GetMapping("/carrito")
	public String verCarrito(Model model, HttpSession session) {

		@SuppressWarnings("unchecked")
		Set<ProductoCarrito> carrito = (Set<ProductoCarrito>) session.getAttribute("CARRITO");
		if (carrito == null) {
			carrito = new HashSet<>();
		}

		model.addAttribute("sessionCarrito", carrito);
		return "Producto/carrito";
	}

	@PostMapping("/anadirProducto")
	public String anadirCarrito(@RequestParam("id") Long id, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Set<Producto> carrito = (Set<Producto>) request.getSession().getAttribute("CARRITO");
		if (carrito == null) {
			carrito = new HashSet<>();
		}

		Boolean anadido = false;
		if (!carrito.isEmpty()) {
			for (Producto p : carrito) {
				if (p.getIdProducto() == id) {
					anadido = true;
					break;
				}
			}
		}
		
		if (carrito.isEmpty() || !anadido) {
			Producto producto = productoService.obtenerProducto(id);
			Producto productoCarrito = new Producto(id, producto.getNombreProducto());
			carrito.add(productoCarrito);
		}

		request.getSession().setAttribute("CARRITO", carrito);
		return "redirect:/Producto/carrito";
	}

	@PostMapping("/borrarProductoCarrito")
	public String borrarProductoCarrito(@RequestParam("id") Long id, HttpServletRequest request) {

		@SuppressWarnings("unchecked")
		Set<Producto> carrito = (Set<Producto>) request.getSession().getAttribute("sessionCarrito");
		if (carrito == null) {
			carrito = new HashSet<>();
		}

		carrito.remove(productoService.obtenerProducto(id));
		request.getSession().setAttribute("CARRITO", carrito);
		return "redirect:/Producto/carrito";
	}
}
