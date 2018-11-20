package com.ipartek.formacion.youtube.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

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

import com.ipartek.formacion.youtube.Usuario;

/**
 * Filtramos todas las request que coincidan con urlPatterns = {
 * "/backoffice/*"} <br>
 * Comprobamos que el usuario haya pasado por el login para dejarle continuar.
 * <br>
 * si el usuario no se ha logeado => redirect "/inicio" <br>
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/backoffice/*" })
public class FilterBackoffice implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterBackoffice() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// se ejecuta al destruir el filtro
	}

	/**
	 * @throws IOException
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {
			HttpSession session = req.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");

			if (usuario != null) {

				// pass the request along the filter chain encadenar
				chain.doFilter(request, response);
			} else {
				
				//TODO comprobar ROL del usuario

				informacionCliente(req);
				
				//usuario no logeado

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
		System.out.println("se ejecuta al inicia App web");

		/**
		 * MOstamos informacion sobre la request del cliente
		 */

	}

	private void informacionCliente(HttpServletRequest req) {
		System.out.println("-----------------------------------------------------------");

		System.out.println("RemoteHost : " + req.getRemoteHost());
		System.out.println("RemoteHost : " + req.getRemoteAddr());
		System.out.println("RemoteHost : " + req.getRemotePort());
		System.out.println("RemoteHost : " + req.getRemoteUser());

		Enumeration nombresCabeceras = req.getHeaderNames();
		String metadato;
		while (nombresCabeceras.hasMoreElements()) {
			metadato = (String) nombresCabeceras.nextElement();
			System.out.println(metadato + ":" + req.getHeader(metadato));

		}
		System.out.println("");
		System.out.println("parametros:");

		Enumeration<String> parameterNames = req.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String key = (String) parameterNames.nextElement();
			String val = req.getParameter(key);
			System.out.println("parametros = <" + key + "><" + val + ">");

			System.out.println("-----------------------------------------------------------");

		}

	}
}
