package com.ipartek.formacion.youtube.controller.perfil;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BackofficeController
 */
@WebServlet("/perfil/inicio")
public class PerfilController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW_INICIO = "/perfil/index.jsp";
    
	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
	}
	
	public void destroy() {	
		super.destroy();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
						
		}catch (Exception e) {
			e.printStackTrace();
		}finally {			
			request.getRequestDispatcher(VIEW_INICIO).forward(request, response);
		}
		
		
	}

}
