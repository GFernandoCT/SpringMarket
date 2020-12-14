package com.example.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entidades.Pedido;
import com.example.servicios.ProductoServicio;
import com.example.servicios.UsuarioServicio;

@Controller
@RequestMapping(value= "/compra")
public class CompraControlador {
	
	@Autowired
	ProductoServicio productoService;
	
	@Autowired
	UsuarioServicio usuarioService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/comprar")
	public String perfilPersonal(HttpServletRequest request) {

		HttpSession session = request.getSession();

		if (session != null && session.getAttribute("idUsuario") != null)
			return "redirect:/usuario/perfil/" + session.getAttribute("idUsuario");
		else
			return "redirect:/usuario/login";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/producto/{id}")
	public String producto(@PathVariable("id") long idCompra,
			@RequestParam("cantidad") int cantidadProducto,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("idUsuario") != null) {

			Pedido pedido = new Pedido();
			pedido.setNombrePedido(productoService.obtenerProducto(idCompra).getNombreProducto());
			pedido.setCantidadPedido(cantidadProducto);
			
			usuarioService.añadirPedido((long) session.getAttribute("idUsuario"), pedido);
			return "redirect:/index";
		}
		else
			return "redirect:/usuario/login";
	}
	
	
}
