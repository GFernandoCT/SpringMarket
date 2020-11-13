package com.example.controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class ControladorIndice {
	@RequestMapping("/")
	public String hola(Model modelo) {

		return "index";
	}
}
