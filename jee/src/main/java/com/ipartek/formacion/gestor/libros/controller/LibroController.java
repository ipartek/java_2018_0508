package com.ipartek.formacion.gestor.libros.controller; 

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.libros.pojo.Libro;

@WebServlet("/libro")  //La url a la que hay que escuchar, SIEMPRE empieza por barra( / )
public class LibroController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	
	private static final String LIBRO_VIEW = "libro.jsp";
	private static final String DETALLE_VIEW = "detalleLibro.jsp";
	private static int CONTADOR = 0;
	private static String titulo = "";
	private static String isbn = "";
	private static String editorial = "";
	private static String prestado = "";
	private static String mensaje = "";
	
	public static final int ISBN_MIN_LENGTH = 5;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doProcess(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		doProcess(request, response);
		
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			dispatch = request.getRequestDispatcher(LIBRO_VIEW);
			
			titulo = request.getParameter("titulo");
			isbn = request.getParameter("isbn");
			editorial = request.getParameter("editorial");
			prestado = request.getParameter("prestado");
			
			boolean isPrestado = false;
			
			
			if((titulo != null && !"".equals(titulo)) && (isbn != null && !"".equals(isbn) && isbn.length() >= ISBN_MIN_LENGTH) && 
					(editorial != null && !"".equals(editorial))) {
				
				if(prestado != null) {
					isPrestado = true;
					request.setAttribute("detallePrestado", "Sí");
					
				}else {
					request.setAttribute("detallePrestado", "No");
				}
				
				Libro libro = new Libro(++CONTADOR, isbn, titulo, editorial, isPrestado);
				
				dispatch = request.getRequestDispatcher(DETALLE_VIEW);
				
				request.setAttribute("detalleID", libro.getId());
				request.setAttribute("detalleIsbn", libro.getIsbn());
				request.setAttribute("detalleTitulo", libro.getTitulo());
				request.setAttribute("detalleEditorial", libro.getEditorial());
				
				

			}
			if(titulo == null) {
				mensaje = "";
			}else {
				mensaje = "Los datos no son correctos";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			request.setAttribute("titulo", titulo);
			request.setAttribute("isbn", isbn);
			request.setAttribute("editorial", editorial);
			request.setAttribute("msg", mensaje);
			dispatch.forward(request, response);
		}
		
	}

}
