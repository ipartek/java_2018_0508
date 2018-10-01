package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/altaUsuario")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao = UsuarioDAO.getInstance();

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

		HttpSession session = request.getSession();
		Alert alert = null;
		
		try {
			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("pass");
			String pass2 = request.getParameter("pass2");

			if (nombre != null && pass != null && pass2 != null) {
				if (!dao.mirarNombre(nombre)) {
					if (pass.equals(pass2)) {
						Usuario u = new Usuario(nombre, pass);
						dao.insert(u);
						session.setAttribute("usuario", u);
						alert = new Alert("Usuario dado de alta correctamente, Bienvenido :D.", Alert.SUCCESS);
						session.setAttribute("alert", alert);
						response.sendRedirect(request.getContextPath() + "/inicio");
					} else {
						// TODO pasar de nuevo el nombre
						alert = new Alert("Las contraseñas no coinciden.", Alert.DANGER);
						session.setAttribute("alert", alert);
						response.sendRedirect(request.getContextPath() + "/registroUsuario.jsp");
					}
				} else {
					alert = new Alert("El usuario ya existe en esta web.Escoga otro.", Alert.DANGER);
					session.setAttribute("alert", alert);
					response.sendRedirect(request.getContextPath() + "/registroUsuario.jsp");
				}
			}
			response.sendRedirect("inicio");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
