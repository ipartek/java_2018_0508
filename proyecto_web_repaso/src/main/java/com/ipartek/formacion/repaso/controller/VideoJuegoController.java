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
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.dao.JuegoDAO;
import com.ipartek.formacion.repaso.pojo.Juego;

/**
 * Servlet implementation class VideoJuegoController
 */
@WebServlet("/videojuego")
public class VideoJuegoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(VideoJuegoController.class);
	JuegoDAO juegosDao = null;

	ValidatorFactory factory = null;
	Validator validator = null;

	ArrayList<Juego> juegos = new ArrayList<Juego>();

	private String VISTA_OK = "listado.jsp";
	private String VISTA_FAIL = "index.jsp";
	private String vista = VISTA_FAIL;

	@Override
	public void init(ServletConfig config) throws ServletException {
		juegosDao = JuegoDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();
		super.init(config);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoJuegoController() {

		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			Juego j = new Juego();
			// recoger parametros
			String titulo = request.getParameter("titulo");
			String fechaLanzamiento = request.getParameter("fechaLanzamiento");

			j.setTitulo(titulo);
			j.setFechaLanzamiento(Date.valueOf(fechaLanzamiento));

			// validar

			Set<ConstraintViolation<Juego>> violations = validator.validate(j);
			String[] errores = new String[violations.size()];
			j.setTitulo(titulo);
			// j.setFechaLanzamiento(fechaLanzamiento);
			if (violations.size() > 0) {
				vista = VISTA_FAIL;
				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Juego> violation : violations) {

					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

			} else {
				juegosDao.crear(j);

				vista = VISTA_OK;
				request.setAttribute("juegos", juegosDao.getall());
				request.setAttribute("juego", j);
			}
		} catch (Exception e) {
			request.setAttribute("info", "Lo sentimos tenemos un error no controlado");

			LOG.error(e.getMessage());
		} finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}

}
