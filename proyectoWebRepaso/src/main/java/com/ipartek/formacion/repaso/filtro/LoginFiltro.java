package com.ipartek.formacion.repaso.filtro;

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
 * Servlet Filter implementation class loginFiltro
 */
@WebFilter("/privado/*")
public class LoginFiltro implements Filter {
	
	

    /**
     * Default constructor. 
     */
    public LoginFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {

			HttpSession session = req.getSession();
			boolean acceso=(boolean) session.getAttribute("acceso");

			if (acceso) {
				chain.doFilter(request, response);
			} else {
				// getContextPath() -->Nos devuelve la url
				res.sendRedirect(req.getContextPath() + "/login.jsp");
			}

		} catch (Exception e) {
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
