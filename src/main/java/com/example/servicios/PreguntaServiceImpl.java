package com.example.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PreguntaDao;
import com.example.entidades.Pregunta;

@Transactional
@Service
public class PreguntaServiceImpl implements PreguntaService{

	@Autowired
	private PreguntaDao preguntaDao;
	
	@Override
	public Pregunta crearPregunta(Pregunta pregunta) {
		return preguntaDao.crear(pregunta);
	}

	@Override
	public List<Pregunta> mostrarPreguntasProducto(long idProducto) {
		return preguntaDao.mostrarPreguntas(idProducto);		
	}



}
