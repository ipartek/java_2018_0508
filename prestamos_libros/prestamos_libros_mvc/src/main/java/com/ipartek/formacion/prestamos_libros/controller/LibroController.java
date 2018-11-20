package com.ipartek.formacion.prestamos_libros.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.prestamos_libros.controller.pojo.Alert;
import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceLibro;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/backoffice/libro")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LibroController.class);
	private ServiceEditorial editorialService;
	private ServiceLibro libroService;

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == null o update id != null
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_LISTADO = "libros/librosDisponibles.jsp";
	private static final String VIEW_FORMULARIO_LIBRO = "libros/formAltaModLibro.jsp";

	private String view;
	private Alert alert;

	private String op; // operacion a realizar
	private String id;
	private String titulo;
	private String isbn;
	private String editorial;
	private String cantidad;

	public LibroController() {
		super();
		LOG.trace("constructor");
		LOG.trace("Servicios libros instanciados");
	}

	public void init(ServletConfig config) throws ServletException {
		libroService = ServiceLibro.getInstance();
		editorialService = ServiceEditorial.getInstance();
	}

	public void destroy() {
		libroService = null;
		editorialService = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			alert = null;

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
			LOG.error(e);
			view = VIEW_LISTADO;
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);

		}

	}

	private void listar(HttpServletRequest request) throws Exception {
		List<Libro> libros = libroService.listar();
		request.setAttribute("libros", libros);
		view = VIEW_LISTADO;

	}

	private void guardar(HttpServletRequest request) throws Exception {
		Libro l = new Libro();
		l.setTitulo(titulo);
		l.setIsbn(isbn);
		Editorial e = new Editorial();
		e.setId(new Long(editorial));
		l.setEditorial(e);
		
		try {
			
			if(!"".equals(id)) {
				//modificar
				l.setId(new Long(id));
				if(libroService.modificar(l)) {
					alert = new Alert(Alert.SUCCESS, "Libro modificado con exito.");
				}else {
					alert = new Alert(Alert.DANGER, "El libro no se ha podido modificar.");
				}
			}else {
				//añadir
				int numeroLibrosAnadir = Integer.parseInt(cantidad);
				for(int i=0; i < numeroLibrosAnadir; i++) {
					if(libroService.crear(l)) {
						alert = new Alert(Alert.SUCCESS, "El libro se ha insertado con exito.");
					}else {
						alert = new Alert(Alert.DANGER, "El libro no se ha podido insertar.");
					}
				}
			}
		}catch(Exception f) {
			LOG.error(f);
			alert = new Alert();
		}

		List<Libro> libros = libroService.listar();
		request.setAttribute("libros", libros);
		view = VIEW_LISTADO;

	}

	private void irFormulario(HttpServletRequest request) throws Exception {
		if(id!=null) {
			//modificar
			Libro libro = libroService.buscarId(Long.parseLong(id));
			
			request.setAttribute("libro", libro);
			
		}
		
		List<Editorial> editoriales = editorialService.listar();
		request.setAttribute("editoriales", editoriales);

		view = VIEW_FORMULARIO_LIBRO;
	}

	private void eliminar(HttpServletRequest request) throws Exception {
		
		try {
			
			if(libroService.eliminar(Long.parseLong(id))) {
				alert = new Alert(Alert.SUCCESS, "Libro elinimado correctamente.");
			}else {
				alert = new Alert(Alert.DANGER, "No se ha podido eliminar el libro.");
			}
			
		}catch(SQLIntegrityConstraintViolationException g) {
			LOG.error(g);
			alert = new Alert(Alert.DANGER, "No se puede eliminar un libro que este prestado.");
		}catch(Exception s) {
			LOG.error(s);
		}
		
		List<Libro> libros = libroService.listar();
		request.setAttribute("libros", libros);
		view = VIEW_LISTADO;
	}

	private void getParameters(HttpServletRequest request) {

		op = request.getParameter("op");
		if(op == null) {
			op = OP_LISTAR;
		}
		id = request.getParameter("id");
		titulo = request.getParameter("titulo");
		isbn = request.getParameter("isbn");
		editorial = request.getParameter("editorial");
		cantidad = request.getParameter("cantidad");

	}

}
