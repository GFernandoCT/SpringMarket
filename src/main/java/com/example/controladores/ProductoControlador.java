package com.example.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.entidades.Producto;
import com.example.servicios.ProductoServicio;


@Controller
@RequestMapping(value = "/Producto")
public class ProductoControlador {

	@Autowired
	ProductoServicio productoService;
	
	/*
	@RequestMapping(method = RequestMethod.GET, value = "/lista")
	public ModelAndView listarProducto() {
		ModelAndView mav = new ModelAndView();
		List<Producto> lProducto = productoService.listarProducto();
		mav.addObject("Productos", lProducto);
		mav.setViewName("Producto/lista");
		return mav;
	}*/
	
	@RequestMapping("/prueba")
	public String hola(Model modelo) {

		return "Producto/Prueba";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView perfilProfesor(@PathVariable("id") long idProducto, HttpServletRequest request) {

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

}
