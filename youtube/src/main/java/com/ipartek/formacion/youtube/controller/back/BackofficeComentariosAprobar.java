package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/comentarios/aprobar")
public class BackofficeComentariosAprobar extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	private static ComentarioDAO daoComentario = null;
	
	private static final String VIEW_APROBAR = "comentarios/aprobar.jsp";
	private String view;
	private Alert alert;		
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		daoComentario  = ComentarioDAO.getInstance();
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
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doProcess(request, response);		
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			alert = new Alert();
			view = VIEW_APROBAR;
			
		}catch (Exception e) {
			e.printStackTrace();
			view = VIEW_APROBAR;
			alert = new Alert();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);			
		}
		
	}

}
