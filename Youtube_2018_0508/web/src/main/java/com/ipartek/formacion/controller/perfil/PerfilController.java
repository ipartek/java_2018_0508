package com.ipartek.formacion.controller.perfil;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.ComentarioArrayDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;
/**
 * Servlet implementation class PerfilController
 */
@WebServlet("/perfil/inicio")
public class PerfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String INDEX_PERFIL = "/perfil/index.jsp";
	private static VideoDAO daoVideo;
	private static ComentarioArrayDAO daoComentario;
	Alert alert = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoVideo = VideoDAO.getInstance();
		daoComentario = ComentarioArrayDAO.getInstance();
		alert = null;
	}
	
	@Override
	public void destroy() {
		daoVideo = null;
		daoComentario = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		try {
			Usuario u = (Usuario) session.getAttribute("usuario");
			
			request.setAttribute("videos", daoVideo.getAll().size());
			request.setAttribute("comentarios", daoComentario.getAllByAprobado().size());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher(INDEX_PERFIL).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
