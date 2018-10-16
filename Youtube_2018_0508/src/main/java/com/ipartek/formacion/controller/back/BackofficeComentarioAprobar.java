package com.ipartek.formacion.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.ComentarioArrayDAO;
import com.ipartek.formacion.pojo.Alert;

/**
 * Servlet implementation class BackofficeComentarioController
 */
@WebServlet("/backoffice/comentarios/aprobar")
public class BackofficeComentarioAprobar extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static ComentarioArrayDAO daoComentarios;
	
	private static final String VIEW_INDEX_COMENTARIOS = "../comentarios/aprobar.jsp";
	
	Alert alert = null;
	String view = "";
	
	//Parametros
	String op;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoComentarios = ComentarioArrayDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoComentarios = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			ArrayList<Comentario> comentarios = (ArrayList<Comentario>) daoComentarios.getAll();
//			ArrayList<Comentario> comentariosSinAprobar = new ArrayList<Comentario>();
//			for(int i= 0; i<comentarios.size();i++) {
//				if(!comentarios.get(i).isAprobado()) {
//					comentariosSinAprobar.add(comentarios.get(i));
//				}
//			}
			request.setAttribute("comentarios", daoComentarios.getAllByAprobado());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher(VIEW_INDEX_COMENTARIOS).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String[] ids = request.getParameterValues("checkboxAprobar");
			
			if(ids.length>0) {
//				for(int i=0;i<ids.length;i++){
//					daoComentarios.aprobar(ids[i]);	
//				}
				daoComentarios.aprobar(ids);	
				alert = new Alert(Alert.ALERT_SUCCESS, "Comentarios aprobados con éxito.");
			}else {
				alert = new Alert(Alert.ALERT_WARNING, "No se ha seleccionado ningún comentario.");
			}
			
			request.setAttribute("comentarios", daoComentarios.getAllByAprobado());
		}catch(Exception e) {
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
			e.printStackTrace();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(VIEW_INDEX_COMENTARIOS).forward(request, response);
//			response.sendRedirect(request.getContextPath() + "backoffice/comentarios/aprobar");
		}
	}
}
