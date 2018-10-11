package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class ComentarController
 */
@WebServlet("/comentar")
public class ComentarController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static ComentarioDAO daoComentario;

	// Campos de formulario
	private String texto;
	private String idVideo;

	private Comentario comentario;
	private Usuario usuario;

	private long numIdVideo;

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
	 * @see HttpServlet.doGet()
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProccess(request, response);
	}

	/**
	 * @see HttpServlet.doPost()
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();
			usuario = (Usuario) session.getAttribute("usuario");

			// Comprobar si hay un usuario logueado
			if (usuario != null) {

				getParameters(request);
				crearComentario();
				insertarComentario();
				

			}

		} catch (Exception e) { // Excepciones no controladas

			e.printStackTrace();

		} finally {
			
			response.sendRedirect("inicio?id="+numIdVideo);
		}

	}

	private void getParameters(HttpServletRequest request) {

		texto = request.getParameter("texto");
		idVideo = request.getParameter("idVideo");

		if (idVideo != null) {

			numIdVideo = Long.parseLong(idVideo);
		}
	}

	private void crearComentario() {

		comentario = new Comentario(texto);
		comentario.setUsuario(usuario);
		comentario.getVideo().setId(numIdVideo);
		
	}
	
	private void insertarComentario() throws SQLException {

		daoComentario.insert(comentario);	// Comentario insertad
	}

}
