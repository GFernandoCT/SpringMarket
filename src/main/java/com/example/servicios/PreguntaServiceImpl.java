package com.example.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PreguntaDao;
import com.example.entidades.Pregunta;
import com.example.entidades.PreguntaDTO;
import com.example.entidades.Producto;

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
	public List<PreguntaDTO> mostrarPreguntasProducto(Producto producto) {
		
		List<PreguntaDTO> preguntitas = new ArrayList<>();
		List<Pregunta> preguntas =  preguntaDao.mostrarPreguntas(producto);
		
		for(Pregunta p : preguntas) {
			
			PreguntaDTO dto = new PreguntaDTO();
		
			dto.setIdPregunta(p.getIdPregunta());
		    dto.setTextoPregunta(p.getTextoPregunta());
		    dto.setFechaPregunta(p.getFechaPregunta());
		    dto.setUsuarioPregunta(p.getCliente().getNombreUsuario());
		    dto.setIdUsuarioPregunta(p.getCliente().getIdUsuario());
		    dto.setIdProducto(p.getProducto().getIdProducto());
		    dto.setNombreProducto(p.getProducto().getNombreProducto());
		    
		    preguntitas.add(dto);
		}
		
		return preguntitas;
	}

	@Override
	public PreguntaDTO buscarPreguntaDTO(long idPregunta) {
		
		Pregunta p = preguntaDao.buscar(idPregunta);
		
		PreguntaDTO dto = new PreguntaDTO();
		dto.setIdPregunta(p.getIdPregunta());
	    dto.setTextoPregunta(p.getTextoPregunta());
	    dto.setFechaPregunta(p.getFechaPregunta());
	    dto.setUsuarioPregunta(p.getCliente().getNombreUsuario());
	    dto.setIdUsuarioPregunta(p.getCliente().getIdUsuario());
	    dto.setIdProducto(p.getProducto().getIdProducto());
	    dto.setNombreProducto(p.getProducto().getNombreProducto());
		
		return dto;
	}

	@Override
	public Pregunta buscarPregunta(long idPregunta) {
		Pregunta p = preguntaDao.buscar(idPregunta);
		return p;
	}

	@Override
	public void borrarPregunta(long idPregunta) {
		preguntaDao.borrar(idPregunta);
	}
	
	

}
