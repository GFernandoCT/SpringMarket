package com.example.servicios;

import java.util.List;

import com.example.entidades.Pregunta;

public interface PreguntaService {
	
	public Pregunta crearPregunta(Pregunta pregunta);
	
	public List<Pregunta> mostrarPreguntasProducto(long idProducto);

}
