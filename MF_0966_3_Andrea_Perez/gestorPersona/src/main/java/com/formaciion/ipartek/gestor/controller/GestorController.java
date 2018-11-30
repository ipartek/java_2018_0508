package com.formaciion.ipartek.gestor.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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

import com.formaciion.ipartek.gestor.DAO.PersonaDAO;
import com.formaciion.ipartek.gestor.pojo.Alert;
import com.formaciion.ipartek.gestor.pojo.Persona;

/**
 * Servlet implementation class GestorController
 */
@WebServlet("/home")
public class GestorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(GestorController.class);

	static final String OP_LISTAR = "1";
	private static final String OP_GUARDAR = "2"; // Insert o update en funcion del id (-1 o >0)
	private static final String OP_BUSCAR = "3";
	private static final String OP_IR_FORMULARIO = "4";	
	private static final String OP_CARGAR_REGISTRO = "5";
	private static final String OP_IR_MIGRAR = "6";
	

	private static final String VIEW_FORM_PERSONA = "test.jsp";
	private static final String VIEW_INDEX_PERSONA = "listado.jsp";
	private static final String VIEW_RESUMEN_MIGRACION = "resumenMigracion.jsp";

	private static PersonaDAO daoPersona;

	// Validador
	ValidatorFactory factory = null;
	Validator validator = null;

	private String view = "";
	private Alert alert = null;

	// Parametros
	private String op; // Operacion a realizar
	private String id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email;
	private String dni;
	private String cadena;
	
	ArrayList<Persona> personas=null;
	
	int contOK = 0;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		alert = null;

		try {

			// Recoge los parametros de la request y los guarda en variables
			getParameters(request);

			// Dependiendo del valor del parametro op hace una funcion u otra
			switch (op) {

			case OP_GUARDAR:
				guardar(request); // Crea o modifica un usuario en la bbdd
				break;

			case OP_IR_FORMULARIO:
				irFormulario(request); // Cambia a la vista del formulario de gestion de persona
				break;
			case OP_BUSCAR:
				buscar(request); // Cambia a la vista de listado de persona
				break;
			case OP_CARGAR_REGISTRO:
				migrarDatos(request); // Cambia a la vista del formulario de gestion de persona
				break;
			case OP_IR_MIGRAR:
				view=VIEW_RESUMEN_MIGRACION;
				break;
			
			default: // Listar
				listar(request); // Cambia a la vista de listado de personas
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_INDEX_PERSONA;
			LOG.error(e +"Ha ocurrido un error no controlado.");
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		apellido1 = request.getParameter("apellido1");
		apellido2 = request.getParameter("apellido2");
		email = request.getParameter("email");
		dni = request.getParameter("dni");
		cadena = request.getParameter("cadena");
	}

	public void listar(HttpServletRequest request) {
		view = VIEW_INDEX_PERSONA;
		try {
			personas = (ArrayList<Persona>) daoPersona.listar();
			request.setAttribute("personas", personas);
		} catch (Exception e) {
			LOG.error(e);
		}
	}

	public void guardar(HttpServletRequest request) throws Exception {

		view = VIEW_FORM_PERSONA;
		personas = new ArrayList<Persona>();
		Persona p = null;

		try {
			p = new Persona();

			if (id != null && id.equals("")) {

				// Crear Persona nuevo
				p.setNombre(nombre);
				p.setApellido1(apellido1);
				p.setApellido2(apellido2);
				p.setEmail(email);
				p.setDni(dni);

				Set<ConstraintViolation<Persona>> violations = validator.validate(p);

				if (!id.equals("")) {
					p.setId(Long.parseLong(id));
				}

				if (violations.isEmpty()) {
					if (id.equals("")) {
						// Crear persona nueva
						if (daoPersona.insert(p)) {
							alert = new Alert(Alert.ALERT_SUCCESS, "Persona creada con éxito.");
						} else {
							alert = new Alert(Alert.ALERT_WARNING, "No se ha podido crear la persona.");
						}
					} else {
						// Modificar persona existente
						if (daoPersona.modificar(p)) {
							alert = new Alert(Alert.ALERT_SUCCESS, "Persona modificada con éxito.");
						} else {
							alert = new Alert(Alert.ALERT_WARNING, "No se ha podido modificar la persona.");
						}
					}
					personas = (ArrayList<Persona>) daoPersona.listar();
				} else {
					/* Hay fallos, la Validacion no es correcta */
					String error = "Errores de validacion al crear o modificar persona: <br> ";
					for (ConstraintViolation<Persona> violation : violations) {
						LOG.debug("Errores de validacion al crear o modificar persona: " + violation.getPropertyPath()
								+ ": " + violation.getMessage());
						error += violation.getPropertyPath() + ": " + violation.getMessage() + "<br>";

					}
					alert = new Alert(Alert.ALERT_WARNING, error);
				}

			} else {				

				if (daoPersona.modificar(p)) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Persona modificada con éxito.");
					LOG.debug("Persona <b> " + p.getNombre() + " </b> modificada con éxito.");
				} else {
					alert = new Alert(Alert.ALERT_WARNING, "No se ha podido modificar la persona.");
				}
				personas = (ArrayList<Persona>) daoPersona.listar();
			}

		} catch (SQLIntegrityConstraintViolationException slqIntegrity) {
			slqIntegrity.printStackTrace();

			LOG.debug("El registro <b> " + p.getNombre() + " </b> no se puede registrar porque ya existe!!");
		} catch (Exception e) {

			LOG.error(e);
		}
		request.setAttribute("persona", p);
		request.setAttribute("personas", personas);
		view = VIEW_FORM_PERSONA;
	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		Persona persona = null;
		if (Integer.parseInt(id) > 0) {

			persona = daoPersona.buscarPorId(id);
		} else {
			persona = new Persona();
		}
		request.setAttribute("persona", persona);
		view = VIEW_FORM_PERSONA;
	}

	private void buscar(HttpServletRequest request) {		
		
		try {
			
			if (cadena != null && !cadena.equals("")){
				
				personas = daoPersona.buscar(cadena);
				
				if(personas.size()>0) {
					alert=new Alert(Alert.ALERT_SUCCESS,"Personas encontradas: " + personas.size());
				}else {
					alert=new Alert(Alert.ALERT_WARNING,"No se ha encontrado ningun registro que contenga <b> " + cadena + " </b>");
				}
				 view=VIEW_INDEX_PERSONA;
			}else {
				alert=new Alert(Alert.ALERT_WARNING,"Debe insertar algun caracter para poder hacer la busqueda");
			}
			
		} catch (SQLException e) {

			LOG.error(e);
		} catch (Exception e) {

			LOG.error(e);
		} finally {
			request.setAttribute("personas", personas);
		}

	}

	private void migrarDatos(HttpServletRequest request) {

		 personas= new ArrayList<Persona>();
		 ArrayList<String>erroresInsert=new ArrayList<String>();
		 ArrayList<Integer>lineasError=new ArrayList<>();
		 ArrayList<String>msgError=new ArrayList<String>();
		
		 BufferedReader br = null;
		Persona p = null;
		String line = null;
		long tiempoTotal=0;
		long tiempoInicio=0;
		long tiempoFin=0;

		int contLineas = 0;		
		int contError = 0;		

		try {
			//br = new BufferedReader(new FileReader("C:/datosMigrar/personas.txt"));
			br = new BufferedReader(new FileReader("C:/datosMigrar/prueba5personas.txt"));

			while ((line = br.readLine()) != null) {

				p = new Persona();

				String datos[] = line.split(",");
				
				// Si la linea tiene el nº de datos esperados creamos la persona
				if (datos.length == 7) {
					for (int i = 0; i < datos.length; i++) {
						if (i == 0) {
							p.setNombre(datos[i]);
						} else if (i == 1) {
							p.setApellido1(datos[i]);
						} else if (i == 2) {
							p.setApellido2(datos[i]);
						} else if (i == 4) {
							p.setEmail(datos[i]);
						} else if (i == 5) {
							// se comprueba que el dni sea 9 digitos
							if (datos[i].length() < 9 || datos[i].length() > 9) {
								contError++;
								lineasError.add(contLineas+1);
								msgError.add("el DNI no contiene 9 caracteres");
							} else {
								p.setDni(datos[i]);
							}
						}
					} // end for
					
					
					// Se añade persona al array para la inserción
					if (!p.getDni().equals("")) {
						personas.add(p);
						contOK++;
					} else {
						contError++;
						lineasError.add(contLineas+1);
						msgError.add("El DNI esta en blanco");
						
					}

					contLineas++;
					
				} 
				else {
					contLineas++;
					contError++;
					lineasError.add(contLineas+1);
					msgError.add("La linea no contiene 7 datos");

			}
			
			}
			
			// Cerramos fichero
			br.close();
		} catch (IOException e) {
			LOG.error("Fallo al procesar fichero: " + e.getMessage());
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			
			tiempoInicio= System.currentTimeMillis();
			
			// Llamada al DAO para insertar los registros y pasar los contadores a la vista
			daoPersona.insertMultiple(personas);
			
			tiempoFin=(System.currentTimeMillis() - tiempoInicio);
			tiempoTotal = ((tiempoFin/1000) % 60) ;
			
			request.setAttribute("tiempo", tiempoTotal);
			request.setAttribute("leidos", contLineas);
			request.setAttribute("correctos", contOK);
			request.setAttribute("errores", contError);
			request.setAttribute("lineasError", erroresInsert);
			request.setAttribute("cantLineaError", lineasError);
			request.setAttribute("msg", msgError);

			view = VIEW_RESUMEN_MIGRACION;

			LOG.debug("Lectura fichero finalizada");
		}

	}
}
