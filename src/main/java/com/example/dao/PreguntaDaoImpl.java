package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entidades.Pregunta;
import com.example.entidades.Producto;

@Repository
@Component("PreguntaDao")
public class PreguntaDaoImpl extends DaoGenericoImpl<Pregunta> implements PreguntaDao{

	@Override
	public List<Pregunta> mostrarPreguntas(Producto producto) {
		Query query = this.em.createQuery("select u from Pregunta u where u.producto =: idProducto");
		query.setParameter("idProducto", producto);
		List<Pregunta> lPedido = query.getResultList();
		if(lPedido != null)
			return lPedido;
		return null;
	}

}
