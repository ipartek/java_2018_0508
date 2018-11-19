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

import org.apache.log4j.Logger;

import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.pojo.Editorial;
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
	private final static Logger LOG = Logger.getLogger(BackofficeLibroController.class);
	

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
	private String nuevaEditorial;

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
					+ "Intentelo con una de las existentes y introduzca una nueva");
			LOG.debug(e.getMessage());
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
		idEditorial = request.getParameter("editorial");
		nuevaEditorial = request.getParameter("nuevaEditorial");
	}

	@Override
	public void listar(HttpServletRequest request) throws Exception {

		view = VIEW_LISTADO;

		request.getSession().setAttribute("libros", libroService.listar());
		request.getSession().setAttribute("editoriales", editorialService.listar());
	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {
		Libro libro = new Libro();

		libro.setId(Long.parseLong(id));
		libro.setTitulo(titulo);
		libro.setIsbn(isbn);
		
		if(idEditorial != null) {
			Editorial editorial = new Editorial();
			editorial.setId(Integer.parseInt(idEditorial));
			libro.setEditorial(editorial);
		}
		
		if(nuevaEditorial != null && !"".contentEquals(nuevaEditorial)) {
			Editorial editorial = new Editorial();
			editorial.setNombre(nuevaEditorial);
			editorialService.crear(editorial);
			libro.setEditorial(editorial);
		}
		

		try {

			if (libro.getId() > 0) {

				libroService.modificar(libro); // UPDATE
				alert = new Alert(Alert.SUCCESS, "Libro modificado.");
				listar(request);

			} else {

				libroService.crearVarios(libro, Integer.parseInt(n_ejemplares));
				alert = new Alert(Alert.SUCCESS, "Libro creado.");
				listar(request);
			}

		} catch (SQLIntegrityConstraintViolationException e) { // Error entrada duplicada
			LOG.debug(e.getMessage());
			alert = new Alert(Alert.WARNING, "el libro ya existe.");
			view = VIEW_FORMULARIO;

		} catch (SQLException e) { // Longitud de campos incorrecta
			LOG.debug(e.getMessage());
			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			view = VIEW_FORMULARIO;
			

		} catch (Exception e) { // Errores que no son de SQL
			LOG.debug(e.getMessage());
			alert = new Alert();
			view = VIEW_FORMULARIO;
			
		}

		request.setAttribute("libro", libro);

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

				alert = new Alert(Alert.SUCCESS, "Editorial eliminado.");
				view = VIEW_LISTADO;
				request.setAttribute("editoriales", libroService.listar());
			}
			listar(request);

		} catch (SQLException e) {
			LOG.debug(e.getMessage());
			alert = new Alert(Alert.WARNING, "No podemos eliminar la editorial porque tiene libros asociados.");
			view = VIEW_LISTADO;
		}
	}

}