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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPRA")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPRA")
	private Long idcompra;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario cliente;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "COMPRA_PRODUCTO", joinColumns = @JoinColumn(name = "ID_COMPRA"), inverseJoinColumns = @JoinColumn(name = "ID_PRODUCTO"))
	private Set<Producto> productos = new HashSet<>();
	

	public Long getIdcompra() {
		return idcompra;
	}

	public void setIdcompra(Long idcompra) {
		this.idcompra = idcompra;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}	
	
	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public boolean anadirProducto(Producto producto) {
		producto.anadirCompra(this);
		return getProductos().add(producto);
	}

	public void eliminarProducto(Producto producto) {
		this.productos.remove(producto);
		producto.getCompras().remove(this);
	}
	
	

}
