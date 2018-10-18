package com.ipartek.formacion.youtube.controller.frontoffice;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;

/**
 * Servlet implementation class PerfilController
 */
@WebServlet("/perfil/inicio")
public class FrontofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario;
	
	public static final String OP_MOSTRAR_PERFIL = "1";
	public static final String OP_MOSTRAR_VIDEOS = "2";
	public static final String OP_MOSTRAR_COMENTARIOS = "3";
	public static final String OP_MODIFICAR_PERFIL = "4";
	private String view = "/perfil/index.jsp";
	private Alert alert;
	
	private String op;
	private String nombre;
	private String imagen;
	private String nuevaPass;
	private String repitePass;
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoUsuario = null;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			alert = null;
			
			getParameters(request, response);
			
			switch (op) {
			case OP_MODIFICAR_PERFIL:
				modificarPerfil(request);
				break;
				
			case OP_MOSTRAR_COMENTARIOS:
				mostrarComentarios(request);
				break;
				
			case OP_MOSTRAR_VIDEOS:
				mostrarVideos(request);
				break;

			default:
				break;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		
		}finally {
			//Vas a algún lao
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
			
		}
		
	}

	private void getParameters(HttpServletRequest request, HttpServletResponse response) {
		
		op = (request.getParameter("op") != null)?request.getParameter("op") : OP_MOSTRAR_PERFIL;
		nombre = request.getParameter("nombre");
		imagen = request.getParameter("imagen");
		nuevaPass = request.getParameter("nuevaPass");
		repitePass = request.getParameter("repitePass");
				
	}

	private void mostrarVideos(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	private void mostrarComentarios(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	private void modificarPerfil(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
	
}
