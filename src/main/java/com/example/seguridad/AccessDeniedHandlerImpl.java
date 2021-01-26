package com.example.seguridad;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
	
	/*private static Logger LOG =
			 Logger.getLogger(AccessDeniedHandlerImpl.class);
			 */
	
	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response,
			AccessDeniedException ex) throws IOException,
		ServletException {
		Authentication auth =
				SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
	//	log.info(auth.getName()
	//					+ " was trying to access protected resource: "
	//					+ request.getRequestURI());
	 }
	 response.sendRedirect(request.getContextPath() + "/access-denied");
	 }
}
