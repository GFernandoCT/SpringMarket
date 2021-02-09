package com.example.dao;

import java.util.List;

import com.example.entidades.Pregunta;

public interface PreguntaDao extends DaoGenerico<Pregunta>{
	public List<Pregunta> mostrarPreguntas(long idProducto);

}
