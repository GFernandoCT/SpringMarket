package com.example.entidades;

public class RespuestaDTO {
		
	private Long idRespuesta;
	
	private String textoRespuesta;
	
	private String usuarioRespuesta;
	
	private Long idUsuarioRespuesta;
	
	private String fechaRespuesta;

	private Long idPregunta;
	

	public RespuestaDTO(Long idRespuesta, String textoRespuesta, String usuarioRespuesta, Long idUsuarioRespuesta,
			String fechaRespuesta, Long idPregunta) {
		super();
		this.idRespuesta = idRespuesta;
		this.textoRespuesta = textoRespuesta;
		this.usuarioRespuesta = usuarioRespuesta;
		this.idUsuarioRespuesta = idUsuarioRespuesta;
		this.fechaRespuesta = fechaRespuesta;
		this.idPregunta = idPregunta;
	}
	
	public RespuestaDTO() {
	}

	public Long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getTextoRespuesta() {
		return textoRespuesta;
	}

	public void setTextoRespuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}

	public String getUsuarioRespuesta() {
		return usuarioRespuesta;
	}

	public void setUsuarioRespuesta(String usuarioRespuesta) {
		this.usuarioRespuesta = usuarioRespuesta;
	}

	public Long getIdUsuarioRespuesta() {
		return idUsuarioRespuesta;
	}

	public void setIdUsuarioRespuesta(Long idUsuarioRespuesta) {
		this.idUsuarioRespuesta = idUsuarioRespuesta;
	}

	public String getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(String fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public Long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}
	
}
