package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conversor")
public class ConversorController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private static final String VIEW = "conversor.jsp";
	private static double conversordePies = 0.3048;
	//Constantes
	private  double resultado=0;
	private  String paramPies = "";//INTRODUCE EL CLIENTE
	private  String paramMetros = "";//INTRODUCE EL CLIENTE
	
	//Parametro parseado
	private double doblePies = 0;
	private double dobleMetros=0;
	private  int formulario = 0;
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);// Porque recibimos los conversores por post

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);// Porque aterrizamos en conversor.jsp por get
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		DecimalFormat df = new DecimalFormat("0.00");
		try {

			// TODA LA EXTRUCTURA
			dispatch = request.getRequestDispatcher(VIEW);
			formulario = Integer.parseInt(request.getParameter("formulario"));

			// CONVERSOR DE PIES A METROS
			if (formulario == 1) {

				paramPies = request.getParameter("pies");
				doblePies = Double.parseDouble(paramPies);
				resultado = doblePies * conversordePies;

				request.setAttribute("resultado1", df.format(resultado));
				request.setAttribute("ParamIntroPies", paramPies);

				// CONVERSOR DE METROS A PIES
			} else if (formulario == 2) {

				paramMetros = request.getParameter("metros");
				dobleMetros = Double.parseDouble(paramMetros);
				resultado = dobleMetros / conversordePies;

				request.setAttribute("resultado2", df.format(resultado));
				request.setAttribute("ParamIntroMetros", paramMetros);
			}

		} catch (NumberFormatException e) {

			if(e.getMessage().contains("empty String")) {
				request.setAttribute("msg", "Introduce un numero por favor");
			}else{
				if (formulario == 1) {
					request.setAttribute("msg","ERROR.El programa no puede convertir <b> " + paramPies + "</b> a Metros.");
					request.setAttribute("resultado1","");
				}else{
					request.setAttribute("msg","ERROR.El programa no puede convertir <b>" + paramMetros + "</b>  a Pies.");
					request.setAttribute("resultado2","");
				}
			}

	} catch (Exception e) {
			request.setAttribute("msg",
					"Lo sentimos pero tenemos un fallo inesperado <b>" + paramMetros + "</b>  a Pies.");
			e.printStackTrace();
			
		} finally {
			dispatch.forward(request, response);
		}

	}

}
