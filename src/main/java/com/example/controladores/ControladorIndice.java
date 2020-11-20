package com.example.controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


public class ControladorIndice {
	@GetMapping({"/","/index"})
	public String index(Model modelo) {

		return "index";
	}
}
