package com.example.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

	private static final long serialVersionUID = -8668594760203621162L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCTO")
	private Long idProducto;

	@Column(name = "MARCA")
	private String marcaProducto;

	@Column(name = "NOMBRE")
	private String nombreProducto;

	@Column(name = "CATEGORIA")
	private String categoriaProducto;

	@Column(name = "DESCRIPCION")
	private String descripcionProducto;

	@Column(name = "PRECIO")
	private int precioProducto;

	@Column(name = "DESCUENTO")
	private int descuentoProducto;

	@ManyToMany(mappedBy = "productos")
	private Set<Compra> compras = new HashSet<>();

	public void anadirCompra(Compra compra) {
		this.compras.add(compra);
		compra.getProductos().add(this);
	}

	public void eliminarCompra(Compra compra) {
		this.compras.remove(compra);
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	public Producto() {
		super();
	}

	public Producto(String marcaProducto, String nombreProducto, String categoriaProducto, String descripcionProducto,
			int precioProducto, int descuentoProducto) {
		super();
		this.marcaProducto = marcaProducto;
		this.nombreProducto = nombreProducto;
		this.categoriaProducto = categoriaProducto;
		this.descripcionProducto = descripcionProducto;
		this.precioProducto = precioProducto;
		this.descuentoProducto = descuentoProducto;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getMarcaProducto() {
		return marcaProducto;
	}

	public void setMarcaProducto(String marcaProducto) {
		this.marcaProducto = marcaProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public int getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getDescuentoProducto() {
		return descuentoProducto;
	}

	public void setDescuentoProducto(int descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}

}
