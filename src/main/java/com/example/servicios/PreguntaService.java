package com.example.servicios;

import java.util.List;

import com.example.entidades.Pregunta;
import com.example.entidades.PreguntaDTO;
import com.example.entidades.Producto;

public interface PreguntaService {
	
	public Pregunta crearPregunta(Pregunta pregunta);
	
	public List<PreguntaDTO> mostrarPreguntasProducto(Producto producto);

	public PreguntaDTO buscarPregunta(long idPregunta);
	
}
