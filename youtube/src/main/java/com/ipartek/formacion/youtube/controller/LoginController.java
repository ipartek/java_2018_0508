package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alert alert = new Alert();
		HttpSession sesion = request.getSession();

		try {

			// Recoger parametros
			String nombre = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			ArrayList<Usuario>listaUsuarios= (ArrayList<Usuario>)request.getServletContext().getAttribute("usuariosPermitidos");
			
			for (Usuario u : listaUsuarios) {
				if (!u.getNombre().equals(nombre) && !u.getPassword().equals(pass)) {

					alert.setTexto("Credenciales incorrectas ");

				} else {

					alert.setTexto("Bienvenido " + nombre);
					alert.setTipo(Alert.PRIMARY);

					Usuario user = new Usuario(nombre, pass);
					sesion.setAttribute("usuario", user);
					sesion.setMaxInactiveInterval(10);
					ArrayList<Video>videosUsuario= new ArrayList<Video>();
					sesion.setAttribute("reproducidos", videosUsuario);
				}
			}

			

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.setAttribute("alert", alert);
			//request.getRequestDispatcher("home.jsp").forward(request, response);
			response.sendRedirect( request.getContextPath()+"/inicio");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

}
