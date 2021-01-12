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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProductoCarro == null) ? 0 : idProductoCarro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoCarrito other = (ProductoCarrito) obj;
		if (idProductoCarro == null) {
			if (other.idProductoCarro != null)
				return false;
		} else if (!idProductoCarro.equals(other.idProductoCarro))
			return false;
		return true;
	}
}
