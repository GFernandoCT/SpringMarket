package com.example.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "ROL")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL")
	private int idRol;

	@Column(name = "NOMBRE_ROL")
	private String nombreRol;

	@ManyToMany(mappedBy="roles",fetch = FetchType.EAGER)
	private Set<Usuario> usuarios;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuario(Set<Usuario> usuario) {
		usuarios = usuario;
	}
	
	public void anadirUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		usuario.getRoles().add(this);
	}
	
	public void deleteProfesor(Usuario usuario) {
		this.usuarios.remove(usuario) ;
	}

	
}