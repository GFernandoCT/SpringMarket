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
				this.em.createQuery("select u FROM Producto u where u.nombre= :nombre");
				query.setParameter("nombre", nombre);
				Producto producto = (Producto) query.getSingleResult();
		return null;
	}

	@Override
	public List<Producto> listarProductos() {
		Query query = this.em.createQuery("FROM Profesor");
		List<Producto> lProducto= query.getResultList();
		
		return null;
	}

}
