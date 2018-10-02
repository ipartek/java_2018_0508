package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoYoutubeDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Alert alert;
	private UsuarioDAO dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = UsuarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// Se ejecuta al parar el servidor
		dao = null;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//	Recoger parámetros
			String nuevoUsuario = request.getParameter("registerUsuario");
			String nuevaPassword = request.getParameter("registerPassword");
			String repitePassword = request.getParameter("repitePassword");
			
			if (nuevaPassword != null && nuevaPassword.equals(repitePassword)) {
				
				if (nuevoUsuario.trim() != null) {
					Usuario u = new Usuario(nuevoUsuario, nuevaPassword);
					
					insertarUsuario(u);
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("inicio").forward(request, response);
		}
		
		
	}

	private void insertarUsuario(Usuario u) {
		
		alert = new Alert();
		
		if (dao.insert(u)) { // Usuario insertado
			alert.setTexto("El usuario se creó correctamente.");
			alert.setTipo(Alert.SUCCESS);

		} 	
	}

}
