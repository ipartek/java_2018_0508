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
 * Servlet implementation class BackofficeComentarioAprobarController
 */
@WebServlet("/backoffice/comentarios/aprobar")
public class BackofficeComentarioAprobarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ComentarioDAO daoComentario;
	private static final String VIEW = "../comentarios/aprobar.jsp";
	private Alert alert;
	
    
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
			request.setAttribute("comentarios", daoComentario.getAllByAprobado(0));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		alert = null;
		
		try {
			
		String ids[] = request.getParameterValues("id");
		
		if(ids != null) {
						
			if(daoComentario.aprobar(ids)){
				alert = new Alert(Alert.SUCCESS, "Los comentarios han sido aprobados");
				
			}else {
				alert = new Alert(Alert.DANGER, "No hemos podido aprobar los comentarios");
			}
			
		}else {
			alert = new Alert(Alert.WARNING, "Por favor, selecciona un comentario para aprobar");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		
		}finally {
			request.setAttribute("alert", alert);
			try {
				request.setAttribute("comentarios", daoComentario.getAllByAprobado(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
				
	}

}
