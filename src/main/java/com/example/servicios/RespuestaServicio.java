package com.example.servicios;

import java.util.List;

import com.example.entidades.Pregunta;
import com.example.entidades.Respuesta;
import com.example.entidades.RespuestaDTO;

public interface RespuestaServicio {

	public Respuesta crearRespuesta(Respuesta respuesta);
	
	public List<RespuestaDTO> mostrarRespuestasPregunta(Pregunta pregunta);
	
	public RespuestaDTO buscarRespuestaDTO(long idRespuesta);
	
	public Respuesta buscarRespuesta(long idRespuesta);
	
	public void borrarRespuesta(long idRespuesta);
	
}
