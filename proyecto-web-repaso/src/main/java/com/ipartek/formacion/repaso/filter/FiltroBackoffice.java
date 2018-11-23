package com.ipartek.formacion.repaso.filter;

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

/**
 * Filtramos todas las REQUEST que coincidan con urlPatterns = { "/backoffice/*"
 * } <br>
 * Comprobamos que el usuario haya pasado por el login para dejarle
 * continuar.<br>
 * Si el usuario no se ha logeado => redirect "/inicio"
 * 
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/backoffice/*" })
public class FiltroBackoffice implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("se ejecuta al destruir el filtro");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {
			HttpSession session = req.getSession();
			String usuario = (String) session.getAttribute("usuario");

			if (usuario != null) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			} else {
				// usuario no logeado
				session.setAttribute("logear", "Para acceder al privado debes estar logeado");
				res.sendRedirect(req.getContextPath() + "/index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "/index.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("se ejecuta al inciar la App Web");
	}

}