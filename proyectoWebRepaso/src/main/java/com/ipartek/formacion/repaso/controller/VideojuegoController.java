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

import com.ipartek.formacion.repaso.DAO.JuegoDAO;
import com.ipartek.formacion.repaso.pojo.Juego;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

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
		Juego juego = new Juego();

		try {

			// recoger parametros
			String titulo = request.getParameter("titulo");
			String fechaLanzamiento = request.getParameter("fecha_lanzamiento");

			juego.setTitulo(titulo);
			juego.setFecha_lanzamiento(Date.valueOf(fechaLanzamiento));

			// validar

			Set<ConstraintViolation<Juego>> violations = validator.validate(juego);

			if (violations.isEmpty()) {

				if (dao.insert(juego)) {
					request.setAttribute("juego", juego);
					view = VIEW_LIST;
				} else {
					request.setAttribute("alertaJuego", "No se ha podido crear el registro");
				}

			} else {
				request.setAttribute("alertaJuego", violations);
			}

			request.setAttribute("juegos", dao.getAll());

		} catch (MySQLIntegrityConstraintViolationException e) {

			LOG.error(e);
			request.setAttribute("alertaJuego", "el registro con titulo <b>"+juego.getTitulo()+"</b> ya existe en la base de datos");

		} catch (IllegalArgumentException e) {

			LOG.error(e);
			request.setAttribute("alertaJuego", "Valores no validos, titulo y fecha debe estar rellenado para poder crear");

		} catch (Exception e) {

			LOG.error(e);
			request.setAttribute("alertaJuego", "Lo sentimos tenemos un error no controlado");

		} finally {
			request.setAttribute("juego", juego);
			request.getRequestDispatcher(view).forward(request, response);
		}

		LOG.trace("salgo");
	}

}