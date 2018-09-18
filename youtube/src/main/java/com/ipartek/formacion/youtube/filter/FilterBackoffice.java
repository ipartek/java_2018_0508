package com.ipartek.formacion.youtube.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Filtramos todas las REQUEST que coincidan con URLPattern = { /backoffice/* }
 * Comprobamos que el usuario haya accedido mediante el login para dejarle continuar.
 * Si el usuario no se ha logueado => redirect "inicio"
 */
@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST }
					, 
		description = "Filtro para comprobar si un usuario ha sido logueado.", 
		urlPatterns = {"/backoffice/*"}
		)

public class FilterBackoffice implements Filter {

	HttpServletResponse res;
	HttpServletRequest req;
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Se ejecuta al destruir el servidor
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			// Casteamos el ServletRequest -> HttpServletRequest
			req = (HttpServletRequest) request;
			
			// Casteamos el ServletResponse -> HttpServletResponse
			res = (HttpServletResponse) response;
			
			// Capturamos la session
			HttpSession session = req.getSession();
			
			// Capturamos el usuario de la sesión
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			
			if (usuario != null) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + "/inicio");
			}			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "/inicio");
		}	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Se ejecuta cuando se crea el servidor
	}

}
