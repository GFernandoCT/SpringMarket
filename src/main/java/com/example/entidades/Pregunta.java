package com.example.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PREGUNTA")
public class Pregunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PREGUNTA")
	private Long idPregunta;
	
	@Column(name = "TEXTOPREGUNTA")
	private String textoPregunta;
	
	@Column(name = "USUARIOPREGUNTA")
	private String usuarioPregunta;
	
	@Column(name = "FECHAPREGUNTA")
	private String fechaPregunta;

	public Pregunta() {
		super();
	}
	
	public Pregunta(String textoPregunta, String usuarioPregunta, String fechaPregunta) {
		super();
		this.textoPregunta = textoPregunta;
		this.usuarioPregunta = usuarioPregunta;
		this.fechaPregunta = fechaPregunta;
	}

	public Long getIdPregunta() {
		return idPregunta;
	}
	
	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getTextoPregunta() {
		return textoPregunta;
	}

	public void setTextoPregunta(String textoPregunta) {
		this.textoPregunta = textoPregunta;
	}

	public String getUsuarioPregunta() {
		return usuarioPregunta;
	}

	public void setUsuarioPregunta(String usuarioPregunta) {
		this.usuarioPregunta = usuarioPregunta;
	}

	public String getFechaPregunta() {
		return fechaPregunta;
	}

	public void setFechaPregunta(String fechaPregunta) {
		this.fechaPregunta = fechaPregunta;
	}

}
