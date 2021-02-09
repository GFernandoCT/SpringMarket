package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entidades.Pregunta;

@Repository
@Component("PreguntaDao")
public class PreguntaDaoImpl extends DaoGenericoImpl<Pregunta> implements PreguntaDao{

	@Override
	public List<Pregunta> mostrarPreguntas(long idProducto) {
		Query query = this.em.createQuery("select u from PREGUNTA u where u.producto =: idProducto");
		query.setParameter("idProducto", idProducto);
		List<Pregunta> lPedido = query.getResultList();
		return lPedido;
	}

}
