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
	private RequestDispatcher dispatch = null;
	private static String msg = "";
	private static double metrosAPies = 0;
	private static double piesAMetros = 0;
	private static String texto = "";
	private static double metros = 0;
	private static double pies = 0;
	private static boolean sonMetros = false;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_CONVERSOR).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		msg = "";
		DecimalFormat df = null;
		try {
			df = new DecimalFormat("#.00");
			
			dispatch = request.getRequestDispatcher(VIEW_CONVERSOR);
			
			String[] conversor = request.getParameterValues("formulario");
			
			if(conversor[0].equals(Integer.toString(1))) {
				//Entonces es convertir de metros a pies
				texto = request.getParameter("metros");
				metros = Double.parseDouble(texto);
				metrosAPies = metros * 3.2808;
				sonMetros = true;
			}else if(conversor[0].equals(Integer.toString(2))){
				//Sino de pies a metros
				texto = request.getParameter("pies");
				pies = Double.parseDouble(texto);
				piesAMetros = pies / 3.2808;
			}
			
		} catch (NumberFormatException e) {
			if(e.getMessage().contains("empty String")) {
				msg = "Debe introducir algo para poder convertirlo.";
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
