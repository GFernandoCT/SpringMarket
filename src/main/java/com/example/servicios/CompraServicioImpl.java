package com.example.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CompraDao;
import com.example.dao.CompraRepository;
import com.example.dao.ProductoDao;
import com.example.dao.UsuarioDao;
import com.example.entidades.Compra;
import com.example.entidades.Pedido;
import com.example.entidades.Producto;
import com.example.entidades.Usuario;

@Transactional
@Service
public class CompraServicioImpl implements CompraServicio {

	@Autowired
	private CompraDao compraDao;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private ProductoDao productoDao;
	
	@Autowired
	private CompraRepository compraRepository;
	
	
	
	@Override
	public List<Compra> listarPedidos(long idUsuario) {
		
		Usuario u = usuarioDao.buscar(idUsuario);
		
		Producto p = productoDao.buscar(1L);
		
		Compra c = new Compra();
		
		c.anadirProducto(p);
		u.anadirCompra(c);
		
		compraRepository.save(c);
		
		Iterable<Compra> listacompras = compraRepository.findAll();
		
		
		// compraDao.listarPedidos(idUsuario);
		
		
		List<Compra> LCompras = new ArrayList<Compra>();
		listacompras.forEach(LCompras::add);
		
		return LCompras;
		
	}

	@Override
	public Compra obtenerPedido(long idPedido) {
		return compraDao.buscar(idPedido);
	}

	@Override
	public Compra crearCompra(Compra compra) {
		return compraDao.crear(compra);
	}
	
}
