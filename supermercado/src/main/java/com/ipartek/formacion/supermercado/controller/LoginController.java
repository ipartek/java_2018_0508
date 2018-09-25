package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.pojo.Alert;
import com.ipartek.formacion.supermercado.model.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER = "admin";
	private static final String PASS = "admin";

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
		Alert alert= new Alert();
		String view = "login.jsp";
		String texto = "Error inesperado";
		alert.setTipo(Alert.DANGER);
		alert.setTexto(texto);

		try {

			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("pass");

			if (USER.equals(nombre) && PASS.equals(pass)) {
				HttpSession sesion = request.getSession();
				Usuario usuario = new Usuario();
				usuario.setNombre(nombre);
				usuario.setPass(pass);
				sesion.setAttribute("usuario", usuario);
				sesion.setMaxInactiveInterval(60*60*60);
				view = "privado/listado";
				texto = "Bienvenido "+usuario.getNombre();
				alert.setTipo(Alert.SUCCESS);

			} else {
				texto = "Credenciales incorrectas, por favor intentalo de nuevo";
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			alert.setTexto(texto);
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
			//response.sendRedirect("privado/listado");

		}
	}

}
