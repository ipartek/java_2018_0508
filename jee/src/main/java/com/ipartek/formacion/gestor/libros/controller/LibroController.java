package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.libros.pojo.Libro;

@WebServlet("/libro")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatch = null;

	private static final String VIEW = "crearLibro.jsp";	
	private static final int MAX_ISBN=5;
	
	private static String tituloReg="";
	private static String isbnReg="";
	private static String editorialReg="";
	private static String prestadoReg="";
	private static Libro libro=null;

	private static String msg = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			libro=new Libro();
			msg = "";
			dispatch = request.getRequestDispatcher(VIEW);
			
			tituloReg = request.getParameter("titulo");
			isbnReg=request.getParameter("isbn");
			editorialReg=request.getParameter("editorial");
			prestadoReg=request.getParameter("prestado");
			
			if (tituloReg!=null ) {
				libro.setTitulo(tituloReg);
				
			}
			if(isbnReg!=null) {
				if (isbnReg.length()>=MAX_ISBN) {
					libro.setIsbn(isbnReg);
				}				
				
			}
			if (editorialReg!=null) {
				libro.setEditorial(editorialReg);
				
				
			}
			if (prestadoReg!=null) {
				
			}
			
			
			
		} catch (Exception e) {
			
		}finally {
			request.setAttribute("msg", msg);
			dispatch.forward(request, response);
		}

	}
}
