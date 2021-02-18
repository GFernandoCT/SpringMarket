package com.example.controladores;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entidades.Pregunta;
import com.example.entidades.PreguntaDTO;
import com.example.entidades.Producto;
import com.example.entidades.Usuario;
import com.example.servicios.PreguntaService;
import com.example.servicios.ProductoServicio;
import com.example.servicios.UsuarioServicio;

@Controller
@RequestMapping(value = "/pregunta")
public class PreguntaControlador {
	
	@Autowired
	PreguntaService preguntaService;
	
	@Autowired
	UsuarioServicio usuarioService;
	
	@Autowired
	ProductoServicio productoService;
	
	@RequestMapping(value = "/preguntas/{preguntaSubir}/{idProducto}", method = RequestMethod.POST)
	@ResponseBody
	public PreguntaDTO anadirPregunta(@PathVariable("preguntaSubir") String pregunta,
			@PathVariable("idProducto") String idProducto,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("idUsuario") != null) {
			
		Usuario usuario = usuarioService.obtenerUsuario((long) request.getSession().getAttribute("idUsuario"));
		
		Date fecha = new Date();	
		
		pregunta = "¿" + pregunta + "?";
		
		Pregunta preguntaCompleta = new Pregunta(pregunta,fecha.toString());

		Producto producto = productoService.obtenerProducto(Long.parseLong(idProducto));
		
		producto.anadirPregunta(preguntaCompleta);
		usuario.anadirPregunta(preguntaCompleta);
		
		Pregunta p = preguntaService.crearPregunta(preguntaCompleta);
		
		return preguntaService.buscarPreguntaDTO(p.getIdPregunta());
		
		}
		else return null;
	
	}
	
	@RequestMapping(value = "/eliminarPregunta/{idPregunta}", method = RequestMethod.POST)
	@ResponseBody
	public long eliminarPregunta(@PathVariable("idPregunta") Long idPregunta,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("idUsuario") != null) {
			preguntaService.borrarPregunta(idPregunta);
			return idPregunta;
			}
			else return 0L;
	}
	
	/*@RequestMapping(value = "/buscarUno", method = RequestMethod.GET)
	public PreguntaDTO buscarModulo() {
		PreguntaDTO pregunta = preguntaService.buscarPregunta(1L);
		return pregunta;
	}*/

}
