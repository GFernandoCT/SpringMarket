package com.example.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")		
public class Usuario implements Serializable{

	private static final long serialVersionUID = -8668594760203621162L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Compra> compras = new HashSet<>();
	
	@OneToMany(
	mappedBy = "usuario",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Pedido> pedido = new HashSet<>();

	@Column(name= "NOMBRE", unique = true)
	private String nombreUsuario;
	
	@Column(name= "APELLIDOS")
	private String apellidoUsuario;
	
	@Column(name= "CONTRASEÑA")
	private String contraseñaUsuario;
	
	@Column(name= "EMAIL")
	private String emailUsuario;
	
	@Column(name= "FECHA_NAC")
	private String fechaUsuario;
	
	@Column(name= "TARJETA")
	private int tarjetaUsuario;
	
	@Column(name= "TITULAR")
	private String titularUsuario;
	
	@Column(name= "CODIGO")
	private int codigoUsuario;
	
	@Column(name= "DIRECCION")
	private String direccionUsuario;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Usuario() {
		super();
	}

	

	public Usuario(String nombreUsuario, String apellidoUsuario,
			String contraseñaUsuario, String emailUsuario, String fechaUsuario, int tarjetaUsuario,
			String titularUsuario, int codigoUsuario, String direccionUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.contraseñaUsuario = contraseñaUsuario;
		this.emailUsuario = emailUsuario;
		this.fechaUsuario = fechaUsuario;
		this.tarjetaUsuario = tarjetaUsuario;
		this.titularUsuario = titularUsuario;
		this.codigoUsuario = codigoUsuario;
		this.direccionUsuario = direccionUsuario;
	}



	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Set<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(Set<Pedido> pedido) {
		this.pedido = pedido;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getContraseñaUsuario() {
		return contraseñaUsuario;
	}

	public void setContraseñaUsuario(String contraseñaUsuario) {
		this.contraseñaUsuario = contraseñaUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getFechaUsuario() {
		return fechaUsuario;
	}

	public void setFechaUsuario(String fechaUsuario) {
		this.fechaUsuario = fechaUsuario;
	}

	public int getTarjetaUsuario() {
		return tarjetaUsuario;
	}

	public void setTarjetaUsuario(int tarjetaUsuario) {
		this.tarjetaUsuario = tarjetaUsuario;
	}

	public String getTitularUsuario() {
		return titularUsuario;
	}

	public void setTitularUsuario(String titularUsuario) {
		this.titularUsuario = titularUsuario;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getDireccionUsuario() {
		return direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}
	
	public boolean anadirPedidos(Pedido pedido) {
		pedido.setUsuario(this);
		return getPedido().add(pedido);
		}
	
	public void eliminarPedidos(Pedido pedido) {
		getPedido().remove(pedido);
	}

	
	//Metodos One-To-Many con Compra
	
	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	public boolean anadirCompra(Compra compra) {
		compra.setCliente(this);
		return getCompras().add(compra);
	}

	public void eliminarCompra(Compra compra) {
		compra.setCliente(null);
		this.compras.remove(compra);
	}
	
	
	
	
	
}
