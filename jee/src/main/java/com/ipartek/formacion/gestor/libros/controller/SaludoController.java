package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saludo")
public class SaludoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private static final String VIEW_INDEX = "index.jsp";
	private static final String VIEW_SALUDO = "saludo.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO implementar logger
		System.out.println("Pasamos por doGet()");
		
		//1. Recibir parámetros
		
		String parametroNombreGet = request.getParameter("nombre");
		String parametroAp1Get = request.getParameter("ap1");
		String parametroAp2Get = request.getParameter("ap2");
		
		
		//2. Validar parámetros(si procede)
		
		
		//3. Llamar modelo DAO
		
		
		//4. Enviar atributos al la vista
		String nombreCompleto = String.format("Nombre completo %s %s %s ", parametroNombreGet, parametroAp1Get, parametroAp2Get);
		request.setAttribute("nombreCompleto", nombreCompleto);		
		
		//5. Ir a la vista
		request.getRequestDispatcher("saludo.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			dispatch = request.getRequestDispatcher(VIEW_INDEX);
			
			//1. Recibir parámetros
			String parametroNombrePost = request.getParameter("nombrePost");
					
			
			//2. Validar parámetros(si procede)
			if(parametroNombrePost != null && !"".equals(parametroNombrePost.trim())) {
				request.setAttribute("nombrePost", parametroNombrePost + " envío por POST");
				dispatch = request.getRequestDispatcher(VIEW_SALUDO);
				
			}else {
				request.setAttribute("msg", "Por favor, rellena el nombre vago");
				dispatch = request.getRequestDispatcher(VIEW_INDEX);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dispatch.forward(request, response);
		}
	}
	
}