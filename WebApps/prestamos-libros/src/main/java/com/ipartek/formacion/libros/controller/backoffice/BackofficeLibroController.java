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
import com.ipartek.formacion.libros.model.LibroDAO;
import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.pojo.Libro;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/libros")
public class BackofficeLibroController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;
	private static LibroDAO daoLibros = null;
	private static EditorialDAO daoEditoriales = null;

	private static final String VIEW_LISTADO = "libros/index.jsp";
	private static final String VIEW_FORMULARIO = "libros/form.jsp";

	private String view;
	private Alert alert;
	
	private String op;
	private String id;
	private String n_ejemplares;
	
	private String titulo;
	private String isbn;
	private String idEditorial;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoLibros = LibroDAO.getInstance();
		daoEditoriales = EditorialDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoLibros = null;
		daoEditoriales = null;
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

		op = (request.getParameter("op") != null ? request.getParameter("op") : OP_LISTAR);
		id = request.getParameter("id");
		n_ejemplares = request.getParameter("ejemplares");
		titulo = request.getParameter("titulo");
		isbn = request.getParameter("isbn");
		idEditorial = request.getParameter("editorial"); 
	}

	@Override
	public void listar(HttpServletRequest request) throws Exception {

		alert = null;
		view = VIEW_LISTADO;
		request.getSession().setAttribute("libros", daoLibros.getAll());
		request.getSession().setAttribute("editoriales", daoEditoriales.getAll());
	}

	@Override
	public void guardar(HttpServletRequest request) throws SQLException {
		Libro libro = new Libro();

		libro.setId(Long.parseLong(id));
		libro.setTitulo(titulo);
		libro.setIsbn(isbn);
		
		Editorial editorial = new Editorial();
		editorial.setId(Integer.parseInt(idEditorial) );
		libro.setEditorial(editorial);
		

		try {

			if (libro.getId() > 0) {

				daoLibros.update(libro); // UPDATE
				alert = new Alert(Alert.SUCCESS, "Libro modificado.");

			} else {

				daoLibros.loopInsertLibro(libro, Integer.parseInt(n_ejemplares)); // INSERT
				alert = new Alert(Alert.SUCCESS, "Libro creado.");
			}

		} catch (SQLIntegrityConstraintViolationException e) { // Error entrada duplicada

			alert = new Alert(Alert.WARNING, "el libro ya existe.");

		} catch (SQLException e) { // Longitud de campos incorrecta

			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			e.printStackTrace();

		} catch (Exception e) { // Errores que no son de SQL

			alert = new Alert();
			e.printStackTrace();
		}

		view = VIEW_FORMULARIO;
		request.setAttribute("libro", libro);

	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws Exception {
		alert = null;

		if (id.equalsIgnoreCase("-1")) {

			request.getSession().setAttribute("libro", new Libro());

		} else {

			request.getSession().setAttribute("libro", daoLibros.getById(Long.parseLong(id)));
		}

		view = VIEW_FORMULARIO;

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		try {

			if (daoLibros.delete(id)) {

				alert = new Alert(Alert.SUCCESS, "Editorial eliminado.");
				view = VIEW_LISTADO;
				request.setAttribute("editoriales", daoLibros.getAll());
			}
			listar(request);

		} catch (SQLException e) {

			alert = new Alert(Alert.WARNING, "No podemos eliminar la editorial porque tiene libros asociados.");
			view = VIEW_LISTADO;
		}
	}

}