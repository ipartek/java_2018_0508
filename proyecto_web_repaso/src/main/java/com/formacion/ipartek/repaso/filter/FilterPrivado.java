package com.formacion.ipartek.repaso.filter;

import java.io.IOException;

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

import org.apache.log4j.Logger;

import com.formacion.ipartek.repaso.pojo.Alert;

/**
 * Servlet Filter implementation class FilterPrivado
 */
@WebFilter("/privado/*")
public class FilterPrivado implements Filter {

	// Logger
	private final static Logger LOG = Logger.getLogger(FilterPrivado.class);

	private final static String VIEW_LOGIN = "/login.jsp";
	private final static String VIEW_PRIVADO = "privado/privado.jsp";

	private String view = "";
	private Alert alert = null;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		view = "";
		// Cada vez que coincide la url del filtro se ejecuta
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {

			HttpSession session = req.getSession();
			String usuario = (String) session.getAttribute("usuario");
			String pswd = (String) session.getAttribute("pass");

			if (usuario != null && pswd != null) {
				// pass the request along the filter chain
				view = VIEW_PRIVADO;
				chain.doFilter(request, response);
				alert = null;
				LOG.debug("Sesion iniciada");
			} else {
				// usuario no loggeado
				view = VIEW_LOGIN;
				LOG.debug("Sin sesión");
				alert = new Alert(Alert.ALERT_DANGER, "Debes estar logueado para acceder aqui");
			}

			session.setAttribute("alert", alert);
		} catch (Exception e) {
			LOG.error(e);
			view = VIEW_LOGIN;
		} finally {
			req.setAttribute("alert", alert);
			res.sendRedirect(req.getContextPath() + view);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
