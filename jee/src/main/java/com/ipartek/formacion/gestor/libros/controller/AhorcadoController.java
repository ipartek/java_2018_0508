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
	private static final String VIEW_AHORCADO = "juegoAhorcado.jsp";
	private static final String PALABRA_OCULTA = "cesar";
	private static final int MAX_FALLOS = 7;
	private static String MSG_ERROR = "Debes insertar una letra para poder jugar";
	private static String MSG_ACIERTO = "Enhorabuena!! LO HAS CONSEGUIDO!!";
	private static String MSG_NO_LETRA = "Lastima la palabra no contiene la letra ";


	private ArrayList<String> respuestas = new ArrayList<String>(Arrays.asList("*", "*", "*", "*", "*"));

	int cont = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("juegoAhorcado.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

				
		try {			
			
			dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
			char[] aCaracteres = PALABRA_OCULTA.toCharArray();
			String letra = request.getParameter("letraUsuario");
			int aciertos=0;

			if (cont <= MAX_FALLOS) {
				if (letra.isEmpty() || letra==null) {
					
					request.setAttribute("msg", MSG_ERROR);
				}else {
					for (int x = 0; x < aCaracteres.length; x++) {
						if (String.valueOf(aCaracteres[x]).equalsIgnoreCase(letra)) {
							respuestas.set(x, letra);
							aciertos++;
						}else {
							request.setAttribute("msg", MSG_NO_LETRA+letra);
						}
					}
					request.setAttribute("solucion", respuestas.toString());
				}
				if (aciertos==aCaracteres.length) {
					request.setAttribute("msg", MSG_ACIERTO);
				}
				
				
				
				request.setAttribute("intento", "Te quedan " + (MAX_FALLOS - cont) + " intentos");
				cont++;
			} else {
				request.setAttribute("intento", "no te quedan mas intentos");
				request.getRequestDispatcher("juegoAhorcado.jsp").forward(request, response);
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dispatch.forward(request, response);
		}

	}

	public ArrayList<String> crearPalabra(String letraUsuario) {

		return respuestas;
	}

}