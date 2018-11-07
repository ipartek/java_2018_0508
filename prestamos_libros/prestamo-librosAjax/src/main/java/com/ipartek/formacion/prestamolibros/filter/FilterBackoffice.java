package com.ipartek.formacion.prestamolibros.filter;

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

import com.ipartek.formacion.prestamolibros.pojo.Alert;
import com.ipartek.formacion.prestamolibros.pojo.Usuario;

/**
 * Filtramos todas las REQUEST que coincidan con urlPatterns = { "/backoffice/*"
 * } <br>
 * Comprobamos que el usuario haya pasado por el login para dejarle
 * continuar.<br>
 * Si el usuario no se ha logeado => redirect "/inicio"
 * 
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/backoffice/*" })
public class FilterBackoffice implements Filter {
	
	Alert alert;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("se ejecuta al destruir el filtro");
	}

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

			if (usuario != null && usuario.getNombre().equals(Usuario.NOMBRE_ADMIN )&& usuario.getPassword().equals(Usuario.PASS_ADMIN)) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			} else {
				alert= new Alert(Alert.DANGER, "Debe introducir su nombre de usuario y contraseña para acceder a la app");
				session.setAttribute("alert", alert);
				// usuario no logeado
				res.sendRedirect(req.getContextPath() + "/login.jsp");
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("se ejecuta al inciar la App Web");
	}

	
}
