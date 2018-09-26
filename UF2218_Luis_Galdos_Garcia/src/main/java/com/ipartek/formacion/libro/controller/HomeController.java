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
import com.ipartek.formacion.libro.pojo.Pagina;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PaginaArrayListDAO dao;
	private ArrayList<Pagina> paginas;
	private Pagina pagActual;

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
	 * /**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			cargarPaginas(); // Obtenemos las páginas del DAO
			request.setAttribute("numPaginas", paginas.size());

			if (pagActual == null) { // Página por defecto

				pagActual = paginas.get(0);
				

			} else {

				String op = request.getParameter("op");
				
				if (op != null) {
					switch (op) {
					case "prev":
						avanzarPagina(false);
						break;
					case "next":
						avanzarPagina(true);
						break;
					default:
						break;
					}
				} else {
					
					String numPagina = request.getParameter("numPagina");
					
					if (numPagina != null && !numPagina.isEmpty()) {
						
						int ind = Integer.valueOf(numPagina);
						ind--;	// Restamos uno para que corresponda a su posición en la lista
						
						if (ind >= 0 && ind < paginas.size()) {
							pagActual = paginas.get(ind);
						}
						
					}
					
				}

			}

		} catch (Exception e) { // Capturar cualquier excepción

			e.printStackTrace();

		} finally {
			request.setAttribute("pagActual", pagActual);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

	}

	/**
	 * Procedimiento privado que se encarga de avanzar o retroceder la página cuando
	 * se ha detectado una operación de avanzar o retroceder.
	 * 
	 * @param avanza <b>true</b> <=> se ha pulsado la opción avanzar página en la
	 *               vista.
	 */
	private void avanzarPagina(boolean avanza) {

		int ind = paginas.indexOf(pagActual);

		if (avanza) { // Avanzar página
			if (ind == paginas.size() - 1) { // Estamos en la última página
				ind = 0;
			} else {
				ind++;
			}
		} else { // Retroceder página
			if (ind == 0) { // Estamos en la primera página
				ind = paginas.size() - 1;
			} else {
				ind--;
			}
		}

		pagActual = paginas.get(ind);
	}

	/**
	 * Procedimiento propio que se encarga de obtener las páginas del DAO.
	 */
	private void cargarPaginas() {

		paginas = new ArrayList<Pagina>();
		paginas = (ArrayList<Pagina>) dao.getAll();

	}
}
