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
	private static String VIEW_INDEX = "index.jsp";
	private static String VIEW_JUEGO = "juego.jsp";
	private static final String palabra = "cesar";
	private static char[] respuesta = new char[5];
	private static int fallos;

	public JuegoController() {
		initValues();		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			dispatch = request.getRequestDispatcher(VIEW_INDEX);

			// 1.recibir parametros
			char letra = request.getParameter("letra").trim().charAt(0);
			// List<Integer> positions = new ArrayList<Integer>();
			String msg = "";

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
			
			String respuesta_str = new String(respuesta);
			if (palabra.equals(respuesta_str)) {
				msg = "Ganaste!";
				initValues();
				dispatch = request.getRequestDispatcher(VIEW_INDEX);
				
				
				
			}else {
		
				// 4.enviar atributos a la vista
				request.setAttribute("fail", "fallo" + fallos);
				request.setAttribute("respuesta", respuesta_str);
				request.setAttribute("resultado", msg);

				// 5.ir a la vista
				dispatch = request.getRequestDispatcher(VIEW_JUEGO);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			dispatch = request.getRequestDispatcher(VIEW_INDEX);
		} finally {
			dispatch.forward(request, response);
		}
	}
	
	private void initValues() {
		Arrays.fill(respuesta, '_');
		fallos=0;
		
	}

}
