package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Usuario;
import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.UsuarioDAO;

/**
 * Servlet implementation class RegistroUsuarioController
 */
@WebServlet("/registro")
public class RegistroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_REGISTRO = "registroUsuario.jsp";
	private static final String HOME_CONTROLLER = "/inicio";

	private static UsuarioDAO daoUsuario;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Alert alert = null;
		String view = VIEW_REGISTRO;

		try {
			// recoge parametros

			String nombre = request.getParameter("nombre");
			String password = request.getParameter("password");
			String passwordRepit = request.getParameter("passwordRepit");

			// logica de negocio

			// comprobar campos con javax.validation

			if (password.equals(passwordRepit)) {
				Usuario uRegistro = new Usuario(nombre, password);
				daoUsuario = UsuarioDAO.getInstance();

				if (daoUsuario.insert(uRegistro)) {
					view = HOME_CONTROLLER;
					alert = new Alert(Alert.SUCCESS, "Gracias por registrate, por favor Inicia Sessión");
				} else {
					alert = new Alert(Alert.DANGER,
							"Lo sentimos pero el nombre " + uRegistro.getNombre() + " ya existe!!!");
				}

			} else {
				alert = new Alert(Alert.WARNING, "La contraseña debe coincidir");
			}

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		} finally {
			// enviar atributos e ir a la vista

			if (view.equals(HOME_CONTROLLER)) {
				request.getSession().setAttribute("alert", alert);
				response.sendRedirect(request.getContextPath() + HOME_CONTROLLER);
			} else {
				request.setAttribute("alert", alert);
				request.getRequestDispatcher(view).forward(request, response);
			}
		}

	}

}