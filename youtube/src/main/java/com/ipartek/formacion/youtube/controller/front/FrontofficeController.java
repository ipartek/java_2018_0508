package com.ipartek.formacion.youtube.controller.front;

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
import com.ipartek.formacion.youtube.pojo.Alert;

/**
 * Servlet implementation class FrontofficeController
 */
@WebServlet("/perfil/inicio")
public class FrontofficeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_INICIO = "/perfil/index.jsp";

	private static UsuarioDAO daoUsuario;
	private static VideoDAO daoVideo;
	private static RolDAO daoRol;
	private static ComentarioDAO daoComentario;
	
	private static Alert alert;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
		daoVideo = VideoDAO.getInstance();
		daoRol = RolDAO.getInstance();
		daoComentario = ComentarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		daoUsuario = null;
		daoVideo = null;
		daoRol = null;
		daoComentario = null;
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

		try {
			
			alert = new Alert(Alert.SUCCESS, "Panel de Usuario");
			
			request.setAttribute("alert", alert);

		} catch (Exception e) {
			
			alert = new Alert();
			e.printStackTrace();
		
		} finally {
			
			request.getRequestDispatcher(VIEW_INICIO).forward(request, response);
		}

	}

}
