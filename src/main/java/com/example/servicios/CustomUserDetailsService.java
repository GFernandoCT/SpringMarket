package com.example.servicios;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UsuarioDao;
import com.example.entidades.Rol;
import com.example.entidades.Usuario;

@Transactional
@Service
public class CustomUserDetailsService implements  UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	@Transactional()
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.buscarPorNombre(nombre);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Rol rol : usuario.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombreRol()));
		}

		return new org.springframework.security.core.userdetails.User(usuario.getNombreUsuario(), usuario.getContraseñaUsuario(),
				grantedAuthorities);
	}
}