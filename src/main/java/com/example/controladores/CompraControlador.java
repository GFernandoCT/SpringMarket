package com.example.controladores;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.CompraRepository;
import com.example.entidades.Compra;
import com.example.entidades.Producto;
import com.example.entidades.ProductoCarrito;
import com.example.entidades.Usuario;
import com.example.servicios.CompraServicio;
import com.example.servicios.ProductoServicio;
import com.example.servicios.UsuarioServicio;

@Controller
@RequestMapping(value = "/compra")
public class CompraControlador {

	@Autowired
	ProductoServicio productoService;

	@Autowired
	UsuarioServicio usuarioService;

	@Autowired
	CompraServicio compraService;

	@Autowired
	CompraRepository compraRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/comprar")
	public String perfilPersonal(HttpServletRequest request) {

		HttpSession session = request.getSession();

		if (session != null && session.getAttribute("idUsuario") != null)
			return "redirect:/usuario/perfil/" + session.getAttribute("idUsuario");
		else
			return "redirect:/usuario/login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/producto/pedido")
	public String comprarCarrito(HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("idUsuario") != null) {

			@SuppressWarnings("unchecked")
			Set<Producto> listaPedidos = (Set<Producto>) request.getSession().getAttribute("CARRITO");

			Compra compra = new Compra(usuarioService.obtenerUsuario((long) session.getAttribute("idUsuario")));
			for (Producto producto : listaPedidos) {
				compra.anadirProducto(producto);
			}

			compraService.crearCompra(compra);

			Usuario usuario = usuarioService.obtenerUsuario((long) request.getSession().getAttribute("idUsuario"));
			usuario.anadirCompra(compra);

			// Vaciar carrito
			Set<ProductoCarrito> vacio = new HashSet<>();
			request.getSession().setAttribute("CARRITO", vacio);

			return "redirect:/compra/miscompras";
		} else
			return "redirect:/usuario/login";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/miscompras")
	public ModelAndView mostrarCompra(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		List<Compra> lPedido = compraService.listarPedidos2((long) request.getSession().getAttribute("idUsuario"));
		mav.addObject("compra", lPedido);
		mav.setViewName("usuario/miscompras");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "devolver/{id}")
	public String devolverProducto(@PathVariable("id") long idProducto, @RequestParam("idPedido") long idPedido,
			HttpServletRequest request) {

		//TODO BORRAR COMPRA SI ESTA VACIA
		
		Compra compra = compraService.obtenerPedido(idPedido);
		compra.eliminarProducto(productoService.obtenerProducto(idProducto));
		compraService.obtenerPedido(compra.getIdcompra());

		return "redirect:/compra/miscompras";
	}

}
