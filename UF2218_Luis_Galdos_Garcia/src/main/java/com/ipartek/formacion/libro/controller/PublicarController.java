package com.ipartek.formacion.libro.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libro.model.PaginaArrayListDAO;
import com.ipartek.formacion.libro.pojo.Alert;
import com.ipartek.formacion.libro.pojo.Pagina;
import com.ipartek.formacion.libro.pojo.Usuario;

/**
 * Servlet implementation class PublicarController
 */
@WebServlet("/publicar")
public class PublicarController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final int MIN_LONG_CONTENIDO = 25; // 25 palabras

	private static final String MSG_INSERTADO_CORRECTO = "La página ha sido correctamente publicada.";

	Pagina nuevaPag;
	private PaginaArrayListDAO dao;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcces(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcces(request, response);
	}

	private void doProcces(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Alert alert = new Alert();

		try {

			crearPagina(request);
			
			if (nuevaPag != null) {
				dao.insert(nuevaPag);
				alert.setTexto(MSG_INSERTADO_CORRECTO);
				alert.setTipo(Alert.SUCCESS);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			
			request.getSession().setAttribute("alert", alert);
			request.setAttribute("numPaginas", dao.getAll().size());
			request.getRequestDispatcher("backoffice/escribir-pag.jsp").forward(request, response);
		}

	}

	private void crearPagina(HttpServletRequest request) {

		// Recoger Parámetros
		String titulo = request.getParameter("titulo");
		String contenido = request.getParameter("contenido");

		// El usuario lo cogeremos de la sesión
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");

		if (user != null) {
			if (comprobarNumPalabras(contenido)) {
				nuevaPag = new Pagina(dao.getAll().size(), titulo, contenido, user.getNombre());
			}
		}

	}

	/**
	 * Procedimiento privado que comprueba si el contenido tiene la longitud
	 * correcta.
	 * 
	 * @param contenido, String
	 * @return true <=> contenido > MIN_LONG_CONTENIDO palabras
	 */
	private boolean comprobarNumPalabras(String contenido) {

		StringTokenizer tokens = new StringTokenizer(contenido, " ");
		return tokens.countTokens() >= MIN_LONG_CONTENIDO;
	}

}
