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
import com.ipartek.formacion.pojo.Editorial;
import com.ipartek.formacion.service.ServiceEditorial;

/**
 * Servlet implementation class EditorialController
 */
@WebServlet("/editoriales")
public class EditorialController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	private static ServiceEditorial srvcEditorial;

	private static final String VIEW_LISTADO = "/editorial/editoriales.jsp";
	private static final String VIEW_FORMULARIO = "/editorial/form_editoriales.jsp";
	private String view;
	private HttpSession session;
	private Alert alerta = null;

	private String op;
	private String id;
	private String nombre;

	@SuppressWarnings("static-access")
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		srvcEditorial = srvcEditorial.getInstance();
	}

	public void destroy() {
		super.destroy();
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
		alerta = null;

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
			alerta = new Alert();
			view = VIEW_LISTADO;
		} finally {
			session.setAttribute("alerta", alerta);
			response.sendRedirect(request.getContextPath() + view);
		}

	}

	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
	}

	public void listar(HttpServletRequest request) throws Exception {
		try {

			view = VIEW_LISTADO;

			ArrayList<Editorial> editorial = srvcEditorial.listar();
			session.setAttribute("editoriales", editorial);
			session.setAttribute("n_editoriales", editorial.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void irFormulario(HttpServletRequest request) throws Exception {

		view = VIEW_FORMULARIO;
		if ("-1".equalsIgnoreCase(id)) {
			session.setAttribute("editorial", new Editorial());
		} else {
			session.setAttribute("editorial", srvcEditorial.buscar(Long.parseLong(id)));
		}

		session.setAttribute("editoriales", srvcEditorial.listar());
	}

	public void guardar(HttpServletRequest request) throws Exception {

		Editorial ed = new Editorial();

		try {
			ed.setId(Long.parseLong(id));
			ed.setNombre(nombre);
			if (ed.getId() > 0) {

				srvcEditorial.modificar(ed);
				alerta = new Alert("El registro se ha modificado con exito.", Alert.SUCCESS);

			} else {

				srvcEditorial.crear(ed);
				alerta = new Alert("El registro se ha creado con exito.", Alert.SUCCESS);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alerta = new Alert("El registro ya existe", Alert.WARNING);

		} catch (Exception e) {
			e.printStackTrace();
		}

		view = VIEW_LISTADO;

		ArrayList<Editorial> editorial = srvcEditorial.listar();
		session.setAttribute("editoriales", editorial);
		session.setAttribute("n_editoriales", editorial.size());
	}

	public void eliminar(HttpServletRequest request) throws Exception {
		try {

			srvcEditorial.eliminar(Long.parseLong(id));
			alerta = new Alert("El registro se ha eliminado con exito.", Alert.SUCCESS);

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alerta = new Alert("El registro a eliminar tiene libros asociados", Alert.DANGER);

		} catch (Exception e) {
			e.printStackTrace();
		}
		view = VIEW_LISTADO;

		ArrayList<Editorial> editorial = srvcEditorial.listar();
		session.setAttribute("editoriales", editorial);
		session.setAttribute("n_editoriales", editorial.size());
	}

}
