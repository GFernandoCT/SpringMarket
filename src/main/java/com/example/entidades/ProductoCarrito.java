package com.example.entidades;


public class ProductoCarrito {

	private Long idProductoCarro;
	
	private String nombreProductoCarro;
	
	private int cantidadProductoCarro;

	public ProductoCarrito() {
		super();
	}

	public ProductoCarrito(Long idProductoCarro, String nombreProductoCarro, int cantidadProductoCarro) {
		super();
		this.idProductoCarro = idProductoCarro;
		this.nombreProductoCarro = nombreProductoCarro;
		this.cantidadProductoCarro = cantidadProductoCarro;
	}

	public Long getIdProductoCarro() {
		return idProductoCarro;
	}

	public void setIdProductoCarro(Long idProductoCarro) {
		this.idProductoCarro = idProductoCarro;
	}

	public String getNombreProductoCarro() {
		return nombreProductoCarro;
	}

	public void setNombreProductoCarro(String nombreProductoCarro) {
		this.nombreProductoCarro = nombreProductoCarro;
	}

	public int getCantidadProductoCarro() {
		return cantidadProductoCarro;
	}

	public void setCantidadProductoCarro(int cantidadProductoCarro) {
		this.cantidadProductoCarro = cantidadProductoCarro;
	}
	
}
