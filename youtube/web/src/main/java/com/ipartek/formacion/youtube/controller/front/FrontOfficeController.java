package com.ipartek.formacion.youtube.controller.front;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class FrontOfficeController
 */
@WebServlet("/perfil")
public class FrontOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_INICIO = "/frontoffice/perfil.jsp";
	private static UsuarioDAO daoUsuario;
	private static VideoDAO daoVideo;
	private static RolDAO daoRol;
	private static ComentarioDAO daoComentario;
	private String id;
	private ArrayList<Video>videos;
	private ArrayList<Comentario>comentarios;


	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		daoRol = RolDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
		daoVideo = VideoDAO.getInstance();
		daoComentario = ComentarioDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion= request.getSession();
		
		Usuario usuario =(Usuario) sesion.getAttribute("usuario");
		
		
		try {
			videos=(ArrayList<Video>) daoVideo.getAllByUserId(usuario.getId());
			comentarios= (ArrayList<Comentario>) daoComentario.getAllByUserId(usuario.getId());
			request.setAttribute("videos",videos);
			request.setAttribute("numVideos", videos.size());
			request.setAttribute("comentarios", comentarios);
			request.setAttribute("usuario", usuario);
			request.setAttribute("numComentarios", comentarios.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			request.getRequestDispatcher(VIEW_INICIO).forward(request, response);
		}
	}
}
