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
	private Long idProducto;
	
	@Column(name= "NOMBRE")
	private String nombrePedido;
	
	@Column(name= "CANTIDAD")
	private int cantidadProducto;

	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	public Pedido() {
		super();
	}

	

	public Pedido(Long idProducto, String nombrePedido, int cantidadProducto, Usuario usuario) {
		super();
		this.idProducto = idProducto;
		this.nombrePedido = nombrePedido;
		this.cantidadProducto = cantidadProducto;
	}



	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	
	public String getNombrePedido() {
		return nombrePedido;
	}

	public void setNombrePedido(String nombrePedido) {
		this.nombrePedido = nombrePedido;
	}

	
	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
