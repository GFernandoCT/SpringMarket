package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entidades.Producto;


@Repository
@Component("ProductoDao")
public class ProductoDaoImpl extends DaoGenericoImpl<Producto> implements ProductoDao{

	@Override
	public List<Producto> buscarPorNombre(String nombre) {
		Query query =
				this.em.createQuery("select p FROM Producto p where p.nombreProducto LIKE : nombre");
				query.setParameter("nombre", "%" + nombre + "%");
				List<Producto> productos = query.getResultList();
				
				if(productos != null)
					return productos;

		return null;
	}

	@Override
	public List<Producto> listarProductos() {
		Query query = this.em.createQuery("FROM Producto");
		List<Producto> lProducto= query.getResultList();
		
		if (lProducto != null) {
			return lProducto;
		}
		
		return null;
	}

	@Override
	public List<Producto> listarOcho() {
		Query query = this.em.createQuery("select p FROM Producto p ORDER BY p.id");
		List<Producto> lProducto= query.setMaxResults(8).getResultList();
		
		if(lProducto != null)
			return lProducto;
		else
			return null;
	}		
	

}
