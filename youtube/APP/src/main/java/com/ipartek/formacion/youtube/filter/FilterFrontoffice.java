package com.ipartek.formacion.youtube.filter;

import java.io.IOException;
import java.util.Enumeration;

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

import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Filtramos todas las REQUEST que coincidan con urlPatterns = { "/backoffice/*"
 * } <br>
 * Comprobamos que el usuario haya pasado por el login para dejarle
 * continuar.<br>
 * Si el usuario no se ha logeado => redirect "/inicio"
 * 
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/perfil/*" })
public class FilterFrontoffice implements Filter {

	private static final String VIEW_INICIO = "/inicio";

	private static Alert alert;
	private static String view;

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {
			HttpSession session = req.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");

			if (usuario != null) {

				chain.doFilter(request, response); // Pass the request along the filter chain

			} else { // Usuario no logeado

				view = VIEW_INICIO;
				alert = new Alert(Alert.WARNING, "Inicia sesión para acceder al perfil.");
				res.sendRedirect(req.getContextPath() + view + "?alert=" + alert);
			}

		} catch (Exception e) {

			e.printStackTrace();
			alert = new Alert();
			res.sendRedirect(req.getContextPath() + view + "?alert=" + alert);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
