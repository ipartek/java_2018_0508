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
	private static boolean LETRA_ENCONTRADA = false;
	private RequestDispatcher dispatch = null;
	private static final String VIEW_AHORCADO = "ahorcado.jsp";
	private static final int MAXIMO_FALLOS = 7;
	private static int NUMERO_FALLOS = 0;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
		dispatch.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			String palabra[] = new String[5];
			palabra[0] = "c";
			palabra[1] = "e";
			palabra[2] = "s";
			palabra[3] = "a";
			palabra[4] = "r";
			
			dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
			
			
			
			//1. Recibir parámetros
			String letraIntroducida = request.getParameter("letra");
			
			//2. Validar parámetros(si procede)
			
			if(letraIntroducida != null && !"".equals(letraIntroducida.trim())) {
				
				for (int i = 0; i < palabra.length; i++) {
					
					if(letraIntroducida.trim().equals(palabra[i])) {
						request.setAttribute("letra" + i, letraIntroducida);
						request.setAttribute("encontrado", "La letra " + letraIntroducida + " es correcta");
						LETRA_ENCONTRADA = true;
						dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
						break;
						
					}
				}
				
				if(LETRA_ENCONTRADA == false) {
					NUMERO_FALLOS++;
					request.setAttribute("encontrado", "La letra " + letraIntroducida + " no es correcta");
					dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
				}
				
				if(NUMERO_FALLOS == MAXIMO_FALLOS) {
					request.setAttribute("eliminado", "Lo sentimos, no has acertado la palabra");
					dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
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
		
		
		//3. Llamar modelo DAO
		
		
		//4. Enviar atributos al la vista
		
		
		//5. Ir a la vista
		
	}
	
}
