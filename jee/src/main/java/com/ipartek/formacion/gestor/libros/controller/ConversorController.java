package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Saludo
 */
@WebServlet("/conversor")
public class ConversorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RequestDispatcher dispatch = null;
	private static final String VIEW = "conversor.jsp";
	
	private static String metros;
	private static String pies;
	private static double metrosF;
	private static double piesF;
	private static double metrosCv = 0;
	private static double piesCv = 0;
	private static String mensaje = "";
	private static String mensaje1 = "";
	private static String mensaje2 = "";
	private static String formulario;
	
	private static String rst = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			dispatch = request.getRequestDispatcher(VIEW);
			rst = (String) request.getParameter("rst");
			formulario = request.getParameter("formulario");
			
			if(rst != null) {
				metros = "0";
				pies = "0";
				metrosF = 0;
				piesF = 0;
				metrosCv = 0;
				piesCv = 0;
				mensaje = "";
				mensaje1 = "";
				mensaje2 = "";
				rst = null;
				
			}else {
				if("1".equals(formulario)) {
					conversorMetrosPies(request);
				}else {
					conversorPiesMetros(request);
				}
				
			}
			
		}catch(Exception e) {
			mensaje = "Introduce un valor correcto por favor";
		}finally {
			request.setAttribute("metros", metros);
			request.setAttribute("pies", pies);
			request.setAttribute("mensaje", mensaje);
			dispatch.forward(request, response);
		}
		
	}

	/**
	 * Metodo para convertir de metros a pies.
	 * @param request
	 */
	private void conversorMetrosPies(HttpServletRequest request){
		try {
			metros = request.getParameter("metros");
			if("".equals(metros)) {
				piesCv = 0;
				mensaje1 = "Introduce un numero para que podamos realizar la conversión por favor.";
			}else {
				mensaje1 = "";
				metrosF = Double.parseDouble(metros);
				piesCv = metrosF * 3.2808;
			}
			
			request.setAttribute("mensaje1", mensaje1);
			request.setAttribute("piesCv", piesCv);
		} catch (NumberFormatException e) {
			mensaje1 = "Lo sentimos, no se ha podido convertir " + metros + " de Metros a Pies.";
			request.setAttribute("mensaje1", mensaje1);
		}
	}
	
	/**
	 * Metodo para convertir de pies a metros.
	 * @param request
	 */
	private void conversorPiesMetros(HttpServletRequest request) {
		try {
			pies = request.getParameter("pies");
			if("".equals(pies)) {
				metrosCv = 0;
				mensaje2 = "Introduce un numero para que podamos realizar la conversión por favor.";
			}else {
				mensaje2 = "";
				piesF = Double.parseDouble(pies);
				metrosCv = piesF / 3.2808;
			}
			
			
			request.setAttribute("mensaje2", mensaje2);
			request.setAttribute("metrosCv", metrosCv);
		} catch (NumberFormatException e) {
			mensaje2 = "Lo sentimos, no se ha podido convertir " + pies + " de Pies a Metros.";
			request.setAttribute("mensaje2", mensaje2);
		}
	}

}
