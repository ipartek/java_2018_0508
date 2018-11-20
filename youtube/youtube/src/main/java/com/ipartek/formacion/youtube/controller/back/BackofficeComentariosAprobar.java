package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.pojo.Comentario;

/**
 * Servlet implementation class BackofficeComentariosAprobar
 */
@WebServlet("/backoffice/comentarios/aprobar")
public class BackofficeComentariosAprobar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ComentarioDAO daoComentario;
	ArrayList<Comentario> comentarios;
	private static final String VIEW_NO_APROBED="../comentarios/aprobar.jsp"; 
	String[] ids;
	private String id;
	private String texto;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			comentarios = (ArrayList<Comentario>) daoComentario.getAllByAprobado(ComentarioDAO.NOT_APROBADO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("comentarios", comentarios);
		request.getRequestDispatcher( VIEW_NO_APROBED).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Comentario comentario=new Comentario();
		try {
			ids=request.getParameterValues("ids");
			daoComentario.aprobar(ids);
			}
			
			
		
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			response.sendRedirect( request.getContextPath() + "/backoffice/comentarios/aprobar");
		}
	}



}
