package com.ipartek.formacion.libros.controller.backoffice;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libros.model.AlumnoDAO;
import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.pojo.Alumno;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/alumnos")
public class BackofficeAlumnoController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;
	private static AlumnoDAO daoAlumno = null;

	private static final String VIEW_LISTADO = "alumnos/index.jsp";
	private static final String VIEW_FORMULARIO = "alumnos/form.jsp";

	private String view;
	private Alert alert;

	private String op; // Operacion a realizar

	private String id;
	private String nombre;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoAlumno = AlumnoDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoAlumno = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		alert = new Alert();
		try {

			getParameters(request);

			switch (op) {
			case OP_ELIMINAR:

				eliminar(request);
				break;
			case OP_IR_FORMULARIO:

				irFormularioDeAlta(request);
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

			request.getSession().setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
	}

	@Override
	public void listar(HttpServletRequest request) throws Exception {

		alert = null;
		view = VIEW_LISTADO;
		request.getSession().setAttribute("alumnos", daoAlumno.getAll());
	}

	@Override
	public void guardar(HttpServletRequest request) throws SQLException {
		Alumno alumno = new Alumno();

		alumno.setId(Long.parseLong(id));
		alumno.setNombre(nombre);

		try {

			if (alumno.getId() > 0) {

				daoAlumno.update(alumno); // UPDATE
				alert = new Alert(Alert.SUCCESS, "Alumno modificado.");

			} else {

				daoAlumno.insert(alumno); // INSERT
				alert = new Alert(Alert.SUCCESS, "Alumno creado.");
			}

		} catch (SQLIntegrityConstraintViolationException e) { // Error entrada duplicada

			alert = new Alert(Alert.WARNING, "el alumno ya existe.");

		} catch (SQLException e) { // Longitud de campos incorrecta

			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			e.printStackTrace();

		} catch (Exception e) { // Errores que no son de SQL

			alert = new Alert();
			e.printStackTrace();
		}

		view = VIEW_FORMULARIO;
		request.setAttribute("alumno", alumno);

	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws Exception {
		alert = null;

		if (id.equalsIgnoreCase("-1")) {

			request.getSession().setAttribute("alumno", new Alumno());

		} else {

			request.getSession().setAttribute("editorial", daoAlumno.getById(Long.parseLong(id)));
		}

		view = VIEW_FORMULARIO;

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		try {

			if (daoAlumno.delete(id)) {

				alert = new Alert(Alert.SUCCESS, "Editorial eliminado.");
				view = VIEW_LISTADO;
				request.setAttribute("editoriales", daoAlumno.getAll());
			}

		} catch (SQLException e) {

			alert = new Alert(Alert.WARNING, "No podemos eliminar la editorial porque tiene libros asociados.");
			view = VIEW_LISTADO;
		}
	}

}