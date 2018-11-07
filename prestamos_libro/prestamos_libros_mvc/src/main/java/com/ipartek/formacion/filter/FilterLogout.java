package com.ipartek.formacion.filter;

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

/**
 * Servlet Filter implementation class FilterLogout
 */
@WebFilter("/prestamo/*")

public class FilterLogout implements Filter {

	private static final String USER = "ander";
	private static final String PASS = "12345";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Cada vez que coincide la url del filtro se ejecuta
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {

			HttpSession session = req.getSession();
			String user = (String) session.getAttribute("user");
			String pass = (String) session.getAttribute("pass");

			if (user!=null && pass!= null && user.equals(USER) && pass.equals(PASS)) {
				// pass the request along the filter chain
				chain.doFilter(request, response);

			} else {
				// usuario no loggeado
				res.sendRedirect(req.getContextPath() + "/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}

	@Override
	public void destroy() {
		
	}

}