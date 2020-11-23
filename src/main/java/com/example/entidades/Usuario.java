package com.example.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")		
public class Usuario implements Serializable{

	private static final long serialVersionUID = -8668594760203621162L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;

	@Column(name= "NOMBRE")
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

	
	public Usuario() {
		super();

	}

	public Usuario(String nombreUsuario, String apellidoUsuario, String contraseñaUsuario,
			String emailUsuario, String fechaUsuario, int tarjetaUsuario, String titularUsuario, int codigoUsuario,
			String direccionUsuario) {
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
	
	
}
