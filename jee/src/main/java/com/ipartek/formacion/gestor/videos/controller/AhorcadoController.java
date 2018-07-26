package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ahorcado")
public class AhorcadoController extends HttpServlet {
	
	static int vidas = 6;

	//ArrayList<String> valores = new ArrayList<String>();
	String palabraSecretas[]={"monitor","webcam","procesador","cesar","reballing"};
	String SugerenciasSecretas[]={
						"Periferico de salida",
						"Periferico de entrada",
						"En Hardware: que interpreta las instrucciones y procesa los datos",
						"cifrado por desplazamiento",
						"Tecnica de reparacion electronica"
						};
	int nRandom = palabraRandomCalcula(palabraSecretas.length);
	String palabraSecreta = palabraSecretas[nRandom];
	String palabraLongitud = calcularLongitud(palabraSecreta);
	String palabraCodificada = calcularLongitud(palabraSecreta);
	String progresoPalabdraCodificada = calcularLongitud(palabraSecreta);
	boolean letraRepetida = false;
	String stilos = "fallo6";
	

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG =
	// Logger.getLogger(PrestamosController.class.getName());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
		/*
		 * System.out.println("Pasamos por doPost()");
		 * 
		 * // 1. Recibir parámetros String usuarioLetra = (String)
		 * request.getParameter("letraAhorcado");
		 * 
		 * // 2. Validar parámetros if (usuarioLetra == null) {
		 * 
		 * request.setAttribute("msg", "Por favor rellena el nombre y no seas vago.");
		 * request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		 * 
		 * } else if (!usuarioLetra.trim().isEmpty()) { request.setAttribute("letra",
		 * usuarioLetra); }
		 * 
		 * // 4. Enviar atributos a la Vista
		 * request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		 */

	}

	private int palabraRandomCalcula(int longitudArray) {
		
		return (int) (Math.random() * longitudArray) ;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doPost( request, response);
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		String palabraCodificada;
		try {
			if (request.getParameter("reiniciar") != null  && request.getParameter("reiniciar").equals("restart")){
				reiniciar(request,response);
			}
			if (request.getParameter("mostrarPalabra") != null  && request.getParameter("mostrarPalabra").equals("Start")){
				establecerPalabra(request,response);
			}
			if (vidas >= 0) {
				System.out.println("Pasamos por doProcess() +1");

				String usuarioLetra = (String) request.getParameter("letraAhorcado");

				if (palabraSecreta.contains(usuarioLetra)) {
					msg = "Enhorabuena !! La palabra contiene la letra que has introducido";
				} else {
					msg = "No ha tenido suerte !!";
					vidas -= 1;
					System.out.println(vidas);
					stilos=actualizaStilos(vidas);

				}

				// palabraLongitud = calcularLongitud(palabraSecreta);
				palabraCodificada = calcularAcertados(palabraSecreta, usuarioLetra, palabraLongitud);
				request.setAttribute("Sugerencias", SugerenciasSecretas[nRandom]);
				request.setAttribute("pc", palabraCodificada);
				request.setAttribute("letraAhorcado", usuarioLetra);
				request.setAttribute("msg", msg);
				request.setAttribute("vidas", vidas);
				request.setAttribute("stilos", stilos);
				request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
			} else {
				System.out.println("");
				
				request.getRequestDispatcher("ahorcado_try_again.jsp").forward(request, response);
			}

		}

		catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void reiniciar(HttpServletRequest request, HttpServletResponse response) {
		try {
			
		
		vidas = 7;

		//ArrayList<String> valores = new ArrayList<String>();
		
		palabraRandomCalcula(palabraSecretas.length);
		palabraSecreta = palabraSecretas[nRandom];
		palabraLongitud = calcularLongitud(palabraSecreta);
		palabraCodificada = calcularLongitud(palabraSecreta);
		progresoPalabdraCodificada = calcularLongitud(palabraSecreta);
		stilos = "fallo6";
		request.setAttribute("Sugerencias", SugerenciasSecretas[nRandom]);
		request.setAttribute("pc", palabraCodificada);
		request.setAttribute("vidas", vidas);
		request.setAttribute("stilos", stilos);
		request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Fallo reiniciando");
		}
		
		
	}

	private String actualizaStilos(int vidas2) {
		String stilos ;
		switch (vidas2) {
		case 0:
			stilos = "<div class='fallo0'></div>";
			break;

		case 1:
			stilos = "<div class='fallo1'></div>";
			break;
		case 2:
			stilos = "<div class='fallo2'></div>";
			break;
		case 3:
			stilos ="<div class='fallo3'></div>";
			break;
		case 4:
			stilos = "<div class='fallo4'></div>";
			break;
		case 5:
			stilos = "<div class='fallo5'></div>";
			break;
		case 6:
			stilos = "<div class='fallo6'></div>";
			break;

		default:
			stilos = "<div>Juega una partida</div>";
		}
		return stilos;
		
	}

	private void establecerPalabra(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * Cuando se pulsa Start se muestra por pantalla la longitud de la palabra a adivinar
		 */
		try {
			calcularLongitud(palabraSecreta);
			
			request.setAttribute("pc", palabraCodificada);		
			request.setAttribute("stilos", stilos);
			request.setAttribute("Sugerencias", SugerenciasSecretas[nRandom]);
			request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error en establecerPalabra");
		}
			
			
		
	}
	

	private String calcularAcertados(String palabraSecreta, String usuarioLetra, String palabraLongitud) {
		int cantidadCaracteres;

		char letra = Character.toLowerCase(usuarioLetra.charAt(0));

		try {

			cantidadCaracteres = palabraSecreta.length();
			for (int x = 0; x < cantidadCaracteres; x++) {
				if (palabraSecreta.charAt(x) == usuarioLetra.charAt(0)) {
					// remplazamos los caracteres que vamos acertando
					palabraCodificada = replaceCharAt(progresoPalabdraCodificada, x, letra);
					

				}
				progresoPalabdraCodificada = palabraCodificada;

			}

			

			System.out.println(palabraCodificada);
			System.out.println(progresoPalabdraCodificada);

		} catch (Exception e) {

		}
		return palabraCodificada;
	}

	private String replaceCharAt(String s, int pos, char c) {
		/**
		 * Nos remplaza en una cadena de caracteres el caracter acertado
		 */
		return s.substring(0, pos) + c + s.substring(pos + 1);

	}

	private String calcularLongitud(String palabraSecreta2) {
		int cantidadCaracteres;
		String palabraCodificada = "";
		cantidadCaracteres = palabraSecreta2.length();
		for (int x = 0; x < cantidadCaracteres; x++) {
			palabraCodificada += "*";
			progresoPalabdraCodificada += "*";
		}
		System.out.println(palabraCodificada);
		return palabraCodificada;

	}
}
