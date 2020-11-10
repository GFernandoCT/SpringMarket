package servicios;

import java.util.List;

import entidades.Producto;

public interface ProductoServicio {

	public Producto crearProducto(Producto producto);
	
	public void eliminarProducto(long idProducto);

	public Producto obtenerProducto(long idProducto);
	
	public Producto modificarProducto(Producto producto);

	public List<Producto> listarProducto();
}
