package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jugarAhorcado")

public class AhorcadoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private static final String VIEW_AHORCADO = "juegoAhorcado.jsp";
	private static final String PALABRA_OCULTA = "cesar";
	private static final int MAX_FALLOS = 7;
	
	int cont = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("juegoAhorcado.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			char[] aCaracteres = PALABRA_OCULTA.toCharArray();
			
			dispatch = request.getRequestDispatcher(VIEW_AHORCADO);

			String letra = request.getParameter("letraUsuario");

			if (cont < MAX_FALLOS) {
				request.setAttribute("intento", "Te quedan " + (MAX_FALLOS - cont) + " intentos");
				cont++;
			} else {
				request.setAttribute("intento", "no te quedan mas intentos");
			}

			if (letra != null && !"".equals(letra) && cont < MAX_FALLOS) {
				for (int x = 0; x < aCaracteres.length; x++) {
					if (String.valueOf(aCaracteres[x]).equalsIgnoreCase(letra)) {
						request.setAttribute("casilla" + x, letra);
					}
				}

			} else {
				request.setAttribute("msg", "Si quieres jugar, tendras que ingresar una letra campeon");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dispatch.forward(request, response);
		}

	}

}
