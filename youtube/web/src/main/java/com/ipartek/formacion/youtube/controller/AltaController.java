package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class NuevoUsuarioController
 */
@WebServlet("/alta")
public class AltaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW_REGISTRO = "/alta.jsp";
	private static final String HOME_CONTROLLER = "/inicio";

	private static UsuarioDAO dao;
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;

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
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Alert alert = null;
		String view = VIEW_REGISTRO;

		HttpSession session = request.getSession();
		dao = UsuarioDAO.getInstance();

		try {

			// recoger parametros
			String nombre = request.getParameter("nombre");
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");

			// TODO comprobar si existe el usuario
			if (password.equals(password2)) {
				Usuario u = new Usuario(nombre, password);
				if (dao.insertAlta(u)) {
					view = HOME_CONTROLLER;
					alert = new Alert(Alert.SUCCESS, "Gracias por registrarse");
				} else {
					alert = new Alert(Alert.WARNING, "ERROR, no se pudo dar de alta");
				}
			} else {
				alert = new Alert(Alert.WARNING, "ERROR, la contraseña no coincide");
			}

			// pedir listado
			usuarios = (ArrayList<Usuario>) dao.getAll();

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		} finally {
			session.setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + view);
		}

	}

}
