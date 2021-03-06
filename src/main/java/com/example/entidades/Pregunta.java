package com.example.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PREGUNTA")
public class Pregunta {
	
	private static final long serialVersionUID = -8668594760203621162L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PREGUNTA")
	private Long idPregunta;
	
	@Column(name = "TEXTOPREGUNTA")
	private String textoPregunta;
	
	@Column(name = "FECHAPREGUNTA")
	private String fechaPregunta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUCTO")
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario cliente;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pregunta", orphanRemoval = true)
	private Set<Respuesta> respuesta = new HashSet<>();

	
	// Metodos respuesta relacion one to many
	public Set<Respuesta> getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Set<Respuesta> respuesta) {
		this.respuesta = respuesta;
	}
	
	public void anadirRespuesta(Respuesta respuesta) {
		this.respuesta.add(respuesta);
		respuesta.setPregunta(this);
	}
	
	public void eliminarRespuesta(Respuesta respuesta) {
		respuesta.setPregunta(null);
		this.respuesta.remove(respuesta);
	}

	public Pregunta() {
		super();
	}
	
	public Pregunta(String textoPregunta, String fechaPregunta) {
		super();
		this.textoPregunta = textoPregunta;
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

	public String getFechaPregunta() {
		return fechaPregunta;
	}

	public void setFechaPregunta(String fechaPregunta) {
		this.fechaPregunta = fechaPregunta;
	}

	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	
}
