package com.example.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PEDIDO")
public class Pedido implements Serializable{

	private static final long serialVersionUID = -8668594760203621162L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "ID_PEDIDO")
	private Long idPedido;
	
	@Column(name= "NOMBRE")
	private String nombrePedido;
	
	@Column(name= "CANTIDAD")
	private int cantidadPedido;

	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	public Pedido() {
		super();
	}

	

	public Pedido(Long idPedido, String nombrePedido, int cantidadPedido, Usuario usuario) {
		super();
		this.idPedido = idPedido;
		this.nombrePedido = nombrePedido;
		this.cantidadPedido = cantidadPedido;
	}


	
	public Long getIdPedido() {
		return idPedido;
	}



	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}



	public int getCantidadPedido() {
		return cantidadPedido;
	}



	public void setCantidadPedido(int cantidadPedido) {
		this.cantidadPedido = cantidadPedido;
	}



	public String getNombrePedido() {
		return nombrePedido;
	}

	public void setNombrePedido(String nombrePedido) {
		this.nombrePedido = nombrePedido;
	}

	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
