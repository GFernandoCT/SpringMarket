package com.example.entidades;

public class Carrito{
	
	//private static final long serialVersionUID = -8668594760203621162L;
	
	private ListaProductos productos;
	
	private Usuario usuario;

	public Carrito() {
		super();
	}

	public Carrito(ListaProductos productos, Usuario usuario) {
		super();
		this.productos = productos;
		this.usuario = usuario;
	}

	public ListaProductos getProductos() {
		return productos;
	}

	public void setProductos(ListaProductos productos) {
		this.productos = productos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
