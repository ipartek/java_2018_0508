package com.formacion.ipartek.repaso.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Set;

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

import com.formacion.ipartek.repaso.model.JuegoDAO;
import com.formacion.ipartek.repaso.pojo.Alert;
import com.formacion.ipartek.repaso.pojo.Juego;

/**
 * Servlet implementation class VideojuegoController
 */
@WebServlet("/videojuego")
public class VideojuegoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Logger
	private final static Logger LOG = Logger.getLogger(VideojuegoController.class);

	private static final String VIEW_LISTADO = "listado.jsp";
	private static final String VIEW_INDEX = "index.jsp";

	private JuegoDAO daoJuego = null;

	private static String view = "";
	private Alert alert = null;

	private String titulo;
	private Date fecha_lanzamiento;

	ValidatorFactory factory = null;
	Validator validator = null;

	@Override
	public void init() throws ServletException {
		super.init();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		daoJuego = JuegoDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		view = VIEW_LISTADO;
		// Pasar a la siguiente vista
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.trace("Entra en el post de VideojuegoController");
		view = "";
		Juego juego = null;
		ArrayList<Juego> juegos = null;
		try {
			juego = new Juego();
			titulo = request.getParameter("titulo");
			fecha_lanzamiento = Date.valueOf(request.getParameter("fecha_lanzamiento"));

			juego.setTitulo(titulo);
			juego.setFecha_lanzamiento(fecha_lanzamiento);

			Set<ConstraintViolation<Juego>> violations = validator.validate(juego);

			if (violations.isEmpty()) {
				try {
					if (daoJuego.insert(juego)) {
						juegos = (ArrayList<Juego>) daoJuego.getAll();
						alert = new Alert(Alert.ALERT_SUCCESS, "Se ha creado el juego");
						view = VIEW_LISTADO;
					} else {
						alert = new Alert(Alert.ALERT_WARNING, "No se ha podido crear el juego");
						view = VIEW_INDEX;
					}
				} catch (Exception e) {
					alert = new Alert(Alert.ALERT_WARNING, "Juego a crear ya existe. Prueba con otro nombre");
					LOG.warn(e);
				}

				if (juegos.size() < 1) {
					alert = new Alert(Alert.ALERT_PRIMARY, "¡Aún no existen juegos!");
				}

			} else {
				/* Hay fallos, la Validacion no es correcta */
				String texto = "Errores de validacion al crear juego: <br> ";
				for (ConstraintViolation<Juego> violation : violations) {
					LOG.debug("Errores de validacion al crear juego: " + violation.getPropertyPath() + ": "
							+ violation.getMessage());
					texto += violation.getPropertyPath() + ": " + violation.getMessage() + "<br>";

				}
				alert = new Alert(Alert.ALERT_WARNING, texto);
				view = VIEW_INDEX;
			}

			request.setAttribute("juego", juego);
			request.setAttribute("alert", alert);
			request.setAttribute("juegos", juegos);

		} catch (IllegalArgumentException e) {
			LOG.error(e);
			view = VIEW_INDEX;
			alert = new Alert(Alert.ALERT_WARNING, "La fecha introducida no es válida.");
			request.setAttribute("alert", alert);
		} catch (Exception e) {
			LOG.error(e);
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
			view = VIEW_INDEX;
			request.setAttribute("alert", alert);
		} finally {
			// Pasar a la siguiente vista
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
