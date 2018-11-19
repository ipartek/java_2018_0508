package com.ipartek.formacion.prestamos_libros.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.prestamos_libros.controller.pojo.Alert;
import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;

/**
 * Servlet implementation class EditorialAController
 */
@WebServlet("/backoffice/editorial")
public class EditorialController extends HttpServlet {
	private final static Logger LOG = Logger.getLogger(EditorialController.class);

	private static final long serialVersionUID = 1L;
	private ServiceEditorial editorialService;

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == null o update id != null
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_LISTADO = "editoriales/editoriales.jsp";
	private static final String VIEW_FORMULARIO_EDITORIAL = "editoriales/formAltaModEditorial.jsp";

	private String view;
	private Alert alert;
	// private Alert alert;

	private String op; // operacion a realizar
	private String id;
	private String nombre;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditorialController() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		editorialService = new ServiceEditorial();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		editorialService = null;
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
			e.printStackTrace();
			view = VIEW_LISTADO;
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);

		}

	}

	private void listar(HttpServletRequest request) throws Exception {
		List<Editorial> editoriales = editorialService.listar();
		request.setAttribute("editoriales", editoriales);
		view = VIEW_LISTADO;

	}

	private void guardar(HttpServletRequest request) throws Exception {
		Editorial e = new Editorial();
		e.setNombre(nombre);

		try {

			if (!"".equals(id)) {
				// modificar
				e.setId(new Long(id));
				if (editorialService.modificar(e)) {
					alert = new Alert(Alert.SUCCESS, "editorial modificado correctamente.");
				} else {
					alert = new Alert(Alert.DANGER, "Editorial no se ha podido modificar.");

				}
			} else {
				// añadir
				if (editorialService.crear(e)) {
					alert = new Alert(Alert.SUCCESS, "Editorail creado correctamente.");
				} else {
					alert = new Alert(Alert.DANGER, "Editorial no se ha podido crear.");
				}
			}

		} catch (SQLIntegrityConstraintViolationException t) {
			t.printStackTrace();
			alert = new Alert(Alert.DANGER, "No puede haber dos editoriales con el mismo nombre.");
		} catch (Exception q) {
			LOG.error(q);
		}

		List<Editorial> editoriales = editorialService.listar();
		request.setAttribute("editoriales", editoriales);
		view = VIEW_LISTADO;

	}

	private void irFormulario(HttpServletRequest request) throws Exception {
		if (id != null) {
			// modificar
			Editorial editorial = editorialService.buscarId(Long.parseLong(id));

			request.setAttribute("editorial", editorial);

		}

		view = VIEW_FORMULARIO_EDITORIAL;
	}

	private void eliminar(HttpServletRequest request) throws Exception {
		try {

			if (editorialService.eliminar(Long.parseLong(id))) {
				alert = new Alert(Alert.SUCCESS, "Editorial eliminado correctamente.");
			} else {
				alert = new Alert(Alert.DANGER, "Editorial no se ha podido eliminar.");
			}

		} catch (SQLIntegrityConstraintViolationException x) {
			x.printStackTrace();
			alert = new Alert(Alert.DANGER, "No se puede eliminar un editorial que contenga libros.");
		} catch (Exception e1) {
			LOG.error(e1);

		}

		List<Editorial> editoriales = editorialService.listar();
		request.setAttribute("editoriales", editoriales);
		view = VIEW_LISTADO;
	}

	private void getParameters(HttpServletRequest request) {
		// TODO Auto-generated method stub
		op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");

	}

}
