package com.ipartek.formacion.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.RolDAO;
import com.ipartek.formacion.model.UsuarioDAO;
import com.ipartek.formacion.model.VideoDAO;
import com.ipartek.formacion.pojo.Alert;

/**
 * Servlet implementation class BackofficeController
 */
@WebServlet("/backoffice/inicio")
public class BackofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Hay que poner / porque java no sabe la jerarquia de carpetas y sin barra no lo encuentra
	private static final String VIEW_INICIO = "/backoffice/index.jsp";
	
	private static UsuarioDAO daoUsuario;
	private static VideoDAO daoVideo;
	private static RolDAO daoRol;
	
	Alert alert = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
		daoVideo = VideoDAO.getInstance();
		daoRol = RolDAO.getInstance();
		alert = null;
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
			
			request.setAttribute("usuarios", daoUsuario.getAll().size());
			request.setAttribute("videos", daoVideo.getAll().size());
			request.setAttribute("roles", daoRol.getAll().size());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(VIEW_INICIO).forward(request, response);
		}
	}

}
