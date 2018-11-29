package com.ipartek.formacion.personas.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.personas.service.PersonaService;
import com.ipartek.personas.personas.pojo.Alert;
import com.ipartek.personas.personas.pojo.Persona;
import com.ipartek.personas.personas.pojo.ResultadoVolcadoDeDatos;

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

			switch (op) {
			case OP_CARGAR_DATOS:

				cargarDatos(request);
				listar( request );
				break;

			case OP_IR_FORMULARIO:

				irFormulario( request );
				break;
				
			default:

				listar(request);
				break;
			}

		} catch (Exception e) {

			LOG.error(e);

		} finally {

			request.setAttribute("alert", alert);
			request.getRequestDispatcher( view ).forward(request, response);

		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			recogerFormulario(request);

			if (id.equals("-1")) { // Nueva Persona

				if (servicio.crear(persona)) {

					alert = new Alert(Alert.SUCCESS, "Persona insertada.");

				}

			} else {

				persona.setId(Long.parseLong(id));

				if (servicio.modificar(persona)) {

					alert = new Alert(Alert.SUCCESS, "Persona modificada.");

				}
			}

			listar(request);

		} catch (Exception e) {

			LOG.error(e);

		} finally {

			request.getSession().setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);

		}
	}

	private void cargarDatos(HttpServletRequest request) throws Exception {
		
		ResultadoVolcadoDeDatos resultado = null;
		
		if (!iniciado) {
			
			File archivo = new File(getClass().getClassLoader().getResource( FILE_NAME ).getFile());
			
			resultado = servicio.cargarPersonasDesdeFichero( archivo );

			iniciado = true;
			
			LOG.debug("Datos cargados.");

		} else {
			
			alert = new Alert(Alert.PRIMARY, "Los datos ya han sido introducidos en la Base de Datos.");
		}
		
		request.getSession().setAttribute("resultado", resultado);

	}

	private void irFormulario(HttpServletRequest request) throws NumberFormatException, Exception {

		if (id.equalsIgnoreCase("-1")) { // Crear Persona

			request.setAttribute("persona", new Persona());

		} else { // Modificar Persona

			request.setAttribute("persona", servicio.obtenerId(Long.parseLong(id)));
		}

		view = FORM_VIEW;

	}

	private void listar(HttpServletRequest request) throws Exception {

		request.setAttribute("personas", servicio.listar());
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
