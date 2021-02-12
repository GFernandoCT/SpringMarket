package com.example.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entidades.Pregunta;
import com.example.servicios.PreguntaService;

@Controller
@RequestMapping(value = "/pregunta")
public class PreguntaControlador {
	
	@Autowired
	PreguntaService preguntaService;
	
	@RequestMapping(value = "/buscarUno", method = RequestMethod.GET)
	public Pregunta buscarModulo() {
		Pregunta pregunta = preguntaService.buscarPregunta(1L);
		return pregunta;
	}

}
