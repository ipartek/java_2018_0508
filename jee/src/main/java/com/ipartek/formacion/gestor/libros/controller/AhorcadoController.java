package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
	private static final String VIEW = "juegoAhorcado.jsp";

	private static final String PALABRA_SECRETA = "cersar";
	private static final int INTENTOS = 7;
	private static String msg = "";
	private static int fallos = 0;
	private static int aciertos = 0;
	private ArrayList<String> respuestas = new ArrayList<String>(Arrays.asList("*", "*", "*", "*", "*", "*"));
	private static String letra;
	private static boolean isTerminado = false;
	private static String repetirJugadda = null; // jugar de nuevo

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

		letra = "";

		try {

			dispatch = request.getRequestDispatcher(VIEW);
			repetirJugadda = (String) request.getParameter("jdn");

			// jugar de nuevo
			if (repetirJugadda != null) {

				aciertos = 0;
				fallos = 0;
				isTerminado = false;
				respuestas = new ArrayList<String>(Arrays.asList("*", "*", "*", "*", "*", "*"));

			} else {

				comprobarSiacierta(request);

			}

		} catch (Exception e) {

			msg = "Por favor Dime una letra";

		} finally {
			request.setAttribute("intento", INTENTOS);
			request.setAttribute("fallos", fallos);
			request.setAttribute("msg", msg);
			request.setAttribute("solucion", respuestas);
			request.setAttribute("isTerminado", isTerminado);
			dispatch.forward(request, response);
		}

	}

	private void comprobarSiacierta(HttpServletRequest request) {

		letra = request.getParameter("letraUsuario");
		char[] aCaracteres = PALABRA_SECRETA.toCharArray();
		boolean acierto = false;
		if (letra == null || letra.isEmpty()) {
			msg = "Inserte una letra para poder jugar por favor";
		} else {
			for (int x = 0; x < aCaracteres.length; x++) {
				if (String.valueOf(aCaracteres[x]).equalsIgnoreCase(letra)) {

					respuestas.set(x, letra);
					aciertos++;
					acierto = true;

				} else {
					msg = "La " + letra + " no se encuentra en la palabra secreta";
				}
			}
		}

		if (!acierto) {
			fallos++;

		}

		if (aciertos == PALABRA_SECRETA.length()) {
			msg = "Has Ganado, Enhorabuena!!!!";
			isTerminado = true;
		} else if (fallos == INTENTOS) {
			msg = "Ohhhhhhhh Perdiste :-(";
			isTerminado = true;
		}

	}

}