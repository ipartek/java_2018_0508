package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ahorcado")
public class AhorcadoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private static final String VIEW = "ahorcado.jsp";

	private static final String PALABRA_SECRETA = "ceRsar";
	private static final int INTENTOS = 7;
	private static int fallos = 0;
	private static int aciertos = 0;
	private static String mensaje = "";
	private static String palabraMostrar = "";
	private static boolean isTerminado = false;
	private static String jdn = null; // jugar de nuevo

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			dispatch = request.getRequestDispatcher(VIEW);

			jdn = (String) request.getParameter("jdn");
			if (jdn != null) {

				aciertos = 0;
				fallos = 0;
				isTerminado = false;

			} else {

				comprobarSiAcierta(request);

			} // jugar de nuevo

		} catch (Exception e) {

			//e.printStackTrace();
			//mensaje = "Error Inesperado " + e.getMessage();
			mensaje = "Por favor Dime una letra";

		} finally {

			request.setAttribute("intentos", INTENTOS);
			request.setAttribute("fallos", fallos);
			request.setAttribute("aciertos", aciertos);
			request.setAttribute("palabraMostrar", palabraMostrar);
			request.setAttribute("msg", mensaje);
			request.setAttribute("isTerminado", isTerminado);
			dispatch.forward(request, response);
		}

	}

	/**
	 * Leemos la letra que envia y comprobamos si ha acertado
	 * 
	 * @param request
	 */
	private void comprobarSiAcierta(HttpServletRequest request) {

		char letra = Character.toLowerCase(request.getParameter("letra").charAt(0));
		boolean acierto=false;

		for(int i=0;i<PALABRA_SECRETA.length(); i++) {
			if (letra == Character.toLowerCase(PALABRA_SECRETA.charAt(i))) {
				aciertos++;
				acierto=true;
				palabraMostrar= replaceCharAt(palabraMostrar,i,letra);
			} 
		}
		if (!acierto) {
			fallos++;
		} 
		
		if (aciertos == PALABRA_SECRETA.length()) {
			mensaje = "Has Ganado, Enhorabuena!!!!";
			isTerminado = true;
		} else if (fallos == INTENTOS) {
			mensaje = "Ohhhhhhhh Perdiste :-(";
			isTerminado = true;
		}

	}

	private String replaceCharAt(String s, int pos, char c) {
	
		return s.substring(0, pos);
	}



}