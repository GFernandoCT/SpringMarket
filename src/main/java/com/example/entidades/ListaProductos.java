package com.example.entidades;

import java.util.List;

public class ListaProductos {
	
	private List<Producto> productos;
	
	public ListaProductos() {
		super();
	}

	public ListaProductos(List<Producto> productos) {
		super();
		this.productos = productos;
	}
	
	

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
}
