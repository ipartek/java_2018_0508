package com.andrea.perez.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrea.perez.model.UsuarioDAO;
import com.andrea.perez.pojo.Alert;
import com.andrea.perez.pojo.Usuario;

/**
 * Servlet implementation class RegistroUsuarioController
 */
@WebServlet("/registro")
public class RegistroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_REGISTRO = "registro.jsp";
	private static final String VIEW_HOME = "inicio";

	private static String usuario = "";
	private static String pswd = "";
	private static String pswdRepe = "";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String view = VIEW_REGISTRO;
		Alert alert = null;
		try {
			usuario = request.getParameter("usuario");
			pswd = request.getParameter("pswd");
			pswdRepe = request.getParameter("pswdRepe");

			Usuario u = null;

			// Comprobar que el pass sean iguales en los campos:
			// TODO comprobar nombre repetido en la bbdd

			if (usuario != null && pswd != null && pswdRepe != null) {

				if (pswd.equals(pswdRepe)) {
					u = new Usuario(usuario, pswd);
					UsuarioDAO daoUser = UsuarioDAO.getInstance();
					if (daoUser.insert(u)) {
						view = VIEW_HOME;
						alert = new Alert(Alert.ALERT_SUCCESS, "Gracias por registrarse");
					} else {
						alert = new Alert(Alert.ALERT_WARNING, "Error..." + u.getNombre() + " ya existe");
					}
				} else {
					alert = new Alert(Alert.ALERT_WARNING, "Error...Las contraseñas deben coincidir");
				}
			} else {
				alert = new Alert(Alert.ALERT_WARNING, "Error...Se debe rellenar todos los campos");
			}

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		} finally {
//enviar atributos e ir a la vista

			if (view.equals(VIEW_HOME)) {
				request.getSession().setAttribute("alert", alert);
				response.sendRedirect(request.getContextPath() + "/" + VIEW_HOME);
			} else {
				request.setAttribute("alert", alert);
				request.getRequestDispatcher(view).forward(request, response);
			}

		}
	}

}
