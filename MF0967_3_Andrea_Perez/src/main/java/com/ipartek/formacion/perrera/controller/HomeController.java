package com.ipartek.formacion.perrera.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.perrera.model.Alert;
import com.ipartek.formacion.perrera.model.Perro;
import com.ipartek.formacion.perrera.model.PerroArrayListDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ALTA_PERRO = "alta";
	private static final String VIEW_HOME = "home.jsp";
	private static final String VIEW_ALTA = "/privado/alta_perro.jsp";

	private ArrayList<Perro> perros;
	private static PerroArrayListDAO daoPerro;
	ArrayList perrosEncontrados=null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		daoPerro = PerroArrayListDAO.getInstance();

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		daoPerro = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		String view = VIEW_HOME;

		try {

			if (ALTA_PERRO.equals(op)) {
				view = VIEW_ALTA;
			}

			// Recoger listado de perros
			perros = (ArrayList<Perro>) daoPerro.getAll();

			request.setAttribute("perros", perros);

			// Buscar perro
			String textoBuscar = request.getParameter("buscarPalabra");

			if (textoBuscar != null && !textoBuscar.trim().isEmpty()) {

				buscarTexto(textoBuscar);

				if (perrosEncontrados != null) {

				
					request.setAttribute("pagsEncontradas", perrosEncontrados);

				} else {
					Alert alert = new Alert(Alert.ALERT_WARNING,"Ningun resultado para la busqueda " + "<strong>" + textoBuscar + "</strong>");
					request.setAttribute("buscarPalabra", textoBuscar);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher(VIEW_HOME).forward(request, response);
		} finally {

			request.getRequestDispatcher(view).forward(request, response);
		}

	}
	
	private void buscarTexto(String texto) {
		perros = (ArrayList<Perro>) daoPerro.getAll();
		perrosEncontrados = new ArrayList<>();
		for (Perro p : perros) {
			if (p.getNombre().contains(texto) || p.getChip().getNumero().contains(texto)) {
				
				perrosEncontrados.add(p);

			}
		}
	}

}
