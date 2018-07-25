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
	private RequestDispatcher dispatch = null;
	private static final String VIEW_AHORCADO = "ahorcado.jsp";
	private static final String PALABRA_SECRETA = "cersar";
	private static final int MAXIMO_FALLOS = 7;
	private static int fallos = 0;
	private static String palabraMostrar = "??????";
	private static int aciertos = 0;
	private static String mensaje = "";
	
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
			boolean letraEncontrada = false;
			
			//1. Recibir parámetros
			String letraIntroducida = request.getParameter("letra");
			
			//2. Validar parámetros(si procede)
			
			if(letraIntroducida != null && !"".equals(letraIntroducida.trim())) {
			
				char letra = Character.toLowerCase(letraIntroducida.charAt(0));
				
				for (int i = 0; i < PALABRA_SECRETA.length(); i++) {
					
					if(letra == PALABRA_SECRETA.charAt(i)) {
						palabraMostrar = replaceCharAt(palabraMostrar, i, letra); 
						mensaje = "La letra " + letra + " es correcta";
						letraEncontrada = true;
						aciertos++;
					}
				}
				
				if(aciertos == PALABRA_SECRETA.length()) {
					request.setAttribute("msg", "Enhorabuena, has acertado la palabra secreta.");
				}
				
				if(letraEncontrada == false) {
					fallos++;
					mensaje = "La letra " + letra + " no es correcta";
				}
				
				if(fallos == MAXIMO_FALLOS) {
					fallos = 0;
					aciertos = 0;
					palabraMostrar = "??????";
					mensaje = "Lo sentimos, no has acertado la palabra";
				}
				
			}else {
				
				mensaje = "Por favor, introduce una letra vago";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {

			request.setAttribute("eliminado", mensaje);
			request.setAttribute("msg", mensaje);
			request.setAttribute("fallos", fallos);
			request.setAttribute("palabraMostrar", palabraMostrar);
			dispatch.forward(request, response);
		}
		
	}
	
	public static String replaceCharAt(String s, int pos, char c) {
		return s.substring(0, pos) + c + s.substring(pos + 1);
	}
	
}
