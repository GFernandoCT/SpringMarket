package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entidades.Producto;
import servicios.ProductoServicio;

@Controller
@RequestMapping(value = "/producto")
public class ProductoControlador {

	@Autowired
	ProductoServicio productoServicio;

	@RequestMapping(method = RequestMethod.GET, value = "/lista")
	public ModelAndView listarProducto() {
		ModelAndView mav = new ModelAndView();
		List<Producto> lProducto = productoServicio.listarProducto();
		mav.addObject("Productos", lProducto);
		mav.setViewName("Producto/lista");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/perfil/{id}")
	public ModelAndView perfilProfesor(@PathVariable("id") long idProducto, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Producto producto = productoServicio.obtenerProducto(idProducto);
		Boolean propietario = false;

		if (request.getSession().getAttribute("idUsuario") != null) {
			long idSession = (long) request.getSession().getAttribute("idUsuario");
			propietario = idSession == idProducto;
		}

		mav.addObject("propietario", propietario);
		mav.addObject("producto", producto);
		mav.setViewName("producto/perfil");
		return mav;
	}

}
