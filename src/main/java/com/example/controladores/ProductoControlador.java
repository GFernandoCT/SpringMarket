package com.example.controladores;

import java.util.ArrayList;
import java.util.List;

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

import com.example.entidades.Producto;
import com.example.entidades.ProductoCarrito;
import com.example.servicios.ProductoServicio;


@Controller
@RequestMapping(value = "/Producto")
public class ProductoControlador {

	@Autowired
	ProductoServicio productoService;
	
	/*@RequestMapping(method = RequestMethod.GET, value = "/lista")
	public ModelAndView listarProducto() {
		ModelAndView mav = new ModelAndView();
		List<Producto> lProducto = productoService.listarProducto();
		mav.addObject("Productos", lProducto);
		mav.setViewName("Producto/Lista");
		return mav;
	}*/
	
	@RequestMapping("/prueba")
	public String hola(Model modelo) {
		return "Producto/Prueba";
	}

	@GetMapping("/crear")
	public String showForm() {
		return "Producto/crear";
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

		mav.addObject("propietario", propietario);
		mav.addObject("producto", producto);
		mav.setViewName("producto/datos");
		return mav;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/crear")
	public String crearProducto(
			@RequestParam("nombre") String nombre, 
			@RequestParam("marca") String marca,
			@RequestParam("categoria") String categoria,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("precio") int precio,
			@RequestParam("descuento") int descuento,
			HttpServletRequest request) {
		
		Producto producto = new Producto(marca,nombre,categoria,descripcion,precio,descuento);
		productoService.crearProducto(producto);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET,value = "/borrar/{id}")
	public ModelAndView borrarProducto(@PathVariable("id") long idProducto, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		productoService.eliminarProducto(idProducto);
		mav.setViewName("redirect:/");
		return mav;
	}
	
	@GetMapping("/carrito")
	public String verCarrito(Model model, HttpSession session) {
		
		List<ProductoCarrito> carrito = (List<ProductoCarrito>)session.getAttribute("CARRITO");
		if(carrito == null) {
			carrito = new ArrayList<>();
		}
		
		model.addAttribute("sessionCarrito", carrito);
		return "Producto/carrito";
	}
	
	@PostMapping("/añadirProducto")
	public String añadirAlCarrito(
			@RequestParam("id") Long id, 
			@RequestParam("cantidadCarro") int cantidad,
			HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<ProductoCarrito> carrito = (List<ProductoCarrito>) request.getSession().getAttribute("CARRITO");
		if (carrito == null) {
			carrito = new ArrayList<>();
		}

		Producto producto = productoService.obtenerProducto(id);
		ProductoCarrito productoCarrito = new ProductoCarrito(id,producto.getNombreProducto(),cantidad);
		carrito.add(productoCarrito);
		
		request.getSession().setAttribute("CARRITO",carrito);
		return "redirect:/Producto/carrito";
	}
}
