package com.formacion.ipartek.gestorpersonas.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

import com.formacion.ipartek.gestorpersonas.model.PersonaDAO;
import com.formacion.ipartek.gestorpersonas.pojo.Alert;
import com.formacion.ipartek.gestorpersonas.pojo.Persona;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/personas")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Logger
	private final static Logger LOG = Logger.getLogger(HomeController.class);

	// Vistas por las que se va a navegar
	private static final String VIEW_HOME = "index.jsp";
	private static final String VIEW_FORM_PERSONA = "formulario.jsp";
	private static final String VIEW_BUSQUEDA = "resultadoBusqueda.jsp";
	private static final String VIEW_DETALLE_MIGRACION = "detalleMigracion.jsp";

	// OPCIONES DE LA BUSQUEDA POSIBLES
	private static final String BUSCAR_NOMBRE = "nombreBuscar";
	private static final String BUSCAR_DNI = "dniBuscar";
	private static final String BUSCAR_EMAIL = "emailBuscar";

	// DAO de Persona
	private static PersonaDAO daoPersona = null;

	private String view = "";
	private Alert alert = null;

	// Operandos para las opciones de la app
	static final String OP_LISTAR = "1";
	static final String OP_GUARDAR = "2";
	static final String OP_IR_FORMULARIO = "3";
	static final String OP_BUSCAR = "4";
	static final String OP_MIGRAR = "5";

	// Validador
	ValidatorFactory factory = null;
	Validator validator = null;

	// Parametros
	private String op; // Operacion a realizar
	private String id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private String email;

	private String palabra;
	private String opcionBuscar;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoPersona = PersonaDAO.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoPersona = null;
		factory = null;
		validator = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			alert = null;

			// Recoge los parametros de la request y los guarda en variables
			getParameters(request);

			// Dependiendo del valor del parametro op hace una funcion u otra
			switch (op) {
			case OP_GUARDAR:
				guardar(request); // Crea o modifica una personas en la bbdd
				break;

			case OP_IR_FORMULARIO:
				irFormulario(request); // Cambia a la vista del formulario de gestion de persona
				break;

			case OP_BUSCAR:
				buscar(request); // Cambia a la vista del formulario de gestion de persona
				break;

			case OP_MIGRAR:
				migrarDatos(request); // Cambia a la vista del formulario de gestion de persona
				break;

			default: // Listar
				listar(request); // Cambia a la vista de listado de personas
				break;
			}
		} catch (Exception e) {
			LOG.error(e);
			view = VIEW_HOME;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	/**
	 * Busca dependiendo de la opcion buscar que reciba: por dni, email y
	 * nombre/apellidos
	 * 
	 * @param request
	 */
	private void buscar(HttpServletRequest request) {
		ArrayList<Persona> personasEncontradas = new ArrayList<Persona>();
		Persona personaEncontrada = new Persona();
		try {
			if (palabra != null && !palabra.equals("") && !opcionBuscar.equals("-1")) {

				if (opcionBuscar.equals(BUSCAR_NOMBRE)) {
					personasEncontradas = (ArrayList<Persona>) daoPersona.buscarNombre(palabra.toLowerCase());
				} else if (opcionBuscar.equals(BUSCAR_DNI)) {
					personaEncontrada = daoPersona.buscarDni(palabra);
					personasEncontradas.add(personaEncontrada);
				} else if (opcionBuscar.equals(BUSCAR_EMAIL)) {
					personaEncontrada = daoPersona.buscarEmail(palabra);
					personasEncontradas.add(personaEncontrada);
				}

				view = VIEW_BUSQUEDA;
			} else {
				alert = new Alert(Alert.ALERT_WARNING,
						"Debe introducir una palabra y seleccionar una opción para poder buscar.");
				view = VIEW_HOME;
			}
		} catch (Exception e) {
			LOG.error(e);
			view = VIEW_HOME;
		}

		request.setAttribute("alert", alert);
		request.setAttribute("palabra", palabra);
		request.setAttribute("personasEncontradas", personasEncontradas);
	}

	private void listar(HttpServletRequest request) {
		view = VIEW_HOME;
		try {
			ArrayList<Persona> personas = (ArrayList<Persona>) daoPersona.getAll();
			request.setAttribute("personas", personas);
			request.setAttribute("alert", alert);
		} catch (Exception e) {
			LOG.error(e);
		}
	}

	private void irFormulario(HttpServletRequest request) throws Exception {
		Persona persona = null;
		if (Long.parseLong(id) > 0) {
			persona = daoPersona.getById(id);
		} else {
			persona = new Persona();
		}
		request.setAttribute("persona", persona);
		view = VIEW_FORM_PERSONA;
	}

	private void guardar(HttpServletRequest request) {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Persona persona = null;
		try {

			persona = new Persona();
			persona.setNombre(nombre);
			persona.setApellido1(apellido1);
			persona.setApellido2(apellido2);
			persona.setDni(dni);
			persona.setEmail(email);

			Set<ConstraintViolation<Persona>> violations = validator.validate(persona);
			
			if(!id.equals("")) {
				persona.setId(Long.parseLong(id));
			}

			if (violations.isEmpty()) {
				if (id.equals("")) {
					// Crear persona nueva
					if (daoPersona.insert(persona)) {
						alert = new Alert(Alert.ALERT_SUCCESS, "Persona creada con éxito.");
					} else {
						alert = new Alert(Alert.ALERT_WARNING, "No se ha podido crear la persona.");
					}
				} else {
					// Modificar persona existente
					if (daoPersona.update(persona)) {
						alert = new Alert(Alert.ALERT_SUCCESS, "Persona modificada con éxito.");
					} else {
						alert = new Alert(Alert.ALERT_WARNING, "No se ha podido modificar la persona.");
					}
				}
				personas = (ArrayList<Persona>) daoPersona.getAll();
			} else {
				/* Hay fallos, la Validacion no es correcta */
				String texto = "Errores de validacion al crear o modificar persona: <br> ";
				for (ConstraintViolation<Persona> violation : violations) {
					LOG.debug("Errores de validacion al crear o modificar persona: " + violation.getPropertyPath()
							+ ": " + violation.getMessage());
					texto += violation.getPropertyPath() + ": " + violation.getMessage() + "<br>";

				}
				alert = new Alert(Alert.ALERT_WARNING, texto);
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		request.setAttribute("persona", persona);
		request.setAttribute("personas", personas);
		view = VIEW_FORM_PERSONA;
	}

	private void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		apellido1 = request.getParameter("apellido1");
		apellido2 = request.getParameter("apellido2");
		dni = request.getParameter("dni");
		email = request.getParameter("email");

		palabra = request.getParameter("palabra");
		opcionBuscar = request.getParameter("opcionBuscar");
	}

	/**
	 * Lee del fichero personas.txt, crea objetos persona por cada linea y los
	 * inserta en la BBDD
	 * 
	 * @param request
	 * @throws Exception
	 */
	private void migrarDatos(HttpServletRequest request) throws Exception {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Persona p = null;
		int contadorLineas = 0;
		int contadorCorrectos = 0;
		int contadorErrores = 0;

		LOG.debug("Preparando para leer fichero");

//		File f = new File("C:/ficheros/personas10registros.txt");
		File f = new File("C:/ficheros/personas.txt");

		LOG.debug("Leer fichero: " + f.getAbsolutePath());
		
		try {

			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);
			try {
				String linea;
				while ((linea = bf.readLine()) != null) {
					p = new Persona();
					String[] tokens = linea.split(",");
					//Si la linea tiene el numero esperado de tokens por linea entra
					if (tokens.length == 7) {
						for (int i = 0; i < tokens.length; i++) {
							if (i == 0) {
								p.setNombre(tokens[i]);
							} else if (i == 1) {
								p.setApellido1(tokens[i]);
							} else if (i == 2) {
								p.setApellido2(tokens[i]);
							} else if (i == 4) {
								p.setEmail(tokens[i]);
							} else if (i == 5) {
								if(tokens[i].length() < 9) {
									contadorErrores++;
								}else {
									p.setDni(tokens[i]);
								}
							}
						}
						if(!p.getDni().equals("")) {
							personas.add(p);
							contadorCorrectos++;
						}
						
					}else {
						contadorErrores++;
					}
					contadorLineas++;
				}

				// Llamada al DAO para insertar los registros
				daoPersona.insertMultiple(personas);
//				request.setAttribute("personas", daoPersona.getAll());
				request.setAttribute("leidos", contadorLineas);
				request.setAttribute("correctos", contadorCorrectos);
				request.setAttribute("errores", contadorErrores);

			} finally {
				bf.close();
				fr.close();
			}
		} catch (IOException e) {
			LOG.error("Caught exception while processing file: " + e.getMessage());
		} catch (Exception e) {
			LOG.error(e);
		}

		LOG.debug("Terminada lectura fichero");

		view = VIEW_DETALLE_MIGRACION;
	}

}
