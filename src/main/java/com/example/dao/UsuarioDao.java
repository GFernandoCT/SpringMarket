package com.example.dao;

import java.util.List;

import com.example.entidades.Pedido;
import com.example.entidades.Usuario;

public interface UsuarioDao extends DaoGenerico<Usuario>{

	public Usuario buscarPorNombre(String nombre);
	
	public List<Usuario> listarUsuario();

	public Usuario iniciar(String nombreUsuario, String contraseña);
	
	public Usuario añadirCompra(long idUsuario, Pedido pedido);
}
