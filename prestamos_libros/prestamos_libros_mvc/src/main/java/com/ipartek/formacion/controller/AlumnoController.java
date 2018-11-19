package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.pojo.Alert;
import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.service.ServiceAlumno;

/**
 * Servlet implementation class AlumnoController
 */
@WebServlet("/alumnos")
public class AlumnoController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	private static ServiceAlumno srvcAlumno = null;

	private static final String VIEW_LISTADO = "alumno/alumnos.jsp";
	private static final String VIEW_FORMULARIO = "alumno/form_alumnos.jsp";
	private String view;
	private HttpSession session;
	private Alert alerta = null;

	private String op;
	private String id;
	private String nombre;
	private String apellidos;

	@SuppressWarnings("static-access")
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		srvcAlumno = srvcAlumno.getInstance();
	}

	public void destroy() {
		super.destroy();
		srvcAlumno = null;
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

		session = request.getSession();
		alerta = null;
		try {

			getParameters(request);

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

			default: // LISTAR
				listar(request);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_LISTADO;
		} finally {
			session.setAttribute("alerta", alerta);
			request.getRequestDispatcher(view).forward(request, response);

		}

	}

	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		apellidos = request.getParameter("apellidos");
	}

	public void listar(HttpServletRequest request) throws Exception {
		try {

			view = VIEW_LISTADO;

			ArrayList<Alumno> alumno = srvcAlumno.listar();
			request.setAttribute("alumnos", alumno);
			request.setAttribute("n_alumnos", alumno.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		view = VIEW_FORMULARIO;

		if ("-1".equalsIgnoreCase(id)) {
			request.setAttribute("alumno", new Alumno());
		} else {
			request.setAttribute("alumno", srvcAlumno.buscar(Long.parseLong(id)));
		}

		session.setAttribute("alumnos", srvcAlumno.listar());
	}

	public void guardar(HttpServletRequest request) throws Exception {

		Alumno al = new Alumno();

		try {
			al.setId(Long.parseLong(id));
			al.setNombre(nombre);
			al.setApellidos(apellidos);

			if (al.getId() > 0) {
				srvcAlumno.modificar(al);
				alerta = new Alert("El registro se ha modificado con exito.", Alert.SUCCESS);
			} else {
				srvcAlumno.crear(al);
				alerta = new Alert("El registro se ha creado con exito.", Alert.SUCCESS);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alerta = new Alert("El registro ya existe en la base de datos", Alert.WARNING);

		} catch (Exception e) {
			e.printStackTrace();
		}

		view = VIEW_LISTADO;

		ArrayList<Alumno> alumno = srvcAlumno.listar();
		request.setAttribute("alumnos", alumno);
		request.setAttribute("n_alumnos", alumno.size());
	}

	public void eliminar(HttpServletRequest request) throws Exception {
		try {
			srvcAlumno.eliminar(Long.parseLong(id));
			alerta = new Alert("Registro eliminado correctamente", Alert.SUCCESS);
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alerta = new Alert("El registro a eliminar tiene libros asociados", Alert.DANGER);

		} catch (Exception e) {
			e.printStackTrace();
		}
		view = VIEW_LISTADO;

		ArrayList<Alumno> alumno = srvcAlumno.listar();
		request.setAttribute("alumnos", alumno);
		request.setAttribute("n_alumnos", alumno.size());

	}

}
