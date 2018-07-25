package com.ipartek.formacion.gestor.libros.controller; 

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ahorcado")  //La url a la que hay que escuchar, SIEMPRE empieza por barra( / )
public class AhorcadoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static boolean letraEncontrada = false;
	private RequestDispatcher dispatch = null;
	private static final String VIEW_AHORCADO = "ahorcado.jsp";
	private static final String PALABRA_SECRETA = "cersar";
	private static final int MAXIMO_FALLOS = 7;
	private static int numeroFallos = 0;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doProcess(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		doProcess(request, response);
		
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
					
			dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
			
			//1. Recibir parámetros
			String letraIntroducida = request.getParameter("letra");
			
			//2. Validar parámetros(si procede)
			
			if(letraIntroducida != null && !"".equals(letraIntroducida.trim())) {
			
				char letra = Character.toLowerCase(letraIntroducida.charAt(0));
				
				for (int i = 0; i < PALABRA_SECRETA.length(); i++) {
					
					if(letra == PALABRA_SECRETA.charAt(i)) {
						request.setAttribute("letra" + i, letra);
						request.setAttribute("encontrado", "La letra " + letra + " es correcta");
						letraEncontrada = true;
						//dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
						//break;
						
					}
				}
				
				if(letraEncontrada == false) {
					numeroFallos++;
					request.setAttribute("encontrado", "La letra " + letraIntroducida + " no es correcta");
					//dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
				}
				
				if(numeroFallos == MAXIMO_FALLOS) {
					request.setAttribute("eliminado", "Lo sentimos, no has acertado la palabra");
					//dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
				}
				
			}else {
				
				request.setAttribute("msg", "Por favor, introduce una letra vago");
				dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			dispatch.forward(request, response);
		}
		
	}
	
}
