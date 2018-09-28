package com.ipartek.formacion.libro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libro.model.Pagina;
import com.ipartek.formacion.libro.model.PaginaArrayListDAO;
import com.ipartek.formacion.libro.model.Usuario;

/**
 * Servlet implementation class EscribirController
 */
@WebServlet("/escribir")
public class EscribirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static long ID = 1;
	private static PaginaArrayListDAO dao;
	private ArrayList<Pagina> paginas;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		dao = PaginaArrayListDAO.getInstance();
		
		try {
			String texto = request.getParameter("texto");
			String[] palabras = texto.split(" ");
			
			if(palabras.length < 25) {
				request.getRequestDispatcher("privado/escribir.jsp").forward(request, response);
				
			}else {
				
				HttpSession session = request.getSession();
				Usuario u = (Usuario) session.getAttribute("usuario");
				String autor = u.getNombre();
				Pagina p = new Pagina(ID++, texto, autor);
				if(paginas == null) {
					paginas = (ArrayList<Pagina>) dao.getAll();
				}
				paginas.add(p);
				int nPaginas = paginas.size();
				request.setAttribute("nPaginas", nPaginas);
				request.setAttribute("pagina", p);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("privado/escribir.jsp").forward(request, response);
		}
		
		
		
		
	}

}
