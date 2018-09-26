package com.ipartek.formacion.libro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libro.model.PaginaArrayListDAO;
import com.ipartek.formacion.libro.pojo.Alert;
import com.ipartek.formacion.libro.pojo.Pagina;

/**
 * Servlet implementation class BuscaController
 */
@WebServlet("/busca")
public class BuscaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String MSG_NO_RESULTADOS = "Lo sentimos. No hay ninguna página que mostrar con su búsqueda.";
	PaginaArrayListDAO dao;
	ArrayList<Pagina> paginas;
	ArrayList<Pagina> pagsEncontradas;
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		dao = PaginaArrayListDAO.getInstance();
	}

	@Override
	public void destroy() {

		super.destroy();
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response) {
		Alert alert = new Alert (MSG_NO_RESULTADOS, Alert.PRIMARY);
		
		try {
			
			String texto = request.getParameter("busqueda");
			
			if (texto != null && !texto.trim().isEmpty()) {
				
				buscarTexto(texto);
				if (pagsEncontradas != null) {
					request.setAttribute("pagsEncontradas", pagsEncontradas);
					request.getRequestDispatcher("resultados.jsp").forward(request, response);
				
				} else {
					request.setAttribute("alert", alert);
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}
			}  else {
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	private void buscarTexto(String texto) {
		
		paginas = (ArrayList<Pagina>) dao.getAll();
		pagsEncontradas = new ArrayList<>();
		
		for (Pagina p: paginas) {
			if (p.getContenido().contains(texto) || p.getAutor().contains(texto)) {
				pagsEncontradas.add(p);
				System.out.println(p.getAutor());
			}
		}
		
		
	}

}
