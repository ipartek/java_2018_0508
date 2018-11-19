package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.prestamos_libros.model.CrudControllable;
import com.ipartek.formacion.prestamos_libros.pojo.Alumno;
import com.ipartek.formacion.prestamos_libros.service.ServiceAlumno;

@WebServlet("/prestamo/alumno")
public class AlumnoController extends HttpServlet implements CrudControllable{
	private static final long serialVersionUID = 1L;

	private static final String OP_LISTAR = "1";
	private static final String OP_GUARDAR = "2"; // Insert o update en funcion del id (-1 o >0)
	private static final String OP_ELIMINAR = "3";
	private static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_FORM_ALUMNO = "alumno/formAlumno.jsp";
	private static final String VIEW_INDEX_ALUMNO = "alumno/index.jsp";
	
	// Logger
	private final static Logger LOG = Logger.getLogger(AlumnoController.class);

	private static ServiceAlumno serviceAlumno;

	private String view = "";
	private Alert alert = null;

	// Parametros
	private String op; // Operacion a realizar
	private String id;
	private String nombre;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		serviceAlumno = ServiceAlumno.getInstance();
		LOG.trace("Servicio alumno instanciado");
	}

	@Override
	public void destroy() {
		super.destroy();
		serviceAlumno = null;
		LOG.trace("Servicio alumno destruido");
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

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		view = VIEW_INDEX_ALUMNO;
		try {
			alert = null;

			// Recoge los parametros de la request y los guarda en variables
			getParameters(request);

			// Dependiendo del valor del parametro op hace una funcion u otra
			switch (op) {
			case OP_ELIMINAR:
				eliminar(request); // Elimina un usuario de la bbdd
				break;

			case OP_GUARDAR:
				guardar(request); // Crea o modifica un usuario en la bbdd
				break;

			case OP_IR_FORMULARIO:
				irFormulario(request); //Cambia a la vista del formulario de gestion de usuario
				break;

			default: // Listar
				listar(request); // Cambia a la vista de listado de usuarios
				break;
			}
		} catch (Exception e) {
			LOG.error(e);
			view = VIEW_INDEX_ALUMNO;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	@Override
	public void listar(HttpServletRequest request) {
		try {
			request.setAttribute("alumnos", serviceAlumno.listar());
			LOG.debug("Listado de alumnos devuelto");
		} catch (Exception e) {
			LOG.error(e);
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		}
	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {
		view = VIEW_FORM_ALUMNO;
		Alumno a = null;
		String nombre_apellidos="";
		try {
			a = new Alumno();

			if (id != null && id.equals("")) {

				if (("").equals(nombre)) {
					alert = new Alert(Alert.ALERT_WARNING, "Todos los campo deben ser completados para poder insertar un nuevo registro.");
					LOG.warn("No se ha podido crear el alumno");
				} else {
					// Crear Alumno nuevo
					nombre_apellidos=nombre;
					a.setNombre(nombre_apellidos);					

					if (serviceAlumno.crear(a)) {
						alert = new Alert(Alert.ALERT_SUCCESS, "Alumno guardada con éxito.");
						LOG.debug("Alumno creado con exito");
					}
				}

			} else {
				// Modificar alumno existente
				a.setNombre(nombre);
				a.setId(Long.parseLong(id));

				if (("").equals(nombre.trim())) {
					alert = new Alert(Alert.ALERT_WARNING, "El campo nombre no puede estar vacio.");
					LOG.warn("No se ha podido modificar el alumno");
				} else {
					if (serviceAlumno.modificar(a)) {
						LOG.debug("Alumno modificado");
						alert = new Alert(Alert.ALERT_SUCCESS,
								"Alumno <b> " + a.getNombre() + " </b> modificada con éxito.");
					}
				}

			}

		} catch (SQLIntegrityConstraintViolationException slqIntegrity) {
			LOG.error(slqIntegrity);
			alert = new Alert(Alert.ALERT_WARNING,
					"El registro <b>" + a.getNombre() + "</b> no se puede registrar porque ya existe!!");

		} catch (Exception e) {
			LOG.error(e);
		}
		request.setAttribute("alumno", a);

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {

		if (id != null) {
			try {
				if (serviceAlumno.eliminar(Long.parseLong(id))) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Se ha eliminado el registro");
					LOG.debug("Alumno eliminado con exito");
				}

			} catch (SQLIntegrityConstraintViolationException slqIntegrity) {
				LOG.error(slqIntegrity);
				slqIntegrity.printStackTrace();
				alert = new Alert(Alert.ALERT_WARNING,
						" El alumno no se puede eliminar porque tiene algun prestamo asociado");
			} catch (Exception e) {
				LOG.error(e);
				alert = new Alert();

			}
			view = VIEW_INDEX_ALUMNO;
			request.setAttribute("alumnos", serviceAlumno.listar());
		}

	}

	@Override
	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id"); // 0 = crear, 1 = modificar
		nombre = request.getParameter("nombre");
		LOG.debug("Parametros recogidos");
	}

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception {
		Alumno alumno = null;
		if(Integer.parseInt(id)>0) {
			alumno = serviceAlumno.buscarPorId(Long.parseLong(id));
			LOG.debug("Alumno encontrado");
		}else {
			alumno = new Alumno();
			LOG.debug("Nuevo Alumno");
		}
		request.setAttribute("alumno", alumno);
		view = VIEW_FORM_ALUMNO;
	}

}