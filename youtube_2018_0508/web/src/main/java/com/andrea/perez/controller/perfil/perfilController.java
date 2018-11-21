package com.andrea.perez.controller.perfil;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andrea.perez.youtube.dao.ComentarioDAO;
import com.andrea.perez.youtube.dao.VideoDAO;
import com.andrea.perez.youtube.pojo.Usuario;
import com.andrea.perez.youtube.pojo.Video;

/**
 * Servlet implementation class perfilController
 */
@WebServlet("/perfil/inicio")
public class perfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INDEX_PERFIL = "/perfil/index.jsp";

	ComentarioDAO daoComentario;
	VideoDAO daoVideo;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		daoComentario = ComentarioDAO.getInstance();
		daoVideo = VideoDAO.getInstance();
	}

	@Override
	public void destroy() {

		super.destroy();
		daoComentario = null;
		daoVideo = null;
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
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int comTotal = 0;
		int comApro = 0;
		int comNoApro = 0;
		ArrayList<Video> videos = new ArrayList<Video>();

		try {
			// Cargamos id usuario
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			int idUser = (int) usuario.getId();

			// carga total de comentarios realizados
			comTotal = daoComentario.cantComentariosUsuario(idUser, daoComentario.SQL_PERFIL_COUNT,
					daoComentario.TOTAL);
			comApro = daoComentario.cantComentariosUsuario(idUser, daoComentario.SQL_PERFIL_COUNT_APROBAR_COMENTARIOS,
					daoComentario.APROBADO);
			comNoApro = daoComentario.cantComentariosUsuario(idUser, daoComentario.SQL_PERFIL_COUNT_APROBAR_COMENTARIOS,
					daoComentario.NOT_APROBADO);
			// carga total videos insertados
			videos = (ArrayList<Video>) daoVideo.getAllToUser(idUser);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			request.setAttribute("totalComentario", comTotal);
			request.setAttribute("cantApro", comApro);
			request.setAttribute("cantNoApro", comNoApro);
			request.setAttribute("videos", videos);
			request.getRequestDispatcher(INDEX_PERFIL).forward(request, response);
		}
	}

}
