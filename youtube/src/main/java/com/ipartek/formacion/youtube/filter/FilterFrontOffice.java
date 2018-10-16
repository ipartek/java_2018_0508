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

import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Filtramos todas las request que coincidan con el patron de la url que hemos
 * puesto en el filtro Comprobamos que el usuario haya pasado por el login para
 * dejarle continuar Si el usuario no se ha logueado => redirect /inicio
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/perfil" })
public class FilterFrontOffice implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Se ejecuta al destruir el filtro, parar la app
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			// Siempre que coincida la URL pattern

			// Siempre castear a HttpServletRequest
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;

			HttpSession session = req.getSession();

			Usuario u = (Usuario) session.getAttribute("usuario");

			if (u != null) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}else {
				informacionCliente(req);

				res.sendRedirect(req.getContextPath() + "/inicio");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Mostramos informacion sobre la Request del cliente
	 * 
	 * @param req
	 */
	private void informacionCliente(HttpServletRequest req) {

		System.out.println("-------------------------------------------------------------------");
		System.out.println("--- Remote Host: " + req.getRemoteHost());
		System.out.println("--- Remote Address: " + req.getRemoteAddr());
		System.out.println("--- Remote Port: " + req.getRemotePort());
		System.out.println("--- Remote User: " + req.getRemoteUser());
		System.out.println("--- Local Address: " + req.getLocalAddr());

		System.out.println("------ Cabeceras");
		Enumeration<String> nombreCabeceras = req.getHeaderNames();
		String metadato;
		while (nombreCabeceras.hasMoreElements()) {
			metadato = nombreCabeceras.nextElement();
			System.out.println("--- " + metadato + ":" + req.getHeader(metadato));
		}

		System.out.println("------ Parametros");
		Map<String, String[]> parametros = req.getParameterMap();
		if (parametros.isEmpty()) {
			System.out.println("--- No se pasaron parametros");
		} else {
			for (Map.Entry<String, String[]> parametro : parametros.entrySet()) {
				System.out.println("--- " + parametro.getKey() + ": " + parametro.getValue()[0]);
			}
		}

		System.out.println("--- Locale: " + req.getLocale());
		System.out.println("-------------------------------------------------------------------");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Se ejecuta en la primera peticion
	}

}
