package com.ipartek.formacion.libros.controller.backoffice;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class AlumnosController
 */
@WebServlet("/backoffice/alumnos_")
public class AlumnosController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;

	private static final String VISTA_LISTA = "alumnos/index.jsp";
	private static AlumnoDAO alumnosDAO;

	private String op;
	private String id;

	Alert alert;
	String vista;
	String nombre;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		alumnosDAO = AlumnoDAO.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			alert = new Alert();
			getParameters(request);

			switch (op) {

			case OP_IR_FORMULARIO:

				break;

			case OP_ELIMINAR:

				eliminar(request);
				break;

			case OP_GUARDAR:

				guardar(request);
				break;

			default:

				listar(request);
			}

		} catch (Exception e) {

			e.printStackTrace();
			alert = new Alert();

		} finally {

			request.getSession().setAttribute("alert", alert);
			request.getRequestDispatcher(vista).forward(request, response);
		}

	}

	@Override
	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null ? request.getParameter("op") : OP_LISTAR);
		id = request.getParameter("id");
		nombre = request.getParameter("alumno");

	}

	@Override
	public void guardar(HttpServletRequest request) throws SQLException, Exception {

		Alumno a;
		boolean resul = false;
		alert = new Alert();

		if (nombre != null && !nombre.trim().isEmpty() && nombre.length() > 3) {

			a = alumnosDAO.getById(Long.parseLong(id));

			if (a != null) { // Modificar Alumno encontrado

				a.setNombre(nombre);
				resul = alumnosDAO.update(a);

				if (resul == true) {
					alert.setTipo(Alert.SUCCESS);
					alert.setTexto("Alumno modificado correctamente.");
				}

			} else { // Crear alumno

				a = new Alumno();
				a.setNombre(nombre);
				resul = alumnosDAO.insert(a);

				if (resul == true) {

					alert.setTipo(Alert.SUCCESS);
					alert.setTexto("Alumno insertado correctamente.");

				}
			}
		} else { // Nombre vacío

			alert.setTipo(Alert.WARNING);
			alert.setTexto("El nombre debe contener al menos 3 caracteres.");

		}

		listar(request);

	}

	@Override
	public void listar(HttpServletRequest request) throws SQLException, Exception {

		vista = VISTA_LISTA;
		request.getSession().setAttribute("alumnos", alumnosDAO.getAll());
		// Reseteamos la alarma al cargar el listado que por defecto sale mensaje de
		// error
		if (alumnosDAO.getAll() != null) {
			alert.setTexto("");
			alert.setTipo("");
		}

	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws NumberFormatException, Exception {

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {

		boolean resul = false;

		resul = alumnosDAO.delete(id);

		if (resul) {

			alert = new Alert();
			alert.setTipo(Alert.SUCCESS);
			alert.setTexto("Alumno eliminado correctamente");
		}

		listar(request);

	}

}