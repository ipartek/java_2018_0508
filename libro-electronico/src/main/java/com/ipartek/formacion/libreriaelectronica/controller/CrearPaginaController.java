package com.ipartek.formacion.libreriaelectronica.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libreriaelectronica.model.Pagina;
import com.ipartek.formacion.libreriaelectronica.model.PaginaArrayDAO;

/**
 * Servlet implementation class CrearPaginaController
 */
@WebServlet("/nuevapagina")
public class CrearPaginaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static PaginaArrayDAO dao;
	
	private static String titulo = "";
	private static String contenido = "";
	private static String nombreUsuario = "";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/edicion/crearPagina.jsp";
		String msg = "Ha ocurrido un error";
		
		try {
			dao = PaginaArrayDAO.getInstance();
			
			//Recoger parametros
			titulo = request.getParameter("titulo");
			contenido = request.getParameter("contenido");
			nombreUsuario = request.getParameter("nombreUsuario");
			
			//Validacion de parametros
			if(titulo != null && contenido != null && nombreUsuario != null){
				
				if(comprobarMinPalabras(contenido)) {
					Pagina p = new Pagina();
					p.setId(dao.length());
					p.setTitulo(titulo);
					p.setContenido(contenido);				
					p.setNombreUsuario(nombreUsuario);
					
					dao.insert(p);
					
					view = "/home";
					
					msg = "Pagina creada con exito";
				}else {
					msg = "Debes introducir en el contenido al menos 25 palabras.";
				}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			response.sendRedirect(request.getContextPath() + view + "?msg="+msg);
		}
	}

	private boolean comprobarMinPalabras(String contenido) {
		boolean minPalabras = false;
		int contador = 0;
		if(contenido != null) {
			Scanner scannerTexto = new Scanner(contenido);
			while(scannerTexto.hasNextLine()) {
			    String linea = scannerTexto.nextLine();
			    contador += linea.split("\\s+").length;
			}
			scannerTexto.close();
		}
		
		if(contador >= 25) {
			minPalabras = true;
		}
		
		return minPalabras;
	}

}
