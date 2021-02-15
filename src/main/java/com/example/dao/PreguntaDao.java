package com.example.dao;

import java.util.List;

import com.example.entidades.Pregunta;
import com.example.entidades.PreguntaDTO;
import com.example.entidades.Producto;

public interface PreguntaDao extends DaoGenerico<Pregunta>{
	public List<Pregunta> mostrarPreguntas(Producto producto);

}
