package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import java.sql.Date;
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

import com.ipartek.formacion.repaso.dao.JuegoDAO;
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

	private static JuegoDAO dao;

	private ValidatorFactory factory;
	private Validator validator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		dao = JuegoDAO.getInstance();
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
				try {
					if (dao.crear(juego)) {
						request.setAttribute("juego", juego);
						view = VIEW_LIST;
					} else {
						request.setAttribute("info", "Lo sentimos no se ha podido crear.");
					}
				} catch (Exception e) {
					request.setAttribute("info", "El videojuego ya existe, por favor elige otro titulo.");
				}
			} else {
				request.setAttribute("info", "Introduce los campos correctamente por favor.");
			}

			request.setAttribute("juegos", dao.getAll());

		} catch (Exception e) {

			LOG.error(e);
			request.setAttribute("info", "Lo sentimos tenemos un error no controlado");

		} finally {
			request.getRequestDispatcher(view).forward(request, response);
		}

		LOG.trace("salgo");
	}

}
