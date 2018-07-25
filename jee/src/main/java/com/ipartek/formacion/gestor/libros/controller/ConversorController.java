package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_CONVERSOR).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			dispatch = request.getRequestDispatcher(VIEW_CONVERSOR);
			
			String[] conversor = request.getParameterValues("formulario");
			
			if(conversor[0].equals(Integer.toString(1))) {
				//Entonces es convertir de metros a pies
				texto = request.getParameter("metros");
				double metros = Double.parseDouble(texto);
				System.out.println(metros);
				metrosAPies = metros * 3.2808;
			}else{
				//Sino de pies a metros
				double pies = Double.parseDouble(request.getParameter("pies"));
				piesAMetros = pies / 3.2808;
			}
			
		} catch (NumberFormatException e) {
			if(e.getMessage().contains("empty String")) {
				msg = "Debe introducir algo para poder convertirlo.";
			}else{
				msg = "Debe introducir un numero y no cualquier carácter.";
			}
			
		}catch (Exception e) {
			msg = "Error en la llamada.";
		}finally {
			request.setAttribute("msg", msg);
			request.setAttribute("metrosConvertidos", metrosAPies);
			request.setAttribute("piesConvertidos", piesAMetros);
			dispatch.forward(request, response);
		}
	}
}
