package com.ipartek.formacion.prestamolibros.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.prestamolibros.pojo.Alert;
import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.service.IService;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;

/**
 * Servlet implementation class EditorialController
 */
@WebServlet("/backoffice/editoriales")
public class EditorialesController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	// private EditorialDAO daoEditorial;
	private IService<Editorial> servicioEditorial;
	private Alert alert;
	private String op;
	private String view;
	private String id;
	private String nombre;
	private boolean redirect;
	HttpSession session;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// daoEditorial = EditorialDAO.getInstance();
		servicioEditorial = ServicioEditorial.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// daoEditorial = null;
		servicioEditorial = null;
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

	@Override
	public void getParameters(HttpServletRequest request) {

		try {
			request.setCharacterEncoding(ENCODE);
			op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
			id = request.getParameter("id");
			nombre = request.getParameter("nombre");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			alert = new Alert();
		}

	}

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		redirect = false;
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

			default:// LISTAR

				listar(request);
				break;

			// buscar operacion a realizar
			}
		} catch (Exception e) {
			e.printStackTrace();

			alert = new Alert();
		} finally {

			session.setAttribute("alert", alert);

			if (redirect) {
				response.sendRedirect(request.getContextPath() + view);
			} else {
				request.getRequestDispatcher(view).forward(request, response);
			}

			try {
				session.setAttribute("editoriales", servicioEditorial.listar());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {

		Editorial editorial = new Editorial();

		try {

			editorial.setId(Long.parseLong(id));
			editorial.setEditorial(nombre);

			if ("".equals(editorial.getEditorial().trim())) {
				alert = new Alert(Alert.WARNING, "Introduce un valor alfanumérico por favor");

			} else {

				if (editorial.getId() == -1) {

					if (servicioEditorial.crear(editorial)) {
						alert = new Alert(Alert.SUCCESS,
								"Editorial <b>" + editorial.getEditorial() + "</b> creada correctamente.");
					}

				} else {

					if (servicioEditorial.modificar(editorial)) {
						alert = new Alert(Alert.SUCCESS,
								"Editorial <b>" + editorial.getEditorial() + "</b> modificada correctamente.");
					}
				}

			}

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alert = new Alert(Alert.WARNING, "La editorial <b>" + editorial.getEditorial() + "</b> ya existe.");
		}

		catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}

		redirect = true;
		session.setAttribute("editorial", editorial);
		view = "/backoffice/editoriales/formulario.jsp";

	}

	@Override
	public void listar(HttpServletRequest request) throws Exception {
		request.setAttribute("editoriales", servicioEditorial.listar());
		view = "editoriales/editorial.jsp";

	}

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception {
		alert = null;
		view = "editoriales/formulario.jsp";
		if (id.equalsIgnoreCase("-1")) {
			request.setAttribute("editorial", new Editorial());
		} else {

			request.setAttribute("editorial", servicioEditorial.buscar(Long.parseLong(id)));

		}

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {

		Editorial e = new Editorial();

		try {
			if (id != null && op != null && OP_ELIMINAR.equals(op)) { // Eliminar

				e = servicioEditorial.buscar(Long.parseLong(id));

				if (servicioEditorial.eliminar(Long.parseLong(id))) {
					view = "/backoffice/editoriales/editorial.jsp";
					alert = new Alert(Alert.SUCCESS,
							"Editorial <b>" + e.getEditorial() + "</b> eliminada correctamente");

				} else {
					alert = new Alert(Alert.WARNING, "No hemos podido eliminar la editorial");
				}

			}

		} catch (SQLIntegrityConstraintViolationException ex) {
			ex.printStackTrace();
			view = "/backoffice/editoriales/formulario.jsp";
			session.setAttribute("editorial", e);
			alert = new Alert(Alert.WARNING,
					"No se puede eliminar la editorial, ya que tiene uno o más libros asociados.");

		} catch (Exception ex) {
			ex.printStackTrace();
			view = "/backoffice/editoriales/formulario.jsp";
			session.setAttribute("editorial", e);
			alert = new Alert();
		}
		redirect = true;

	}

}
