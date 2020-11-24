package com.example.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entidades.Producto;
import com.example.servicios.ProductoServicio;

@Controller
public class ControladorIndice {
	

	@Autowired
	ProductoServicio productoService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/index")
	public ModelAndView listarOcho() {
		ModelAndView mav = new ModelAndView();
		List<Producto> lProducto = productoService.listarOcho();
		mav.addObject("ProductosOcho", lProducto);
		mav.setViewName("/index");
		return mav;
	}
	
	@RequestMapping(value="/buscar", method=RequestMethod.GET)
	public String buscar_get() {
		
		return "formulario";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/buscar")
	public String buscarNombre(@RequestParam String nombre) {	
		
		return "redirect:/buscar";
	}
	
	
	
	@GetMapping({"/"})
	public String index(Model modelo) {

		return "redirect:/index";
	}
}