package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/libro")
public class LibroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private static final String VIEW_LOGIN = "libro.jsp";
	private static final String VIEW_SHOW = "detalleLibro.jsp";
	public static final int ISBN_MIN_LENGTH=5;
	public static final String ISBN_MIN_EXCEPTION="La longitud minima del ISBN debe ser " + ISBN_MIN_LENGTH; //El mensaje que lanzara la excepcion
	//Constantes
	private  String paramTitulo = "";//INTRODUCE EL CLIENTE
	private  String paramEditorial = "";//INTRODUCE EL CLIENTE
	private  String paramIsbn = "";//INTRODUCE EL CLIENTE
	private  String mensaje="";

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
		
		try {
			// TODA LA EXTRUCTURA
			dispatch = request.getRequestDispatcher(VIEW_LOGIN);		
			
			
			
			
			try {
				paramTitulo=request.getParameter("titulo");
				paramEditorial=request.getParameter("editorial");
				paramIsbn=request.getParameter("isbn");
				
				//COMPROBACION TITULO
				if(paramTitulo==null || paramTitulo.isEmpty()) { 	//VACIO
					request.setAttribute("valorTitulo",paramTitulo);
					mensaje="Rellena la casilla titulo";
					
				}else {
					
					request.setAttribute("titulo",paramTitulo);
					//COMPROBACION EDITORIAL
					 if(paramEditorial==null || paramEditorial.isEmpty()) {
						 request.setAttribute("valorEditorial",paramEditorial);
							mensaje="Completa la casilla Editorial";
					 } else {
						 request.setAttribute("editorial",paramEditorial);
					 }
				}
			}catch (Exception e) {
				mensaje="error catch";
			}
			
				
			/*
			if(paramIsbn !=null && paramIsbn.length() >= ISBN_MIN_LENGTH) {
				request.setAttribute("isbn",paramIsbn);
			}else {
				throw new Exception(ISBN_MIN_EXCEPTION);
			}
		*/

		} catch (Exception e) {
			mensaje="Lo sentimos pero tenemos un fallo inesperado ";
			e.printStackTrace();
			
		} finally {
			/*request.setAttribute("titulo",paramTitulo);
			request.setAttribute("editorial",paramEditorial);*/
			request.setAttribute("msg",mensaje);
			//dispatch=request.getRequestDispatcher(VIEW_SHOW);
			dispatch.forward(request, response);
		}

	}

}
