package com.andrea.perez.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrea.perez.model.PaginaDAO;
import com.andrea.perez.pojo.Alert;
import com.andrea.perez.pojo.Pagina;

@WebServlet("/inicio")
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String OP_AVANZA = "avanza";
	private static final String OP_RETROCEDE = "retrocede";

	private ArrayList<Pagina> paginas;
	
	ArrayList<Pagina> pagsEncontradas = null;
	private static PaginaDAO dao;
	private Pagina p = null;	
	private Alert alert = null;

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		dao = PaginaDAO.getInstance();
	}

	@Override
	public void destroy() {

		super.destroy();
		dao = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProccess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProccess(request, response);

	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			paginas = (ArrayList<Pagina>) dao.getAll();
			

			request.setAttribute("numPaginas", paginas.size());

			if (p == null) { // cargamos primera pag por defecto

				p = paginas.get(0);
			}
			 

			// Paginacion avanzar o retroceder
			if (request.getParameter("op") != null) {
				String op = (String) request.getParameter("op");
				paginacion(op);

			}

			// Buscar pagina
			if (request.getParameter("buscarPag") != null) {
				int nPag = Integer.parseInt(request.getParameter("buscarPag"));
				if (nPag > paginas.size()) {
					alert = new Alert(Alert.ALERT_WARNING, "Estas intentando ir a una pagina que aun no sea escrito");
					request.setAttribute("buscarPag", nPag);
				} else if (nPag <= 0) {
					alert = new Alert(Alert.ALERT_WARNING, "El libro empieza desde la primera pagina...");
				} else {
					p = paginas.get(nPag - 1);

				}

			}

			// Buscar texto
			String textoBuscar = request.getParameter("buscarPalabra");

			if (textoBuscar != null && !textoBuscar.trim().isEmpty()) {

				buscarTexto(textoBuscar);

				if (pagsEncontradas != null) {
					
					request.setAttribute("pagsEncontradas", pagsEncontradas);

				} else {
					alert = new Alert(Alert.ALERT_WARNING,
							"Ningun resultado para la busqueda " + "<strong>" + textoBuscar + "</strong>");
					request.setAttribute("buscarPalabra", textoBuscar);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("alert", alert);
			request.setAttribute("pagActual", p);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			alert = null;
		}

	}

	/**
	 * Metodo para navegar por las paginas.
	 * 
	 * @param String op ; parametro que recogemos del enlace de los botones de
	 *               navegacion pagina. Cuando se quiere avanzar mas de la ultima
	 *               pagina, pasa a la primera y viceversa.
	 * 
	 */
	private void paginacion(String op) {
		int temp = 0;

		if (OP_AVANZA.equals(op)) {

			temp = p.getNumPag() + 1;

			if (temp > paginas.size()) {
				p = paginas.get(0);
			} else {
				p = paginas.get(temp - 1);
			}

		} else if (OP_RETROCEDE.equals(op)) {
			temp = p.getNumPag() - 1;

			if (temp <= 0) {
				p = paginas.get(paginas.size() - 1);
			} else {
				p = paginas.get(temp - 1);
			}

		}
	}

	private void buscarTexto(String texto) {
		paginas = (ArrayList<Pagina>) dao.getAll();
		pagsEncontradas = new ArrayList<>();
		for (Pagina p : paginas) {
			if (p.getTexto().contains(texto) || p.getAutor().contains(texto)) {
				
				pagsEncontradas.add(p);

			}
		}
	}
}
