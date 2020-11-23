package com.example.dao;

import java.util.List;

import com.example.entidades.Producto;
import com.example.entidades.Usuario;

public interface UsuarioDao extends DaoGenerico<Usuario>{

	public Usuario buscarPorNombre(String nombre);
	
	public List<Usuario> listarUsuario();
}
