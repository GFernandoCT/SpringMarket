package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entidades.Usuario;

@Repository
@Component("UsuarioDao")
public class UsuarioDaoImpl extends DaoGenericoImpl<Usuario> implements UsuarioDao{

	@Override
	public Usuario buscarPorNombre(String nombre) {
		Query query =
				this.em.createQuery("select u FROM USUARIO u where u.nombre= :nombre");
				query.setParameter("nombre", nombre);
				Usuario usuario = (Usuario) query.getSingleResult();
				
				if (usuario != null) {
					return usuario;
				}
			
		return null;
	}

	@Override
	public List<Usuario> listarUsuario() {
		Query query = this.em.createQuery("FROM USUARIO");
		List<Usuario> lUsuario= query.getResultList();
		
		if (lUsuario != null) {
			return lUsuario;
		}
		
		return null;
	}

	@Override
	public Usuario iniciar(String nombreUsuario, String contraseña) {
		Query query = this.em.createQuery("select u FROM Usuario u where u.nombreUsuario =: nombre AND u.contraseñaUsuario =: contraseña");
		query.setParameter("nombre", nombreUsuario);
		query.setParameter("contraseña",contraseña);
		Usuario usuario = (Usuario) query.getSingleResult();
		
		if (usuario != null) {
			return usuario;
		}
		
		return null;
	}
	
}
