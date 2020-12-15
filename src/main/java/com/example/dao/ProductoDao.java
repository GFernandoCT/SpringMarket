package com.example.dao;

import java.util.List;

import com.example.entidades.Producto;

public interface ProductoDao extends DaoGenerico<Producto>{

	public List<Producto> buscarPorNombre(String nombre);
	
	public List<Producto> listarProductos();
	
	public List<Producto> listarOcho();
	
}
