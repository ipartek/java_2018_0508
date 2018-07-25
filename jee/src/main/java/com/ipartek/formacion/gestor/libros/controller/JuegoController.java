package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JuegoController
 */
@WebServlet("/juego")
public class JuegoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RequestDispatcher dispatch = null;
	//private static final String VIEW_INDEX = "index.jsp";
	private static final String VIEW_JUEGO = "juego.jsp";
	private static final String palabra = "cesar";
	private static char[] respuesta = new char[5];
	private static int fallos;
	private static final int FALLOS_MAX = 5;

	public JuegoController() {
		initValues();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		initValues();
		request.setAttribute("fail", "fallo" + fallos);
		request.setAttribute("respuesta", new String(respuesta));
		request.setAttribute("finalizado", false);
		dispatch = request.getRequestDispatcher(VIEW_JUEGO);
		dispatch.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			String msg = "";
			String respuesta_str = new String(respuesta);
			if (request.getParameter("letra") != null) {
				char letra = request.getParameter("letra").trim().charAt(0);

				// 2.validar parametros
				if (palabra.toLowerCase().indexOf(Character.toLowerCase(letra)) >= 0) {
					for (int i = 0; i < palabra.length(); i++) {
						if (palabra.charAt(i) == letra) {
							respuesta[i] = letra;
						}
					}
					msg = "Correcto!";

				} else {
					msg = "Fallaste!";
					fallos++;
				}
				
				if (palabra.equals(respuesta_str)) {
					msg = "Ganaste!";
					request.setAttribute("finalizado", true);

				} else if (fallos == FALLOS_MAX) {
					msg = "Perdiste!";
					request.setAttribute("finalizado", true);

				} else {
					request.setAttribute("finalizado", false);
				}
			
			}else {
				msg = "Fallaste!";
			}
			
			request.setAttribute("respuesta", respuesta_str);
			request.setAttribute("msg", msg);
			request.setAttribute("fail", "fallo" + fallos);
			request.setAttribute("fallos", fallos);


			// 5.ir a la vista
			dispatch = request.getRequestDispatcher(VIEW_JUEGO);

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			dispatch = request.getRequestDispatcher(VIEW_JUEGO);

		} finally {
			dispatch.forward(request, response);
		}
	}

	private void initValues() {
		Arrays.fill(respuesta, '_');
		fallos = 0;

	}

}
