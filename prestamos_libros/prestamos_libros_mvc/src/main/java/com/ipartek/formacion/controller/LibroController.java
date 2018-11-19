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
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.service.ServiceEditorial;
import com.ipartek.formacion.service.ServiceLibro;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/libros")
public class LibroController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;

	private static ServiceLibro srvcLibro = null;
	private static ServiceEditorial srvcEditorial = null;

	private static final String VIEW_LISTADO = "/libro/libros.jsp";
	private static final String VIEW_FORMULARIO = "/libro/form_libros.jsp";
	private String view;
	private Alert alerta = null;

	private String op;
	private String id;
	private String isbn;
	private String titulo;
	private String editorial;
	private String n_libros;
	HttpSession session;

	@SuppressWarnings("static-access")
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		srvcLibro = srvcLibro.getInstance();
		srvcEditorial = srvcEditorial.getInstance();
	}

	public void destroy() {
		super.destroy();
		srvcLibro = null;
		srvcEditorial = null;
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
		alerta = new Alert();
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
			response.sendRedirect(request.getContextPath() + view);

		}

	}

	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		isbn = request.getParameter("isbn");
		titulo = request.getParameter("titulo");
		editorial = request.getParameter("editorial");
		n_libros = request.getParameter("n_libros");
	}

	public void listar(HttpServletRequest request) throws Exception {
		try {
			alerta = null;
			view = VIEW_LISTADO;
			view = VIEW_LISTADO;

			ArrayList<Libro> libro = srvcLibro.listar();
			session.setAttribute("libros", libro);
			session.setAttribute("n_libros", libro.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		alerta = null;
		view = VIEW_FORMULARIO;

		if ("-1".equalsIgnoreCase(id)) {
			session.setAttribute("libro", new Libro());
		} else {
			session.setAttribute("libro", srvcLibro.buscar(Long.parseLong(id)));
		}
		session.setAttribute("editorial", srvcEditorial.listar());
	}

	public void guardar(HttpServletRequest request) throws Exception {
		alerta = null;
		Libro l = new Libro();

		try {
			l.setId(Long.parseLong(id));
			l.setIsbn(isbn);
			l.setTitulo(titulo);
			l.setEditorial(srvcEditorial.buscar(Long.parseLong(editorial)));

			alerta = new Alert();

			if (l.getId() > 0) {
				srvcLibro.modificar(l);
				alerta = new Alert("El registro se ha modificado con exito.", Alert.SUCCESS);
			} else {
				int n = Integer.parseInt(n_libros);
				for (int i = 0; i < n; i++) {
					srvcLibro.crear(l);
				}
				if (n == 1) {
					alerta = new Alert("El registro se ha guardado con exito.", Alert.SUCCESS);
				} else {
					alerta = new Alert(n + " registro se han guardado con exito.", Alert.SUCCESS);
				}

			}

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alerta = new Alert("El registro ya existe", Alert.WARNING);

		} catch (Exception e) {
			e.printStackTrace();
		}

		view = VIEW_LISTADO;

		ArrayList<Libro> libro = srvcLibro.listar();
		session.setAttribute("libros", libro);
		session.setAttribute("n_libros", libro.size());
	}

	public void eliminar(HttpServletRequest request) throws Exception {
		alerta = null;
		try {
			srvcLibro.eliminar(Long.parseLong(id));
			alerta = new Alert("El registro se ha eliminado con exito.", Alert.SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
		}
		view = VIEW_LISTADO;

		ArrayList<Libro> libro = srvcLibro.listar();
		session.setAttribute("libros", libro);
		session.setAttribute("n_libros", libro.size());

	}

}
