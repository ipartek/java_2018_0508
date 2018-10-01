package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Alert;
import com.ipartek.formacion.youtube.Usuario;
import com.ipartek.formacion.youtube.model.RegistroDAO;

/**
 * Servlet implementation class RegistroUsuarioController
 */
@WebServlet("/registro")
public class RegistroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Alert msg = null;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String nombre = request.getParameter("nombre");
			String password = request.getParameter("password");
			String passwordRepit = request.getParameter("passwordRepit");

			Usuario u = null;

			if (password.equals(passwordRepit)) {

				u = new Usuario(nombre, password);
				RegistroDAO dao = RegistroDAO.getInstance();
				dao.insert(u);

			} else {
				msg = new Alert(Alert.ALERT_WARNING, " Las Contraseñas debe coincidir");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("inicio").forward(request, response);

		}
	}

}
