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
@WebServlet("/backoffice/comentarios/aprobar")
public class backofficeComentariosAprobar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_APROBAR_COMENTARIOS = "../comentarios/aprobar.jsp";

	private static ComentarioDAO daoComentario = null;
	private Alert alert = null;
	String view = "";

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

			request.setAttribute("comentarios", daoComentario.getAllAprobarComentario());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(VIEW_APROBAR_COMENTARIOS).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recoger comentarios aprobados
		String[] comentariosAprobados = request.getParameterValues("aprobado");

		try {
			if (comentariosAprobados.length > 0) {
				if (daoComentario.updateAprobar(comentariosAprobados)) {
					request.setAttribute("comentarios", daoComentario.getAllAprobarComentario());
					alert = new Alert(Alert.ALERT_SUCCESS, "Comentarios aprobados correctamente");
				} else {
					alert = new Alert(Alert.ALERT_DANGER, "Error en aprobar comentarios");
				}
			} else {
				alert = new Alert(Alert.ALERT_WARNING, "No se ha seleccionado ningún comentario");
			}

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(VIEW_APROBAR_COMENTARIOS).forward(request, response);
		}

	}

}
