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

import com.ipartek.formacion.libros.model.EditorialDAO;
import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.pojo.Editorial;

/**
 * Servlet implementation class EditorialController
 */
@WebServlet("/noescucha")
public class EditorialController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;

	private static EditorialDAO daoEditorial;

	private static final String VIEW_LISTADO = "editoriales/index.jsp";
	private static final String VIEW_FORMULARIO = "editoriales/form.jsp";

	private static String vista;
	private static Alert alert;

	private static String op; // Operacion a realizar
	private static String id; // ID a eliminar / modificar
	private static String nuevoNombre;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		daoEditorial = EditorialDAO.getInstance();
	}

	@Override
	public void destroy() {

		super.destroy();
		daoEditorial = null;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	/**
	 * @see ICRUDController#doProcess(HttpServletRequest, HttpServletResponse)
	 */
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			getParameters(request);

			if (op != null) {

				switch (op) {
				case OP_LISTAR:

					listar(request);
					break;

				case OP_ELIMINAR:

					eliminar(request);
					break;

				case OP_GUARDAR:

					guardar(request);
					break;

				case OP_IR_FORMULARIO:

					irFormularioDeAlta(request);
					break;

				default:

					listar(request);
					break;
				}

			}
		} catch (SQLIntegrityConstraintViolationException e) {

			alert = new Alert(Alert.WARNING, "No se puede eliminar la editorial porque tiene libros asociados.");
			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
			vista = VIEW_LISTADO;

		} finally {

			request.getSession().setAttribute("alert", alert);
			response.sendRedirect(vista);
		}

	}

	/**
	 * @see ICRUDController#getParameters(HttpServletRequest)
	 */
	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nuevoNombre = request.getParameter("editorial");
	}

	/**
	 * @see ICRUDController#eliminar(HttpServletRequest)
	 */
	public void eliminar(HttpServletRequest request) throws Exception {

		if (daoEditorial.delete(id)) {

			alert = new Alert(Alert.SUCCESS, "Editorial eliminado.");
			vista = VIEW_LISTADO;
			request.getSession().setAttribute("editoriales", daoEditorial.getAll());
		}
	}

	/**
	 * @see ICRUDController#irFormularioDeAlta(HttpServletRequest)
	 */
	public void irFormularioDeAlta(HttpServletRequest request) throws NumberFormatException, Exception {

		vista = VIEW_FORMULARIO;
	}

	/**
	 * @see ICRUDController#listar(HttpServletRequest)
	 */
	public void listar(HttpServletRequest request) throws SQLException, Exception {

		alert = null;
		vista = VIEW_LISTADO;
		request.getSession().setAttribute("editoriales", daoEditorial.getAll());
	}

	/**
	 * @see ICRUDController#guardar(HttpServletRequest)
	 */
	public void guardar(HttpServletRequest request) throws SQLException, Exception {
		Editorial editorial = new Editorial();

		editorial.setId(Long.parseLong(id));
		editorial.setNombre(nuevoNombre);

		try {

			if (nuevoNombre != null && !nuevoNombre.trim().isEmpty() && nuevoNombre.length() < 3) {

				if (editorial.getId() > 0) {

					daoEditorial.update(editorial); // UPDATE
					alert = new Alert(Alert.SUCCESS, "Editorial correctamente modificada.");

				} else {

					daoEditorial.insert(editorial); // INSERT
					alert = new Alert(Alert.SUCCESS, "Editorial correctamente insertada.");
				}
			} else { // Nombre vacío

				alert.setTipo(Alert.WARNING);
				alert.setTexto("El nombre de la editorial debe contener al menos 3 caracteres.");

			}

		} catch (SQLIntegrityConstraintViolationException e) { // Error entrada duplicada

			alert = new Alert(Alert.WARNING, "La editorial ya existe en la base de datos.");
			e.printStackTrace();

		} catch (SQLException e) { // Longitud de campos incorrecta

			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			e.printStackTrace();

		} catch (Exception e) { // Errores que no son de SQL

			alert = new Alert();
			e.printStackTrace();
		}

		vista = VIEW_LISTADO;
		request.getSession().setAttribute("editoriales", daoEditorial.getAll());
	}

}
