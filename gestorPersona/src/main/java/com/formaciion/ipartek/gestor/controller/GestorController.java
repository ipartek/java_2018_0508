package com.formaciion.ipartek.gestor.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.formaciion.ipartek.gestor.DAO.PersonaDAO;
import com.formaciion.ipartek.gestor.pojo.Persona;

/**
 * Servlet implementation class GestorController
 */
@WebServlet("/home")
public class GestorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(GestorController.class);

	private static final String OP_LISTAR = "1";
	private static final String OP_GUARDAR = "2"; // Insert o update en funcion del id (-1 o >0)
	private static final String OP_BUSCAR_DNI = "3";
	private static final String OP_IR_FORMULARIO = "4";
	private static final String OP_BUSCAR_EMAIL = "5";
	private static final String OP_BUSCAR_NOMBRE_APELLIDO = "6";

	private static final String VIEW_FORM_PERSONA = "formPersona.jsp";
	private static final String VIEW_INDEX_PERSONA = "listado.jsp";

	private static PersonaDAO daoPersona;

	private String view = "";

	// Parametros
	private String op; // Operacion a realizar
	private String id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email;
	private String dni;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoPersona = PersonaDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
//		daoAlumno = null;
		daoPersona = null;
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

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		view = VIEW_INDEX_PERSONA;
		try {

			// Recoge los parametros de la request y los guarda en variables
			getParameters(request);

			// Dependiendo del valor del parametro op hace una funcion u otra
			switch (op) {

			case OP_GUARDAR:
				guardar(request); // Crea o modifica un usuario en la bbdd
				break;

			case OP_IR_FORMULARIO:
				irFormulario(request); // Cambia a la vista del formulario de gestion de usuario
				break;
			case OP_BUSCAR_DNI:
				buscarByDNI(request); // Cambia a la vista de listado de usuarios
				break;
			case OP_BUSCAR_EMAIL:
				buscarByEmail(request); // Cambia a la vista de listado de usuarios
				break;
			case OP_BUSCAR_NOMBRE_APELLIDO:
				buscarByNombreApellidos(request); // Cambia a la vista de listado de usuarios
				break;

			default: // Listar
				listar(request); // Cambia a la vista de listado de usuarios
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_INDEX_PERSONA;
			LOG.error("Ha ocurrido un error no controlado.");
		} finally {

			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	private void buscarByNombreApellidos(HttpServletRequest request) throws SQLException, Exception {
		try {
			request.setAttribute("personas", PersonaDAO.buscarNombreApellido(request.getParameter("buscaNombre")));
		} catch (Exception e) {
			LOG.error(e);
		}

	}

	private void buscarByEmail(HttpServletRequest request) {
		try {
			Persona p = new Persona();
			String buscarEmail = request.getParameter("buscaemail");
			p = daoPersona.buscarPorDni(buscarEmail);

			request.setAttribute("persona", p);
			view = VIEW_FORM_PERSONA;

		} catch (Exception e) {
			LOG.equals(e);
		}

	}

	private void buscarByDNI(HttpServletRequest request) {
		try {
			Persona p = new Persona();
			String buscardni = request.getParameter("buscadni");
			p = daoPersona.buscarPorDni(buscardni);

			request.setAttribute("persona", p);
			view = VIEW_FORM_PERSONA;

		} catch (Exception e) {
			LOG.equals(e);
		}

	}

	public void listar(HttpServletRequest request) {
		try {
			
			request.setAttribute("personas", daoPersona.listar());

		} catch (Exception e) {

			LOG.error(e);
		}
	}

	public void guardar(HttpServletRequest request) throws Exception {
		view = VIEW_FORM_PERSONA;
		Persona p = null;

		try {
			p = new Persona();

			if (id != null && id.equals("0")) {

				// Crear Persdona nuevo
				p.setNombre(nombre);
				p.setId(Long.parseLong(id));
				p.setApellido1(apellido1);
				p.setApellido2(apellido2);
				p.setEmail(email);
				p.setDni(dni);

				if (daoPersona.insert(p)) {
					request.setAttribute("alerta", "Registro creado con exito");
					LOG.debug("persona guardada con éxito.");

				}else {
					request.setAttribute("alerta", "No se ha podido crear");
				}
			} else {
				// Modificar persona existente
				p.setNombre(nombre);
				p.setId(Long.parseLong(id));
				p.setApellido1(apellido1);
				p.setApellido2(apellido2);
				p.setEmail(email);
				p.setDni(dni);

				if (daoPersona.modificar(p)) {
					request.setAttribute("alerta", "Registro modificado con exito");
					LOG.debug("Persona <b> " + p.getNombre() + " </b> modificada con éxito.");
				}else {
					request.setAttribute("alerta", "no se ha podido modificar");
				}
			}

		} catch (SQLIntegrityConstraintViolationException slqIntegrity) {
			slqIntegrity.printStackTrace();

			LOG.debug("El registro <b> " + p.getNombre() + " </b> no se puede registrar porque ya existe!!");
		} catch (Exception e) {

			LOG.error(e);
		}
//		request.setAttribute("alumnos", daoAlumno.getAll());
		request.setAttribute("persona", p);

	}

	@Autowired
	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		apellido1 = request.getParameter("apellido1");
		apellido2 = request.getParameter("apellido2");
		email = request.getParameter("email");
		dni = request.getParameter("dni");
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

}