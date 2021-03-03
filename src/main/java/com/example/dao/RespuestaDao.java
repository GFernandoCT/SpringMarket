package com.example.dao;

import java.util.List;

import com.example.entidades.Pregunta;
import com.example.entidades.Respuesta;

public interface RespuestaDao extends DaoGenerico<Respuesta>{
	
	List<Respuesta> mostrarRespuestas(Pregunta pregunta);

}
