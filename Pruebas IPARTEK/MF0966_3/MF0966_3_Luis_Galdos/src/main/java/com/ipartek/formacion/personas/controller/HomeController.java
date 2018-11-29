package com.ipartek.formacion.personas.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;

import org.apache.log4j.Logger;

import com.ipartek.formacion.personas.pojo.Alert;
import com.ipartek.formacion.personas.pojo.Persona;
import com.ipartek.formacion.personas.pojo.ResultadoUpdate;
import com.ipartek.formacion.personas.pojo.ResultadoVolcadoDeDatos;
import com.ipartek.formacion.personas.service.PersonaService;

/**
 * Servlet implementation class SumaController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	// CONSTANTES
	private static final Logger LOG = Logger.getLogger(HomeController.class);

	private static final String HOME_VIEW = "index.jsp";
	public static final String FORM_VIEW = "formulario.jsp";

	public static final String OP_CARGAR_DATOS = "1";
	public static final String OP_IR_FORMULARIO = "2";

	private static final String FILE_NAME = "personas.txt"; // Los datos están separado por comas

	private static final long serialVersionUID = 1L;

	// VARIABLES GOBLALES
	private static PersonaService servicio;
	private static String view;
	private static Alert alert;

	private static Persona persona;

	private static boolean iniciado; // Para cargar datos de Fichero a BBDD una unica vez

	private static String op;
	private static String id;

	@Override
	public void destroy() {

		super.destroy();
		servicio = null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		servicio = PersonaService.getInstance(); // Conexion a la BBDD
		iniciado = false;
		view = HOME_VIEW;

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			listar(request);
			recogerParametros(request);

			if (op != null) {

				switch (op) {
				case OP_CARGAR_DATOS:

					cargarDatos(request);
					listar(request);
					break;

				case OP_IR_FORMULARIO:

					irFormulario(request);
					break;

				default:

					listar(request);
					break;
				}
			}

		} catch (FileNotFoundException e) {

			LOG.error(e);
			alert = new Alert(Alert.DANGER, "No se ha podido encontrar el fichero.");

		} catch (Exception e) {

			e.printStackTrace();
			LOG.error(e);

		} finally {

			request.getSession().setAttribute("alert", alert);
			response.sendRedirect(view);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResultadoUpdate resultadoUpdate;

		try {

			recogerFormulario(request);

			if (id.equals("-1")) { // Nueva Persona

				resultadoUpdate = servicio.crear(persona);

				if (resultadoUpdate.isResult()) {

					alert = new Alert(Alert.SUCCESS, "Persona insertada.");

				} else {

					crearAlertViolations(request, resultadoUpdate.getViolations());

				}

			} else { // Modificar Persona

				persona.setId(Long.parseLong(id));

				resultadoUpdate = servicio.modificar(persona);

				if (resultadoUpdate.isResult()) {

					alert = new Alert(Alert.SUCCESS, "Persona modificada.");

				} else {

					crearAlertViolations(request, resultadoUpdate.getViolations());

				}
			}

			if (resultadoUpdate.isResult()) {

				listar(request);

			} else {

				irFormulario(request);

			}

		} catch (SQLIntegrityConstraintViolationException e) {

			LOG.error(e);

		} catch (Exception e) {

			LOG.error(e);

		} finally {

			request.getSession().setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);

		}
	}

	private void crearAlertViolations(HttpServletRequest request, Set<ConstraintViolation<Persona>> violations)
			throws NumberFormatException, Exception {

		StringBuilder sb = new StringBuilder();

		sb.append("Se encontraron los siguientes errores: <br>");
		sb.append("<ul>");

		for (ConstraintViolation<Persona> v : violations) {

			sb.append("<li>" + v.getMessage() + "</li>");
		}

		sb.append("</ul>");
		alert = new Alert(Alert.WARNING, sb.toString());

		request.getSession().setAttribute("alert", alert);
		irFormulario(request);

	}

	private void cargarDatos(HttpServletRequest request) throws Exception {

		ResultadoVolcadoDeDatos resultado = null;

		if ( !iniciado ) {

			File archivo = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());

			resultado = servicio.cargarPersonasDesdeFichero(archivo);

			iniciado = true;

			LOG.debug("Datos volcados.");
			alert = new Alert(Alert.SUCCESS, "Datos correctamente cargados.");

		} else {

			alert = new Alert( Alert.PRIMARY, "Los datos ya han sido volcados en la Base de Datos." );
		}

		request.getSession().setAttribute("resultado", resultado);

	}

	private void irFormulario(HttpServletRequest request) throws NumberFormatException, Exception {

		if (id.equalsIgnoreCase("-1")) { // Crear Persona

			persona = new Persona();

		} else { // Modificar Persona

			persona = servicio.obtenerId(Long.parseLong(id));
		}

		request.getSession().setAttribute("persona", persona);
		view = FORM_VIEW;

	}

	private void listar(HttpServletRequest request) throws Exception {

		request.getSession().setAttribute("personas", servicio.listar());
		view = HOME_VIEW;

	}

	private void recogerFormulario(HttpServletRequest request) {

		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String dni = request.getParameter("dni");
		String email = request.getParameter("mail");
		String rol = request.getParameter("rol");

		persona = new Persona(nombre, apellido1, apellido2, dni, email, rol);

	}

	private void recogerParametros(HttpServletRequest request) {

		op = request.getParameter("op");
		id = request.getParameter("id");

	}
}
