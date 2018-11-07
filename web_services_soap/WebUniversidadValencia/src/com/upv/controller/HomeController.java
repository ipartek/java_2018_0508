package com.upv.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UASI.WS_GRAL_wsdl.ClaseAlojamiento;
import UASI.WS_GRAL_wsdl.Pub_gralSoapProxy;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClaseAlojamiento[] alojamientos = null;
		try {
			
			Pub_gralSoapProxy client = new Pub_gralSoapProxy();
			alojamientos = client.wsalojamientos();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("titulo", "Alojamientos Universida Valencia");
		request.setAttribute("alojamientos",alojamientos);
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
