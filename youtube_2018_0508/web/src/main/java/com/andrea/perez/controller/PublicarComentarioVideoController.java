package com.andrea.perez.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andrea.perez.controller.pojo.Alert;
import com.andrea.perez.youtube.dao.ComentarioDAO;
import com.andrea.perez.youtube.pojo.Comentario;
import com.andrea.perez.youtube.pojo.Usuario;
import com.andrea.perez.youtube.pojo.Video;

/**
 * Servlet implementation class ComentarioController
 */
@WebServlet("/publicar")
public class PublicarComentarioVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String id_video;
	private String texto;

	private static final String VIEW_INDEX = "home.jsp";

	private ComentarioDAO comentarioDAO;

	Alert alert = null;
	String view = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		comentarioDAO = ComentarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		comentarioDAO = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = null;
		Video video = null;
		Comentario comentario = null;

		try {

			HttpSession session = request.getSession();
			usuario = (Usuario) session.getAttribute("usuario");

			id_video = request.getParameter("id_video");
			texto = request.getParameter("texto");

			comentario = new Comentario();
			comentario.setTexto(texto);

			comentario.setUsuario(usuario);

			video = new Video();
			video.setId(Long.parseLong(id_video));
			comentario.setVideo(video);

			if (comentarioDAO.insert(comentario)) {
				alert = new Alert(Alert.ALERT_SUCCESS,
						"Gracias por escribir un comentario. Está pendiente de moderación.");
			} else {
				alert = new Alert(Alert.ALERT_WARNING, "No se ha podido añadir el comentario.");
			}

			view = VIEW_INDEX;

			session.setAttribute("alert", alert);
//			request.setAttribute("comentario", comentario);

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		} finally {
			response.sendRedirect(request.getContextPath() + "/inicio?id=" + id_video);
//			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
