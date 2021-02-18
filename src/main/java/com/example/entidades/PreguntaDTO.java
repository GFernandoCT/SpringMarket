package com.example.entidades;

public class PreguntaDTO {

	private Long idPregunta;
	
	private String textoPregunta;
	
	private String usuarioPregunta;
	
	private Long idUsuarioPregunta;
	
	private String fechaPregunta;

	private Long idProducto;
	
	private String nombreProducto;

	public PreguntaDTO(Long idPregunta, String textoPregunta, String usuarioPregunta, Long idUsuarioPregunta, String fechaPregunta,
			Long idProducto, String nombreProducto) {
		super();
		this.idPregunta = idPregunta;
		this.textoPregunta = textoPregunta;
		this.usuarioPregunta = usuarioPregunta;
		this.idUsuarioPregunta = idUsuarioPregunta;
		this.fechaPregunta = fechaPregunta;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
	}

	public PreguntaDTO() {
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

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Long getIdUsuarioPregunta() {
		return idUsuarioPregunta;
	}

	public void setIdUsuarioPregunta(Long idUsuarioPregunta) {
		this.idUsuarioPregunta = idUsuarioPregunta;
	}
	
	
	
}
