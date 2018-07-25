package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/convertir")
public class ConversorController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static String msg;
	private static float num;
	private static float resultado;
	

	public ConversorController() {
		
		inicializarConversor();
	}
	
	private void inicializarConversor() {
		
		msg = "";
		num = 0;
		resultado = 0;
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// Leemos los PARAMETROS de la vista
			String entrada = request.getParameter("num");
			String operacion = request.getParameter("operacion");
			
			// Trabajamos con ellos
			if (entrada != null && entrada.trim().length() > 1) {
				
				try {	
					//boolean esError = false; // Por si hay algún error inesperado
					
					num = Float.parseFloat(entrada);
					
					calcula(operacion, num);
					
					

					
					
				} catch (NumberFormatException e){
					msg = "No se puede convertir " + entrada;
				}
				
			} else if (entrada == null) {
				msg = "El campo no puede estar vacío.";
			}
			
			// Enviamos los ATRIBUTOS
			request.setAttribute("msg", msg);
			
			// Llamamos a la VISTA
			request.getRequestDispatcher("conversor.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	private void calcula(String operacion, float num) {
		
		String mensajeFinal = Float.toString(num);
		
		switch (operacion) {
		case "Metros a Pulgadas": // Metros - Pulgadas
			
			resultado = num * 39.370f;
			mensajeFinal += " metros = " + Float.toString(resultado) + " pulgadas";
			break;
			
		case "Pulgadas a Metros": // Pulgadas - Metros
			
			resultado = num / 39.370f;
			mensajeFinal += " pulgadas = " + Float.toString(resultado) + " metros";
			break;	
			
		default:
			break;
		}
		
		
		msg = mensajeFinal;
		
	}

}
