package com.ipartek.formacion.game.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.ipartek.formacion.game.model.GameDAO;
import com.ipartek.formacion.game.pojo.Alert;
import com.ipartek.formacion.game.pojo.Juego;

/**
 * Servlet implementation class SumaController
 */
@WebServlet("/videojuego")
public class VideojuegoController extends HttpServlet {

	private static Alert alert;

	private static GameDAO daoJuegos;
	private static ValidatorFactory factory;

	private static final Logger LOG = Logger.getLogger(VideojuegoController.class);

	private static final long serialVersionUID = 1L;

	private static Validator validator;

	private static final String VIEW = "videojuego.jsp";

	private ArrayList<Juego> coleccion;
	private String fLanzamiento;

	private Juego juego;
	private String titulo;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			titulo = request.getParameter("titulo");
			fLanzamiento = request.getParameter("fLanzamiento");

			if (fLanzamiento != null) {

				Date fecha = parseDate(fLanzamiento);
				juego = new Juego(titulo, fecha);
			}

			if (juego != null) {

				Set<ConstraintViolation<Juego>> violations = validator.validate(juego);

				if (violations.size() == 0) {

					if (daoJuegos.insert(juego)) {

						request.getSession().setAttribute("juego", juego);

					}

					// daoJuegos.insertMultiple(coleccion);

				} else {

					alert = new Alert(Alert.WARNING, violations.toString());
					request.getSession().setAttribute("creado", true);
				}
			}

			coleccion = (ArrayList<Juego>) daoJuegos.getAll();
			System.out.println(coleccion.size());

		} catch (Exception e) {

			alert = new Alert(Alert.WARNING, "Error inesperado, lamentamos las molestias.");
			LOG.error(e);

		} finally {

			request.getSession().setAttribute("alert", alert);
			request.getSession().setAttribute("coleccion", coleccion);
			response.sendRedirect(VIEW);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		coleccion = new ArrayList<Juego>();

		daoJuegos = GameDAO.getInstance();
	}

	private Date parseDate(String fecha) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		return new Date(formatter.parse(fecha).getTime());

	}

}
