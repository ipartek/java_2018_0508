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
	
	private static final String VIEW_AHORCADO = "ahorcado.jsp";
	private static final int INTENTOS_AHORCADO = 7;
	public static int contFallos = 0;
	private static final String PALABRA_SECRETA = "ceRsar";
	private static boolean isTerminado = false;
	private static boolean existePalabra = false;
	private static String jdn = null;
	private static String msg = "";
	
	private RequestDispatcher dispatch = null;

	private char[] arrayLetras = new char[] { '_', '_', '_', '_', '_', '_' };
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
			
			jdn = (String) request.getParameter("jdn");
			
			if(jdn != null) {
				isTerminado = false;
				contFallos = 0;
				arrayLetras = new char[] { '_', '_', '_', '_', '_', '_' };
			}else {
				char letra = Character.toLowerCase(request.getParameter("letra").charAt(0));
				
				for(int i = 0; i<PALABRA_SECRETA.length();i++) {
					if(PALABRA_SECRETA.toLowerCase().charAt(i) == letra) {
						arrayLetras[i] = Character.toUpperCase(letra);
						existePalabra = true;
					}
				}
				
				if(!existePalabra) {
					contFallos++;
					msg = "La letra introducida no está. Le quedan " + (INTENTOS_AHORCADO - contFallos) + " intentos.";
				}
				
				int completo = PALABRA_SECRETA.length();
				for(int i = 0; i<arrayLetras.length;i++) {
					if(arrayLetras[i] != '_') {
						completo--;
						System.out.println("No acabado");
					}
				}
				
				System.out.println(completo);
				
				if(completo == 0) {
					isTerminado = true;
					msg = "HAS GANADO!!";
				}else if(contFallos == INTENTOS_AHORCADO) {
					isTerminado = true;
					msg = "HAS PERDIDO!!";
				}
					
			}
			
			/*if (letra != null && !letra.equals("".trim())) {
				if (letra.equalsIgnoreCase("c"))
					arrayLetras[0] = 'C';
				else if (letra.equalsIgnoreCase("e"))
					arrayLetras[1] = 'E';
				else if (letra.equalsIgnoreCase("s"))
					arrayLetras[2] = 'S';
				else if (letra.equalsIgnoreCase("a"))
					arrayLetras[3] = 'A';
				else if (letra.equalsIgnoreCase("r"))
					arrayLetras[4] = 'R';
				else {
					contFallos++;
					request.setAttribute("msg",
							"La letra introducida no está. Le quedan " + (INTENTOS_AHORCADO - contFallos) + " intentos.");
				}
				request.setAttribute("letras", arrayLetras);
			} else
				request.setAttribute("msg", "Debes introducir una letra.");*/

			/*if (contFallos >= 7) {
				msg = "No te quedan más intentos.";
				arrayLetras = new char[] { '_', '_', '_', '_', '_' };
				request.setAttribute("letras", arrayLetras);
				contFallos = 0;
			}*/
			
		} catch (Exception e) {
			msg = "Debes introducir una letra.";
		} finally {
			request.setAttribute("msg", msg);
			request.setAttribute("letras", arrayLetras);
			request.setAttribute("contFallos", contFallos);
			dispatch.forward(request, response);
		}
	}
}
