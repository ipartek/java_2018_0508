package com.andrea.perez.filter;

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

import com.andrea.perez.pojo.Usuario;

/**
 * Filtramos todas las request que coincidan con urlPatterns = { "/backoffice/*"
 * } Comprobamos que el usuario haya pasado por el login para dejarle continuar
 * Si el usuario no ha pasado por login => redirect "/inicio"
 */

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/backoffice/*" })
public class FilterBackoffice implements Filter {

	public void destroy() {
		// Se ejecuta al destuir el hilo o al parar la app
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Cada vez que coincide la url del filtro se ejecuta
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {

			HttpSession session = req.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");

			if (usuario != null) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			} else {

				// usuario no loggeado
				res.sendRedirect(req.getContextPath() + "/inicio");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "/inicio");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// Se ejecuta en la primera peticion
	}

}
