package com.example.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ProductoDao;
import com.example.entidades.Producto;

@Transactional
@Service
public class ProductoServiceImpl implements ProductoServicio{

	@Autowired
	private ProductoDao productoDao;

	@Override
	public Producto crearProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarProducto(long idProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto obtenerProducto(long idProducto) {
		return productoDao.buscar(idProducto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listarProducto() {
		return productoDao.listarProductos();
	}
	
	
}
