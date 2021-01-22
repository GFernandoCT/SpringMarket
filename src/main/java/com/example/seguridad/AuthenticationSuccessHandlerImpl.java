package com.example.seguridad;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.entidades.Usuario;
import com.example.servicios.UsuarioServicio;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
	
	@Autowired
	private UsuarioServicio usuarioService;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response,
			Authentication authentication) throws IOException {
		
	UserDetails userDetails = (UserDetails)
	SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
	HttpSession session = request.getSession();
	
	
	Usuario authUser =
	usuarioService.buscarPorNombreUsuario(userDetails.getUsername());
	session.setAttribute("email", authUser.getEmailUsuario());
	session.setAttribute("nombre", authUser.getNombreUsuario());
	session.setAttribute("idUsuario", authUser.getIdUsuario());
	
	boolean isCliente = false;
	boolean isAdmin = false;
	
	final Collection<? extends GrantedAuthority> authorities =
			authentication.getAuthorities();
	for (final GrantedAuthority grantedAuthority : authorities) {
		if (grantedAuthority.getAuthority().equals("ROL_CLIENTE")) {
			isCliente = true;
			break;
		} else if (grantedAuthority.getAuthority().equals("ROL_ADMIN")) {
			isAdmin = true;
			break;
		}
	}
	
	String targetUrl;
	if(isCliente) {
		targetUrl = "/usuario/myprofile";
	} else if (isAdmin) {
		targetUrl = "/index";
	} else {
		throw new IllegalStateException();
	}
	
	redirectStrategy.sendRedirect(request, response, targetUrl);
	}

}
