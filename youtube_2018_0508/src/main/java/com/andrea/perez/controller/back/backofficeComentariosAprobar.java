package com.andrea.perez.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrea.perez.model.ComentarioDAO;
import com.andrea.perez.pojo.Alert;
import com.andrea.perez.pojo.Comentario;

/**
 * Servlet implementation class backofficeComentariosAprobar
 */
@WebServlet("/backoffice/comentarios")
public class backofficeComentariosAprobar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ComentarioDAO daoComentario = null;
	private Alert alert = null;

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
			ArrayList<Comentario>comentariosAprobar=daoComentario.aprobarComentario();
			
			
			if (comentariosAprobar.size()>0 && comentariosAprobar!=null) {
				request.setAttribute("comentarios", comentariosAprobar);
			}else {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("comentarios/aprobar.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recoger comentarios aprobados
		String []comentariosAprobados=request.getParameterValues("aprobado");
		//daoComentario.
		
		
		
	}

}
