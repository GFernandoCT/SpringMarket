package servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ProductoDao;
import entidades.Producto;

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
