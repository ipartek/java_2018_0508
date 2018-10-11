package com.andrea.perez.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andrea.perez.model.ComentarioDAO;
import com.andrea.perez.pojo.Alert;
import com.andrea.perez.pojo.Comentario;
import com.andrea.perez.pojo.Usuario;
import com.andrea.perez.pojo.Video;

/**
 * Servlet implementation class ComentarioController
 */
@WebServlet("/publicar")
public class PublicarComentarioVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Comentario comentario;
	private ComentarioDAO daoComentario;
	private Alert alert;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		daoComentario = ComentarioDAO.getInstance();

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		daoComentario = null;
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

		Comentario comentario = new Comentario();
		String texto = request.getParameter("texto");		
		long video = Long.parseLong(request.getParameter("id_video"));

		try {
			HttpSession session = request.getSession();
			Usuario u = (Usuario) session.getAttribute("usuario");
			if (texto != null && texto.length() > 0) {

				comentario.setTexto(texto);
				comentario.setUsuario(u);
				comentario.setVideo(new Video(video));
				if (daoComentario.insert(comentario)) {
					alert=new Alert(Alert.ALERT_SUCCESS,"Comentario en proceso de aceptacion para publicar");
				}else {
					alert=new Alert(Alert.ALERT_WARNING,"No se pudo guardar el comentario");
				}

			} else {
				alert=new Alert(Alert.ALERT_WARNING,"Tiene que haber escrito algo para poder insertarlo");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.sendRedirect(request.getContextPath() + "/inicio?id=id_video");
		}
	}

}
