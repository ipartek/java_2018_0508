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
 * Filtramos todas las request que coincidan con urlPatterns = { "/backoffice/*" } <br>
 * Comprobamos que el usuario haya pasado por el login para dejarle continuar. <br>
 * Si el usuario no se ha logeado => redirect a '/inicio'
 */
@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST }, 
		description = "Filtro para comprobar que el usuario se ha logeado a la hora de acceder al backoffice", 
		urlPatterns = { "/backoffice/*" })
public class FilterBackoffice implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Se ejecuta al destruir el hilo/filtro, normalmente cuando se para la aplicación
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Se ejecuta cuando coincide el urlpattern

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		try {
			
			HttpSession session = req.getSession();
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			
			if(usuario != null) {
				// pasa la request a través de la cadena de filtros
				chain.doFilter(request, response);
			}else {
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
		// Se ejecuta cuando arranca el servidor.
	}

}
