package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.ComentarioDAO;

/**
 * Servlet implementation class BackofficeComentarioAprobarController
 */
@WebServlet("/backoffice/comentarios/aprobar")
public class BackofficeComentarioAprobarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ComentarioDAO daoComentario;
	
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoComentario = ComentarioDAO.getInstance();
		
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoComentario = null;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("comentarios", daoComentario.getAllByAprobado());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		request.getRequestDispatcher("../comentarios/aprobar.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ids[] = request.getParameterValues("id");
		
		long[] data = new long[ids.length];
		for (int i = 0; i < ids.length; i++) {
		  data[i] = Long.valueOf(ids[i]);
		}
		
		try {
			if(daoComentario.aprobar(data)){
				request.setAttribute("comentarios", daoComentario.getAllByAprobado());
				request.getRequestDispatcher("../comentarios/aprobar.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

}
