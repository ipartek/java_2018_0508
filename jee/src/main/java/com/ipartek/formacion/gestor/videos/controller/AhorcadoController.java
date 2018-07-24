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

	private static final int INTENTOS_TOTALES = 7; // Constante con el limite de fallos
	private int intentos = 0;
	private int aciertos = 0;
	private static String msg = "";
	private static boolean esComienzo = true;

	private static String arrayPalabras[] = { "chrystallion", "el fary", "cesar", "java ee" };

	// Random para escoger una palabra
	private static Random rnd = new Random();
	private static int aleatorio = rnd.nextInt(arrayPalabras.length);
	private static String palabra = arrayPalabras[aleatorio];

	// Sirve para almacenar los caracteres acertados
	private char[] tusRespuestas = new char[palabra.length()];

	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Recibir parámet
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
				String solucion = "";
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
		
		if (esComienzo) { // Inicializamos la palabra con asteriscos
			for (int i = 0; i < palabra.length(); i++) {
				if (palabra.charAt(i) == ' ') { // Contiene espacios

					tusRespuestas[i] = ' ';
				} else {
					tusRespuestas[i] = '*';
				}
			}
		} else {
			for (int i = 0; i < palabra.length(); i++) {
				if (palabra.charAt(i) == c) { // Letra acertada
					
					tusRespuestas[i] = c;
					acertado = true;
					
				} else if (palabra.charAt(i) == ' ') { // Contiene espacios

					tusRespuestas[i] = ' ';
				} else {
					tusRespuestas[i] = tusRespuestas[i];
				}
			}
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
