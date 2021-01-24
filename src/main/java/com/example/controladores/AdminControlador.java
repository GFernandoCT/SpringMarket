package com.example.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entidades.Producto;
import com.example.servicios.ProductoServicio;

@Controller
@RequestMapping(value = "/admin")
public class AdminControlador {
	
	@Autowired
	ProductoServicio productoService;
	
	@GetMapping("/crearProducto")
	public String crearProducto() {
			return "Producto/crear";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/crear")
	public String crearProducto(@RequestParam("nombre") String nombre, @RequestParam("marca") String marca,
			@RequestParam("categoria") String categoria, @RequestParam("descripcion") String descripcion,
			@RequestParam("precio") int precio, @RequestParam("descuento") int descuento, HttpServletRequest request) {

		Producto producto = new Producto(marca, nombre, categoria, descripcion, precio, descuento);
		productoService.crearProducto(producto);
		return "redirect:/";
	}
}
