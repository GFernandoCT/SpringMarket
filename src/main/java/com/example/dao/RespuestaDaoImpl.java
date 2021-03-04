package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entidades.Pregunta;
import com.example.entidades.Respuesta;


@Repository
@Component("RespuestaDao")
public class RespuestaDaoImpl extends DaoGenericoImpl<Respuesta> implements RespuestaDao{

	@Override
	public List<Respuesta> mostrarRespuestas(Pregunta pregunta) {
		Query query = this.em.createQuery("select u from Respuesta u where u.pregunta =: Pregunta");
		query.setParameter("Pregunta", pregunta);
		List<Respuesta> lPreguntas = query.getResultList();
		if(lPreguntas != null)
			return lPreguntas;
		return null;
	}

}
