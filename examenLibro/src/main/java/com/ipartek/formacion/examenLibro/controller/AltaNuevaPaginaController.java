package com.ipartek.formacion.examenLibro.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examenLibro.model.LibroArrayListDAO;
import com.ipartek.formacion.examenLibro.model.Pagina;
import com.ipartek.formacion.examenLibro.model.Usuario;

/**
 * Servlet implementation class AltaNuevaPaginaController
 */
@WebServlet("/alta")
public class AltaNuevaPaginaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static LibroArrayListDAO dao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = LibroArrayListDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			Usuario u = (Usuario) request.getSession().getAttribute("usuario");
			String texto = request.getParameter("texto");
			if (texto.length() > 25) {
				Pagina p = new Pagina(texto, u);

				dao.insert(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			response.sendRedirect("home");
		}

	}

}
