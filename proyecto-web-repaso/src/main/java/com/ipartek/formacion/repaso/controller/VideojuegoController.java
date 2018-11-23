package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.pojo.Juego;

/**
 * Servlet implementation class VideojuegoController
 */
@WebServlet("/videojuego")
public class VideojuegoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(VideojuegoController.class);

	private static final String VIEW_INDEX = "index.jsp";
	private static final String VIEW_LIST = "listado.jsp";

	private ValidatorFactory factory;
	private Validator validator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.trace("entro");
		String view = VIEW_INDEX;

		try {

			// recoger parametros
			String titulo = request.getParameter("titulo");
			String fechaLanzamiento = request.getParameter("fechaLanzamiento");

			Juego juego = new Juego();
			juego.setTitulo(titulo);
			juego.setFechaLanzamiento(Date.valueOf(fechaLanzamiento));

			// validar
			Set<ConstraintViolation<Juego>> violations = validator.validate(juego);
			if (violations.isEmpty()) {
				// TODO guardar en bbdd
				request.setAttribute("juego", juego);
				view = VIEW_LIST;
			} else {
				request.setAttribute("info", "Introduce los campos correctamente por favor.");
			}

			request.setAttribute("juegos", juegosMock());

		} catch (Exception e) {

			LOG.error(e);
			request.setAttribute("info", "Lo sentimos tenemos un error no controlado");

		} finally {
			request.getRequestDispatcher(view).forward(request, response);
		}

		LOG.trace("salgo");
	}

	private ArrayList<Juego> juegosMock() {

		ArrayList<Juego> juegos = new ArrayList<Juego>();
		juegos.add(new Juego("GTA"));
		juegos.add(new Juego("Tomcat"));
		juegos.add(new Juego("Tony Hawks"));
		juegos.add(new Juego("Moneky Island"));
		return juegos;
	}

}
