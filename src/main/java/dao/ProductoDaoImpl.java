package dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import entidades.Producto;


@Repository
@Component("ProductoDao")
public class ProductoDaoImpl extends DaoGenericoImpl<Producto> implements ProductoDao{

	@Override
	public Producto buscarPorNombre(String nombre) {
		Query query =
				this.em.createQuery("select u FROM PRODUCTO u where u.nombre= :nombre");
				query.setParameter("nombre", nombre);
				Producto producto = (Producto) query.getSingleResult();
				
				if (producto != null) {
					return producto;
				}
			
		return null;
	}

	@Override
	public List<Producto> listarProductos() {
		Query query = this.em.createQuery("FROM PRODUCTO");
		List<Producto> lProducto= query.getResultList();
		
		if (lProducto != null) {
			return lProducto;
		}
		
		return null;
	}

}
