package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
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
	private final static Logger LOG = Logger.getLogger(VideojuegoController.class);
	private static JuegoDAO daojuego;
	private String view;
	private String msg;
	private String titulo;
	private String fechaLanzamiento;
	ValidatorFactory factory = null;
	Validator validator = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		daojuego = JuegoDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.trace("Entro por GET");
		view="listado.jsp";
		request.setAttribute("juegos", daojuego.getAll());
		request.getRequestDispatcher(view).forward(request, response);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.trace("Entro por POST");
		view = "index.jsp";

		try {
			// recogemos los parametros
			titulo = request.getParameter("titulo");
			fechaLanzamiento = request.getParameter("fechaLanzamiento");

			// Creacion del juego parseando la fecha

			Juego juego = new Juego(titulo, Date.valueOf(fechaLanzamiento));

			// Validaciones de javax
			Set<ConstraintViolation<Juego>> violations = validator.validate(juego);
			if (violations.isEmpty()) {

				if (daojuego.crear(juego)) {
					request.setAttribute("juego", juego);
					view = "listado.jsp";
					// Mensaje y jsp a la que iremos
					msg = "Juego " + juego.getTitulo() + " creado correctamente";
				} else {
					
					msg = "El juego no se ha podido crear";
				}

				request.setAttribute("juegos", daojuego.getAll());

			} else {
				for (ConstraintViolation<Juego> constraint : violations) {
					msg = constraint.getPropertyPath() + " : " + constraint.getMessage();
				}
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			LOG.error(e);
			msg = "El titulo de este videojuego ya existe";
		} catch (IllegalArgumentException e) {

			msg = "Lo sentimos pero algún campo no es correcto";

			LOG.error(e);

		} catch (Exception e) {

			msg = "Lo sentimos, hemos tenido un error.";

			LOG.error(e);

		} finally {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
