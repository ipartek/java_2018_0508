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
	String palabraSecreta="cesar";
	static int vidas = 7;
	String longitudPalabra;
	String progresoPalabdraCodificada = "" ;
	ArrayList<String> valores = new ArrayList<String>(palabraSecreta.length());
	

	

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG =
	// Logger.getLogger(PrestamosController.class.getName());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*System.out.println("Pasamos por doPost()");

		// 1. Recibir parámetros
		String usuarioLetra = (String) request.getParameter("letraAhorcado");

		// 2. Validar parámetros
		if (usuarioLetra == null) {

			request.setAttribute("msg", "Por favor rellena el nombre y no seas vago.");
			request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
			
		} else if (!usuarioLetra.trim().isEmpty()) {
			request.setAttribute("letra", usuarioLetra);
		}

		// 4. Enviar atributos a la Vista
		request.getRequestDispatcher("ahorcado.jsp").forward(request, response);*/
		String palabraBuscar ="cesar";
		String msg = "";
		String palabraCodificada;
		try {
			
		
		System.out.println("Pasamos por doGet() +1");

		String usuarioLetra = (String) request.getParameter("letraAhorcado");
		
		if(palabraBuscar.contains(usuarioLetra)) {
			System.out.println("La palabra contiene la letra que has introducido");
			msg = "La palabra contiene la letra que has introducido";
		}else {
			System.out.println("No contiene la letra que has introducido");
			msg = "La palabra no contiene la letra que has introducido";
			
		}
		
		//palabraCodificada = calcularLongitud(palabraSecreta);
		//palabraCodificada = calcularAcertados(palabraSecreta,usuarioLetra);
		/*request.setAttribute("pc", palabraCodificada);
		request.setAttribute("letraAhorcado", usuarioLetra);
		request.setAttribute("msg", msg);
		request.setAttribute("vidas", vidas);
		

		request.getRequestDispatcher("ahorcado.jsp").forward(request, response);*/
	}
	 catch (Exception e) {
		// TODO: handle exception
	}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//doPost( request, response);
		String palabraBuscar ="cesar";
		String msg = "";
		String palabraCodificada;
		String palabraLongitud;
		try {
			
		if(vidas > 0) {
			System.out.println("Pasamos por doGet() +1");

			String usuarioLetra = (String) request.getParameter("letraAhorcado");
			
			if(palabraBuscar.contains(usuarioLetra)) {
				msg = "Enhorabuena !! La palabra contiene la letra que has introducido";
			}else {
				msg = "No ha tenido suerte !!";
				vidas -= 1;
				
			}
			
			palabraLongitud = calcularLongitud(palabraSecreta);
			palabraCodificada = calcularAcertados(palabraSecreta,usuarioLetra,palabraLongitud);
			request.setAttribute("pc", palabraCodificada);
			request.setAttribute("letraAhorcado", usuarioLetra);
			request.setAttribute("msg", msg);
			request.setAttribute("vidas", vidas);
			

			request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		}
		else {
			System.out.println("");
			vidas = 7;
			request.getRequestDispatcher("ahorcado_try_again.jsp").forward(request, response);
		}
		
			
		}
		
	 catch (Exception e) {
		// TODO: handle exception
	}

	}

	private String calcularAcertados(String palabraSecreta,String usuarioLetra, String palabraLongitud) {
		int cantidadCaracteres;
		String palabraCodificada="";
		
		
		try {
			
		
		cantidadCaracteres = palabraSecreta.length();
		for (int x = 0; x < cantidadCaracteres; x++) {
			if(palabraSecreta.charAt(x) == usuarioLetra.charAt(0)) {
				palabraCodificada += usuarioLetra;
				//arrayChar[x] = (char) palabraSecreta.charAt(x);
				//System.out.println(arrayChar[x]);
				palabraCodificada.replace(palabraCodificada.charAt(x), palabraSecreta.charAt(x));
				//progresoPalabdraCodificada.replace(palabraCodificada.charAt(x), palabraSecreta.charAt(x));
				//valoresArray.add(palabraCodificada);
				//valoresArray.set(x, palabraCodificada);
				//valores.add(usuarioLetra);
				valores.set(x, usuarioLetra);
			}
		
			}
		
		progresoPalabdraCodificada = palabraCodificada;
		//Una vez que tenemos el caracter descubierto debemos guardarlo y compàrarlo con el que pudiera haber antes
		/*for(int y = 0; y < palabraCodificada.length(); y++) {
				
			if(progresoPalabdraCodificada.charAt(y) != palabraCodificada.charAt(y)) {
				progresoPalabdraCodificada = palabraCodificada.charAt(y) ;
			}
			
			
		}*/
		
		System.out.println(palabraCodificada);
		System.out.println(progresoPalabdraCodificada);
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return palabraCodificada;
	}

	private String calcularLongitud(String palabraSecreta2) {
		int cantidadCaracteres;
		String palabraCodificada="";
		cantidadCaracteres = palabraSecreta2.length();
		for (int x = 0; x < cantidadCaracteres; x++) {
			palabraCodificada +=  "*";
			progresoPalabdraCodificada += "*";
		}
		System.out.println(palabraCodificada);
		return palabraCodificada;
		
	}
	}
