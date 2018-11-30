package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import java.sql.SQLException;
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

import com.ipartek.formacion.repaso.pojo.Alert;
import com.ipartek.formacion.repaso.pojo.Alumno;
import com.ipartek.formacion.repaso.service.AlumnoService;

/**
 * Servlet implementation class AlumnosController
 */
@WebServlet("/alumnos")
public class AlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AlumnoService alumnoService = null;

	private final static Logger LOG = Logger.getLogger(AlumnosController.class);

	// validaciones y alertas
	ValidatorFactory factory = null;
	Validator validator = null;
	Alert alerta = new Alert();

	// vistas
	final String FORMULARIO = "formulario.jsp";
	final String LISTADO = "home.jsp";
	final String RESULTADO = "resultado.jsp";

	// acciones
	final String LISTAR = "1";
	final String IR_FORMULARIO = "2";
	final String GUARDAR_ACTUALIZAR = "3";
	final String BUSCAR_POR = "4";
	String vista = LISTADO;

	// variables para los parametros
	String op;
	String id;
	String nombre;
	String apellido1;
	String apellido2;
	String dni;
	String email;
	String busqueda;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlumnosController() {
		super();
		alumnoService = AlumnoService.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// recoger parametros
			op = request.getParameter("op");
			id = request.getParameter("id");
			nombre = request.getParameter("nombre");
			apellido1 = request.getParameter("apellido1");
			apellido2 = request.getParameter("apellido2");
			dni = request.getParameter("dni");
			email = request.getParameter("email");
			busqueda = request.getParameter("buscador");
			Alumno a = new Alumno();
			alerta = new Alert();

			// procesar parametros validad

			if (op == null || op.equals("")) {
				op = "1";
			}

			switch (op) {

			case LISTAR:
				vista = LISTADO;
				break;

			case IR_FORMULARIO:

				if (id.equals("-1")) {
					vista = FORMULARIO;

				} else {
					a = crearAlumno(request);// le pasamos los valores al editar
					vista = FORMULARIO;
					request.setAttribute("alumno", a);
				}
				break;
			case GUARDAR_ACTUALIZAR:

				a = crearAlumno(request);
				if (id.equals("-1")) {
					a = crearAlumno(request);
					request.setAttribute("alumno", a);

					if (alumnoService.crear(a)) {
						vista = LISTADO;
					} else {
						vista = FORMULARIO;
					}

				} else {
					if (alumnoService.actualizar(a)) {
						vista = LISTADO;
					} else {
						vista = FORMULARIO;
					}
				}
				break;

			case BUSCAR_POR:
				ArrayList<Alumno> alumnoBuscado = new ArrayList<Alumno>();
				alumnoBuscado = (ArrayList<Alumno>) alumnoService.buscarPor(busqueda);

				vista = RESULTADO;
				request.setAttribute("alumnosBuscados", alumnoBuscado);
			}

			request.setAttribute("alumnos", alumnoService.listar());

		} catch (SQLException e) {
			if (e.getMessage().contains("dni_UNIQUE")) {
				alerta.setTexto("Ya contenemos un alumno con ese dni");
				alerta.setTipo(Alert.DANGER);
				vista = FORMULARIO;

			}

			LOG.error(e.getMessage());
		}

		catch (Exception e) {

			LOG.error(e.getMessage());
		} finally {

			request.setAttribute("alerta", alerta);
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}

	/**
	 * 
	 * @param request
	 *            -> para setear la alarma y el seteo de los datos que haya en el
	 *            formulario
	 * @return Alumno a
	 * @throws Exception
	 *             Si no se valida el pojo... se corta el proceso para que no siga a
	 *             la capa de servicio y no terminen datos incoherentes en la db
	 */
	private Alumno crearAlumno(HttpServletRequest request) throws Exception {

		String msg = " ";
		Alumno a = new Alumno();
		a.setId(Long.parseLong(id));
		a.setNombre(nombre);
		a.setApellido1(apellido1);
		a.setApellido2(apellido2);
		a.setDni(dni);
		a.setEmail(email);

		Set<ConstraintViolation<Alumno>> violations = validator.validate(a);
		String[] errores = new String[violations.size()];
		if (violations.size() > 0) {

			int contador = 0;

			// No tenemos ningun fallo, la Validacion es correcta
			for (ConstraintViolation<Alumno> violation : violations) {

				errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
				msg += violation.getPropertyPath() + ":" + violation.getMessage() + "<br>";
				contador++;
			}
			alerta.setTipo(Alert.DANGER);
			alerta.setTexto(msg);
			request.setAttribute(("alumno"), a);

			throw new Exception();
		}

		return a;

	}

}
