package com.ipartek.formacion.prestamolibros.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.prestamolibros.controller.pojo.Alert;
import com.ipartek.formacion.prestamolibros.pojo.Alumno;
import com.ipartek.formacion.prestamolibros.service.IService;
import com.ipartek.formacion.prestamolibros.service.ServicioAlumno;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/backoffice/alumnos")
public class AlumnosController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	// private AlumnoDAO daoAlumno;
	private IService<Alumno> servicioAlumno;
	private Alert alert;
	private String op;
	private String view;
	private String id;
	private String nombre;
	private String apellidos;
	private boolean redirect;
	HttpSession session;
	
	private final static Logger LOG = Logger.getLogger(AlumnosController.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// daoAlumno = AlumnoDAO.getInstance();
		servicioAlumno = ServicioAlumno.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// daoAlumno = null;
		servicioAlumno = null;
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
	public void getParameters(HttpServletRequest request) {

		try {
			request.setCharacterEncoding(ENCODE);
			op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
			id = request.getParameter("id");
			nombre = request.getParameter("nombre");
			apellidos = request.getParameter("apellidos");

		} catch (UnsupportedEncodingException e) {
			LOG.debug(e);
			alert = new Alert();
		}

	}

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		redirect = false;
		try {
			alert = null;
			getParameters(request);
			redirect = false;
			switch (op) {
			case OP_ELIMINAR:
				eliminar(request);
				break;

			case OP_IR_FORMULARIO:
				irFormulario(request);
				break;

			case OP_GUARDAR:
				guardar(request);
				break;

			default:// LISTAR

				listar(request);
				break;

			// buscar operacion a realizar
			}
		} catch (Exception e) {
			LOG.debug(e);

			alert = new Alert();
		} finally {

			session.setAttribute("alert", alert);
			
			if(redirect) {
				response.sendRedirect(request.getContextPath() + view);
			}else {
				request.getRequestDispatcher(view).forward(request, response);
			}
			
			try {
				session.setAttribute("alumnos", servicioAlumno.listar());
			} catch (Exception e) {
				LOG.debug(e);
			}

		}

	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {

		Alumno alumno = new Alumno();

		try {

			alumno.setId(Long.parseLong(id));
			alumno.setNombre(nombre);
			alumno.setApellidos(apellidos);
			
			if("".equals(alumno.getNombre().trim()) || "".equals(alumno.getApellidos().trim())) {
				
				alert = new Alert(Alert.WARNING, "Introduce un valor alfanumérico por favor");
				
			}else {
				
				if (alumno.getId() == -1) {
	
					if (servicioAlumno.crear(alumno)) {
						alert = new Alert(Alert.SUCCESS, "Alumno <b>" + alumno.getNombre() + "</b> creado correctamente.");
					}
	
				} else {
	
					if (servicioAlumno.modificar(alumno)) {
						alert = new Alert(Alert.SUCCESS,
								"Alumno <b>" + alumno.getNombre() + "</b> modificado correctamente.");
					}
				}
				
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			alert = new Alert(Alert.WARNING, "El alumno <b>" + alumno.getNombre() + "</b> ya existe.");
		}

		catch (Exception e) {
			LOG.debug(e);
			alert = new Alert();
		}
		
		redirect = true;
		session.setAttribute("alumno", alumno);
		view = "/backoffice/alumnos/formulario.jsp";

	}

	@Override
	public void listar(HttpServletRequest request) throws Exception {
		request.setAttribute("alumnos", servicioAlumno.listar());
		view = "alumnos/alumno.jsp";

	}

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception {
		alert = null;
		view = "alumnos/formulario.jsp";
		if (id.equalsIgnoreCase("-1")) {
			request.setAttribute("alumno", new Alumno());
		} else {

			request.setAttribute("alumno", servicioAlumno.buscar(Long.parseLong(id)));

		}

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {

		Alumno a = new Alumno();
		
		try {
			if (id != null && op != null && OP_ELIMINAR.equals(op)) { // Eliminar

				a = servicioAlumno.buscar(Long.parseLong(id));

				if (servicioAlumno.eliminar(Long.parseLong(id))) {
					view = "/backoffice/alumnos/alumno.jsp";
					alert = new Alert(Alert.SUCCESS, "Alumno <b>" + a.getNombre() + "</b> eliminado correctamente");

				} else {
					session.setAttribute("alumno", a);
					view = "/backoffice/alumnos/formulario.jsp";
					alert = new Alert(Alert.WARNING, "No hemos podido eliminar el alumno ");
				}

			}

		} catch(SQLIntegrityConstraintViolationException e){

			LOG.debug(e);
			session.setAttribute("alumno", a);
			view = "/backoffice/alumnos/formulario.jsp";
			alert = new Alert(Alert.WARNING, "No se puede eliminar este alumno porque tiene un libro prestado");
		
		}catch (Exception e) {
			session.setAttribute("alumno", a);
			view = "/backoffice/alumnos/formulario.jsp";
			LOG.debug(e);
			alert = new Alert();
		}
		
		redirect = true;
		

	}

}
