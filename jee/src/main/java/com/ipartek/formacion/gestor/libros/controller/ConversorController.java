package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conversor")
public class ConversorController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW_CONVERSOR = "conversor.jsp";
	private static final double PIES =  3.2808f;
	private RequestDispatcher dispatch = null;
	//parametros
	private static String texto = "";
	private static double metros = 0;
	private static double pies = 0;
	private static String formulario = "";
	//atributos
	private static String msg = "";
	private static double metrosAPies = 0;
	private static double piesAMetros = 0;	
	
	private static boolean sonMetros = false;
	public static final int FORMULARIO1 = 1;
	public static final int FORMULARIO2 = 2;

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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Al estar pidiendo que te den datos deberia de ser con get pero si se hace con post no pasa nada*/		
		msg = "";
		
		DecimalFormat df = null;
		try {
			df = new DecimalFormat("#.00");
			
			dispatch = request.getRequestDispatcher(VIEW_CONVERSOR);
						
			formulario = request.getParameter("formulario");			
			
			if(formulario.equals(Integer.toString(FORMULARIO1))) {
				//Entonces es convertir de metros a pies
				texto = request.getParameter("metros");
				metros = Double.parseDouble(texto);
				metrosAPies = metros * PIES;
				sonMetros = true;
			}else if(formulario.equals(Integer.toString(FORMULARIO2))){
				//Sino de pies a metros
				texto = request.getParameter("pies");
				pies = Double.parseDouble(texto);
				piesAMetros = pies / PIES;
			}
			
		} catch (NumberFormatException e) {
			if(e.getMessage().contains("empty String")) {
				msg = "Debe introducir algo para poder convertirlo.";
				metros = 0;
				pies = 0;
			}else{
				msg = "Error no se puede convertir " + texto;
				if(sonMetros) {
					msg = msg + " a metros";
				}else {
					msg = msg + " a pies";
				}
			}
			
		}catch (Exception e) {
			msg = "Error en la llamada.";
		}finally {
			request.setAttribute("msg", msg);
			request.setAttribute("metros", metros);
			request.setAttribute("pies", pies);
			request.setAttribute("metrosConvertidos", df.format(metrosAPies));
			request.setAttribute("piesConvertidos", df.format(piesAMetros));
			dispatch.forward(request, response);
		}
	}
}
