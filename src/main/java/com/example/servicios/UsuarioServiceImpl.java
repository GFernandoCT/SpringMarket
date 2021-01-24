package com.example.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UsuarioDao;
import com.example.entidades.Pedido;
import com.example.entidades.Usuario;

@Transactional
@Service
public class UsuarioServiceImpl implements UsuarioServicio{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Usuario crearUsuario(Usuario usuario) {
		usuario.setContraseñaUsuario(bCryptPasswordEncoder.encode(usuario.getContraseñaUsuario()));
		return usuarioDao.crear(usuario);
	}

	@Override
	public void eliminarUsuario(long idUsuario) {
		usuarioDao.borrar(idUsuario);
	}

	@Override
	public Usuario obtenerUsuario(long idUsuario) {
		return usuarioDao.buscar(idUsuario);
	}

	@Override
	public Usuario modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listarUsuario() {
		return usuarioDao.listarUsuario();
	}

	@Override
	public Usuario iniciarSesion(String nombreUsuario) {
		return usuarioDao.iniciar(nombreUsuario);
	}

	@Override
	public Usuario añadirPedido(long idUsuario, Pedido pedido) {
		return usuarioDao.añadirCompra(idUsuario, pedido);
	}

	@Override
	public Usuario buscarPorNombreUsuario(String username) {
		return usuarioDao.buscarPorNombre(username);
	}

}
