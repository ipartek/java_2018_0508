package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ahorcar")
public class AhorcadoController extends HttpServlet {

	private static final int INTENTOS_TOTALES = 5; // Constante con el limite de fallos

	private static String arrayPalabras[] = { "chrystallion", "el fary", "cesar", "java ee" };

	private int intentos;
	private int aciertos;
	private static String msg;
	private static boolean esComienzo;

	// Random para escoger una palabra

	private int aleatorio;
	private static String palabra;

	// Sirve para almacenar los caracteres acertados
	private char[] tusRespuestas;
	private String solucion;

	private static final long serialVersionUID = 1L;

	private void cargarPartida() {
		intentos = 0;
		aciertos = 0;
		msg = "";
		esComienzo = true;
		// Elegimos la palabra mediante un Random
		Random rnd = new Random();
		aleatorio = rnd.nextInt(arrayPalabras.length);
		palabra = arrayPalabras[aleatorio];

		tusRespuestas = new char[palabra.length()];

	}

	public AhorcadoController() {

		cargarPartida();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Recibir parámetros
		if (esComienzo) {
			tusRespuestas = dibujarPalabra(Character.toLowerCase(' '));
		}
		String entrada = request.getParameter("letra");
		// 2. Validar parámetros
		if (entrada != null && !entrada.isEmpty() && entrada.trim().length() == 1) {

			entrada = entrada.trim(); // Eliminamos espacios

			if (intentos == INTENTOS_TOTALES) { // Fin del juego
				msg = "Lo siento, has perdido.";

			} else if (aciertos == palabra.length()) { // Ha ganado
				msg = "Enhorabuena! Has acertado la palabra.";
				request.getRequestDispatcher("index.jsp").forward(request, response);

			} else { // Seguimos jugando
				intentos++;
				tusRespuestas = dibujarPalabra(Character.toLowerCase(entrada.charAt(0)));
				solucion = "";
				for (int i = 0; i < tusRespuestas.length; i++) {
					solucion += tusRespuestas[i];
				}
				request.setAttribute("solucion", solucion);
			}
		}

		request.setAttribute("msg", msg);
		request.setAttribute("intentos", intentos);
		request.setAttribute("aciertos", aciertos);
		// 5. Ir a la vista
		request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
	}

	private char[] dibujarPalabra(char c) {

		boolean acertado = false;

		for (int i = 0; i < palabra.length(); i++) {
			if (esComienzo) {
				if (palabra.charAt(i) == ' ') {
					tusRespuestas[i] = ' ';
				} else {
					tusRespuestas[i] = '*';
				}
			} else {
				if (palabra.charAt(i) == c) { // Letra acertada

					tusRespuestas[i] = c;
					acertado = true;

				} else if (palabra.charAt(i) == ' ') { // Es un espacio

					tusRespuestas[i] = ' ';
				} else {
					tusRespuestas[i] = tusRespuestas[i];
				}
			}

		}
		if (esComienzo) {
			esComienzo = false;
		}
		if (acertado) {
			msg = "Ha acertado!";
			aciertos++;
		} else {
			msg = "Ha fallado!";
		}

		return tusRespuestas;
	}

}
