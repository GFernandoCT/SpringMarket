package com.example.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.RespuestaDao;
import com.example.entidades.Pregunta;
import com.example.entidades.PreguntaDTO;
import com.example.entidades.Respuesta;
import com.example.entidades.RespuestaDTO;

@Transactional
@Service
public class RespuestaServicioImpl implements RespuestaServicio{
	
	@Autowired
	private RespuestaDao respuestaDao;

	@Override
	public Respuesta crearRespuesta(Respuesta respuesta) {
		return respuestaDao.crear(respuesta);
	}

	@Override
	public Respuesta buscarRespuesta(long idRespuesta) {
		return respuestaDao.buscar(idRespuesta);
	}

	@Override
	public void borrarRespuesta(long idRespuesta) {
		respuestaDao.borrar(idRespuesta);
		
	}

	@Override
	public RespuestaDTO buscarRespuestaDTO(long idRespuesta) {
		Respuesta r = respuestaDao.buscar(idRespuesta);
		
		RespuestaDTO dto = new RespuestaDTO();
		dto.setIdRespuesta(r.getIdRespuesta());
	    dto.setTextoRespuesta(r.getTextoRespuesta());
	    dto.setFechaRespuesta(r.getFechaRespuesta());
	    dto.setUsuarioRespuesta(r.getCliente().getNombreUsuario());
	    dto.setIdUsuarioRespuesta(r.getCliente().getIdUsuario());
	    dto.setIdPregunta(r.getPregunta().getIdPregunta());
		
		return dto;
	}

	@Override
	public List<RespuestaDTO> mostrarRespuestasPregunta(Pregunta pregunta) {
		
	//TODO mostrarPreguntas
		
		List<RespuestaDTO> respuestasDTO = new ArrayList<>();
		List<Respuesta> respuestas =  respuestaDao.mostrarRespuestas(pregunta);
		
		for(Pregunta p : respuestas) {
		}
		

		
		return null;
	}	


}
