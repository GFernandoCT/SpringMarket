package dao;

import java.util.List;

import entidades.Producto;

public interface ProductoDao extends DaoGenerico<Producto>{

	public Producto buscarPorNombre(String nombre);
	
	public List<Producto> listarProductos();
	
}
