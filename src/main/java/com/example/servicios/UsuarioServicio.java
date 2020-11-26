package com.example.servicios;

import java.util.List;

import com.example.entidades.Producto;
import com.example.entidades.Usuario;

public interface UsuarioServicio {

		public Usuario crearUsuario(Usuario usuario);
		
		public void eliminarUsuario(long idUsuario);

		public Usuario obtenerUsuario(long idUsuario);
		
		public Usuario modificarUsuario(Usuario usuario);

		public List<Usuario> listarUsuario();

		public Usuario iniciarSesion(String nombreUsuario,String contraseña);
		
}
