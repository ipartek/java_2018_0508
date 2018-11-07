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
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/editoriales")
public class BackofficeEditorialController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;
	private static EditorialDAO daoEditorial = null;

	private static final String VIEW_LISTADO = "editoriales/index.jsp";
	private static final String VIEW_FORMULARIO = "editoriales/form.jsp";

	private String view;
	private Alert alert;

	private String op; // Operacion a realizar

	private String id;
	private String nombre;

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
		request.getSession().setAttribute("editoriales", daoEditorial.getAll());
	}

	@Override
	public void guardar(HttpServletRequest request) throws SQLException {
		Editorial editorial = new Editorial();
		
		editorial.setId(Long.parseLong(id));
		editorial.setNombre(nombre);

		try {

			if (editorial.getId() > 0) {
				
				daoEditorial.update(editorial); // UPDATE
				alert = new Alert(Alert.SUCCESS, "Editorial modificado.");
				
			} else {
				
				daoEditorial.insert(editorial); // INSERT
				alert = new Alert(Alert.SUCCESS, "Editorial creado.");
			}

		} catch (SQLIntegrityConstraintViolationException e) { // Error entrada duplicada
			
			alert = new Alert(Alert.WARNING, "La editorial ya existe.");

		} catch (SQLException e) { // Longitud de campos incorrecta
			
			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			e.printStackTrace();

		} catch (Exception e) { // Errores que no son de SQL

			alert = new Alert();
			e.printStackTrace();
		}

		view = VIEW_FORMULARIO;
		request.setAttribute("editorial", editorial);

	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws Exception {
		alert = null;

		if (id.equalsIgnoreCase("-1")) {
			
			request.getSession().setAttribute("editorial", new Editorial());
		
		} else {
			
			request.getSession().setAttribute("editorial", daoEditorial.getById(Long.parseLong(id)));
		}

		view = VIEW_FORMULARIO;

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		try {

			if (daoEditorial.delete(id)) {
				
				alert = new Alert(Alert.SUCCESS, "Editorial eliminado.");
				view = VIEW_LISTADO;
				request.setAttribute("editoriales", daoEditorial.getAll());
			}

		} catch (SQLException e) {

			alert = new Alert(Alert.WARNING, "No podemos eliminar la editorial porque tiene libros asociados.");
			view = VIEW_LISTADO;
		} 	
	}

}