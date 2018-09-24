package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.Usuario;

/**
 * Implementación de un Controlador Servlet que detecta si un usuario ha sido
 * correctamente logueado, contrastando con la base de datos.
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			System.out.println("Logueando...");
			
			// Recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("psw");
		

			// Comprobar usuario
			if ("admin".equals(pass) && "admin".equals(usuarioNombre)) {

				// Guardar Usuario en session
				Usuario u = new Usuario(usuarioNombre, pass);

				request.getSession().setAttribute("usuario", u);
			}
		} catch (Exception e) {

			e.printStackTrace();
			
		} finally {

			response.sendRedirect(request.getContextPath() + "/privado/listado.jsp");
		}
	}

}
