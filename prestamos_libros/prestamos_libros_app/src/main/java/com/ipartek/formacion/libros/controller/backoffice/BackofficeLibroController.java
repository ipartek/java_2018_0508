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

import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.service.ServiceEditorial;
import com.ipartek.formacion.libros.service.ServiceLibro;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/libros")
public class BackofficeLibroController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;
	private static ServiceLibro libroService = null;
	private static ServiceEditorial editorialService = null;

	private static final String VIEW_LISTADO = "libros/index.jsp";
	private static final String VIEW_FORMULARIO = "libros/form.jsp";

	private String view;
	private Alert alert;

	private String op;
	private String id;
	private String n_ejemplares;

	private String titulo;
	private String isbn;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// daoLibros = LibroDAO.getInstance();
		libroService = ServiceLibro.getInstance();
		editorialService = ServiceEditorial.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		libroService = null;
		editorialService = null;
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

		alert = null;

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

			alert = new Alert();
			alert.setTipo(Alert.DANGER);
			alert.setTexto("La editorial con la que intenta dar de alta o actulizar el nuevo libro ya existe\n"
					+ "Intentelo con una de las existentes.");
			e.printStackTrace();
			view = VIEW_FORMULARIO;

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

	}

	@Override
	public void listar(HttpServletRequest request) throws Exception {

		view = VIEW_LISTADO;

		request.getSession().setAttribute("libros", libroService.listar());
		request.getSession().setAttribute("editoriales", editorialService.listar());
	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {
		Libro libro;
		try {

			if (titulo != null && !titulo.trim().isEmpty() && titulo.length() < 3) {

				libro = new Libro();

				libro.setId(Long.parseLong(id));
				libro.setTitulo(titulo);
				libro.setIsbn(isbn);

				if (libro.getId() > 0) {

					libroService.modificar(libro); // UPDATE
					alert = new Alert(Alert.SUCCESS, "Libro modificado.");
					listar(request);

				} else {

					libroService.crearVarios(libro, Integer.parseInt(n_ejemplares));
					alert = new Alert(Alert.SUCCESS, "Libro creado.");
					listar(request);

				}
				request.setAttribute("libro", libro);
			} else { // Nombre vacío

				alert.setTipo(Alert.WARNING);
				alert.setTexto("El nombre de la editorial debe contener al menos 3 caracteres.");

			}

			view = VIEW_FORMULARIO;

		} catch (SQLIntegrityConstraintViolationException e) { // Error entrada duplicada

			alert = new Alert(Alert.WARNING, "el libro ya existe.");
			view = VIEW_FORMULARIO;

		} catch (SQLException e) { // Longitud de campos incorrecta

			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			view = VIEW_FORMULARIO;
			e.printStackTrace();

		} catch (Exception e) { // Errores que no son de SQL

			alert = new Alert();
			view = VIEW_FORMULARIO;
			e.printStackTrace();
		}

	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws Exception {
		alert = null;

		if (id.equalsIgnoreCase("-1")) {

			request.getSession().setAttribute("libro", new Libro());

		} else {

			request.getSession().setAttribute("libro", libroService.obtener(Long.parseLong(id)));
		}

		view = VIEW_FORMULARIO;

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		try {

			if (libroService.eliminar(id)) {

				alert = new Alert(Alert.SUCCESS, "Libro correctamente eliminado.");
				view = VIEW_LISTADO;
				request.setAttribute("editoriales", libroService.listar());
			}
			listar(request);

		} catch (SQLException e) {

			alert = new Alert(Alert.WARNING, "No podemos eliminar el libro debido a un error en la base de datos.");
			view = VIEW_LISTADO;
		}
	}

}