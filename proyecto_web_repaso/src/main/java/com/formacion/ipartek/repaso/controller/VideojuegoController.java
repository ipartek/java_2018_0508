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
	
	private static String view = "";
	private Alert alert = null;
	
	private String titulo;
	private Date fecha_lanzamiento;
	
	ValidatorFactory factory = null;
	Validator validator = null;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		view = VIEW_LISTADO;
		//Pasar a la siguiente vista
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Entra en el post de VideojuegoController");
		view = "";
		Juego juego = null;
		ArrayList<Juego> juegos = new ArrayList<Juego>();
		try {
			juego = new Juego();
			titulo = request.getParameter("titulo");
			fecha_lanzamiento = Date.valueOf(request.getParameter("fecha_lanzamiento"));
			
			juego.setTitulo(titulo);
			juego.setFecha_lanzamiento(fecha_lanzamiento);
			
			Set<ConstraintViolation<Juego>> violations = validator.validate(juego);
			
			if (violations.isEmpty()) {
				juegos.add(juego);
				alert = new Alert(Alert.ALERT_SUCCESS, "Se ha creado el juego");
				view = VIEW_LISTADO;
			} else {
				/* Hay fallos, la Validacion no es correcta */
				for (ConstraintViolation<Juego> violation : violations) {
					LOG.debug("Errores de validacion al crear usuario: " + violation.getPropertyPath() + ": "
							+ violation.getMessage());
					
					alert = new Alert(Alert.ALERT_WARNING, "Errores de validacion al crear juego: " + violation.getPropertyPath() + ": "
							+ violation.getMessage());
					
					request.setAttribute("alert", alert);
				}
				view = VIEW_INDEX;
			}
			
			if(juegos.size() < 1) {
				alert = new Alert(Alert.ALERT_PRIMARY, "¡Aún no existen juegos!");
			}
			
			request.setAttribute("juego", juego);
			request.setAttribute("alert", alert);
			request.setAttribute("juegos", juegos);
			
		}catch(IllegalArgumentException e) {
			LOG.error(e);
			view = VIEW_INDEX;
			alert = new Alert(Alert.ALERT_WARNING, "La fecha introducida no es válida.");
			request.setAttribute("alert", alert);
		}catch(Exception e) {
			LOG.error(e);
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
			view = VIEW_INDEX;
			request.setAttribute("alert", alert);
		}finally {
			//Pasar a la siguiente vista
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
