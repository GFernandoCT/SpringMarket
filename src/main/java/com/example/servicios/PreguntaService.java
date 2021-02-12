package com.example.servicios;

import java.util.List;

import com.example.entidades.Pregunta;
import com.example.entidades.Producto;

public interface PreguntaService {
	
	public Pregunta crearPregunta(Pregunta pregunta);
	
	public List<Pregunta> mostrarPreguntasProducto(Producto producto);

	public Pregunta buscarPregunta(long idPregunta);
	
}
