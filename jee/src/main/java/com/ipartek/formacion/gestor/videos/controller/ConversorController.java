package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conversor")
public class ConversorController extends HttpServlet {
	double medidaPiesMetro = 3.2808;
	double medidaMetroPies = 0.3048;
	String msg;

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m2p = request.getParameter("m2p");
		String p2m = request.getParameter("p2m");

		if (m2p != null) {
			doProcessM2p(request, response);
		} else {
			if (p2m != null) {
				doProcessP2m(request, response);
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String m2p = request.getParameter("m2p");
			String p2m = request.getParameter("p2m");

			if (m2p != null) {
				doProcessM2p(request, response);
			} else {
				if (p2m != null) {
					doProcessP2m(request, response);
				}
			}
		} catch (Exception e) {
			System.out.println("Problema en doGet");
		}
		

	}

	private void doProcessP2m(HttpServletRequest request, HttpServletResponse response) {
		String pies2Metros;
		System.out.println("Calcular pies a metros");
		try {

			double piesUsuario = Double.parseDouble(request.getParameter("p2m"));

			System.out.println(piesUsuario);
			// convertirPies(metrousuarioEntero);
			pies2Metros = convertirMetros(piesUsuario);
			request.setAttribute("piesConvertidos",pies2Metros );

			request.getRequestDispatcher("conversor.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Intentelo de nuevo se ha producido un error al procesar la informacion");
			msg = "Intentelo de nuevo se ha producido un error al procesar la informacion";
			request.setAttribute("msg", msg);
		}

	}

	

	private void doProcessM2p(HttpServletRequest request, HttpServletResponse response) {
		String metros2PiesRes;

		System.out.println("Calcular metros a pies");
		try {

			double metrousuarioEntero = Double.parseDouble(request.getParameter("m2p"));

			System.out.println(metrousuarioEntero);
			// convertirPies(metrousuarioEntero);
			metros2PiesRes = convertirPies(metrousuarioEntero) ;
			request.setAttribute("metrosConvertidos",metros2PiesRes );

			request.getRequestDispatcher("conversor.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Intentelo de nuevo se ha producido un error al procesar la informacion");
			msg = "Intentelo de nuevo se ha producido un error al procesar la informacion";
			request.setAttribute("msg", msg);
		}
	}


	private String convertirPies(double metrousuarioEntero) {
		String conversionPies;

		conversionPies =String.valueOf(( metrousuarioEntero * medidaPiesMetro));
		System.out.println(conversionPies);
		return conversionPies;

	}
	private String convertirMetros(double piesUsuario) {
		String conversionMetros;
		
		conversionMetros =String.valueOf((piesUsuario * medidaMetroPies ) );
		System.out.println(conversionMetros);
		return conversionMetros;
	}
}
