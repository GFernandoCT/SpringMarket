package com.example.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name  = "RESPUESTA")
public class Respuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESPUESTA")
	private Long idRespuesta;
	
	@Column(name = "TEXTORESPUESTA")
	private String textoRespuesta;
	
	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	@Column(name = "FECHARESPUESTA")
	private String fechaRespuesta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PREGUNTA")
	private Pregunta pregunta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario cliente;

	
	public Respuesta() {
		super();
	}
	
	public Respuesta(String textoRespuesta, String fechaRespuesta) {
		super();
		this.textoRespuesta = textoRespuesta;
		this.fechaRespuesta = fechaRespuesta;
	}
	
	public Long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(Long idPregunta) {
		this.idRespuesta = idPregunta;
	}

	public String getTextoRespuesta() {
		return textoRespuesta;
	}

	public void setTextoRespuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}

	public String getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(String fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	
}
