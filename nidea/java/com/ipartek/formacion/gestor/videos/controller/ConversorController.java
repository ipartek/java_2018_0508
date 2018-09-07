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
	double MEDIDA_PIES_METRO= 3.2808;
	double MEDIDA_METRO_PIES = 0.3048;
	String msg;
	String errorMsg;
	String conversionMetros;
	String conversionPiesRes;

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			queHacer(request,response);
		} catch (Exception e) {
			msg = "Se ha producido un error en doPost";
		}
		
		

	}

	private void queHacer(HttpServletRequest request, HttpServletResponse response) {
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
			queHacer(request,response);
		} catch (Exception e) {
			msg= "Se ha producido un error en doGet";
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
			request.setAttribute("pc",pies2Metros );
			System.out.println(msg);
			msg = pies2Metros+" Metros";
			request.setAttribute("msg",msg );

			request.getRequestDispatcher("conversor.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Intentelo de nuevo se ha producido un error al procesar la informacion");
			errorMsg = "Intentelo de nuevo se ha producido un error al procesar la informacion";
			request.setAttribute("msg", errorMsg);
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
			request.setAttribute("mc",metros2PiesRes );
			System.out.println(msg);
			msg = metros2PiesRes+" Pies";
			request.setAttribute("msg",msg );

			request.getRequestDispatcher("conversor.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Intentelo de nuevo se ha producido un error al procesar la informacion");
			msg = "Intentelo de nuevo se ha producido un error al procesar la informacion";
			request.setAttribute("msg", msg);
		}
	}


	private String convertirPies(double metrousuarioEntero) {


		conversionPiesRes =String.valueOf(( metrousuarioEntero * MEDIDA_PIES_METRO));
		System.out.println(conversionPiesRes);
		return conversionPiesRes;

	}
	private String convertirMetros(double piesUsuario) {
		
		conversionMetros =String.valueOf((piesUsuario * MEDIDA_METRO_PIES ) );
		System.out.println(conversionMetros);
		return conversionMetros;
	}
}
