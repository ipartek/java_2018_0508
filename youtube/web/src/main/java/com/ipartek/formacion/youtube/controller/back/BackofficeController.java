package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;

/**
 * Servlet implementation class BackofficeController
 */
@WebServlet("/backoffice/inicio")
public class BackofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_INICIO="/backoffice/index.jsp";
	private static UsuarioDAO daoUsuario;
	private static VideoDAO daoVideo;
	private static RolDAO daoRol;
	private static ComentarioDAO daoComentario;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
		daoVideo = VideoDAO.getInstance();
		daoRol = RolDAO.getInstance();
		daoComentario = ComentarioDAO.getInstance();
	}
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			try {
				int totalRoles=daoRol.getAll().size();				
				request.setAttribute("totalRoles", totalRoles);
				int totalUsuarios=daoUsuario.getAll().size();				
				request.setAttribute("totalUsuarios", totalUsuarios);
				
				request.setAttribute("usuarios", daoUsuario.getAll().size());
				request.setAttribute("videos", daoVideo.getAll().size());
				request.setAttribute("roles", daoRol.getAll().size());
				request.setAttribute("comentarios", daoComentario.getAll().size());
				request.setAttribute("comentariosAprobado", daoComentario.getAllNoAprobado().size());
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				request.getRequestDispatcher(VIEW_INICIO).forward(request, response);
			}
	}

}
