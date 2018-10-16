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
 * Servlet implementation class BackofficeComentariosAprobarController
 */
@WebServlet("/backoffice/comentarios/aprobar")
public class BackofficeComentariosAprobarController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "../comentarios/aprobar.jsp";
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			request.setAttribute("comentarios", daoComentario.getAllByAprobado(ComentarioDAO.NOT_APROBADO));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(VIEW).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String[] ids = request.getParameterValues("ids");
			System.out.println(ids);
			
			daoComentario.aprobar(ids);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			response.sendRedirect( request.getContextPath() + "/backoffice/comentarios/aprobar");
		}

	}

}
