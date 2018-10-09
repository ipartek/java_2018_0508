package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Alert;
import com.ipartek.formacion.youtube.Rol;
import com.ipartek.formacion.youtube.model.RolDAO;

/**
 * Servlet implementation class BackofficeRolController
 */
@WebServlet("/backoffice/roles")
public class BackofficeRolController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	private static RolDAO dao;


	private static final String VIEW_LISTADO = "rol/index.jsp";
	private static final String VIEW_FORMULARIO = "rol/formulario.jsp";

	private String view;
	private Alert alert;

	private String op; //
	private String id;
	private String nombre;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = RolDAO.getInstance();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
		// se ejecuta al parar el servidor
		dao = null;
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

		try {
			alert = new Alert();

			getParameters(request);

			switch (op) {
			case OP_GUARDAR:
				guardar(request);
				break;
			case OP_ELIMINAR:
				eliminar(request);
				break;
			case OP_IR_FORMULARIO:
				irFormulario(request);
				break;

			default:
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
	// TODO Auto-generated method stub

	public void listar(HttpServletRequest request) throws Exception {

		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("roles", dao.getAll());
	}

	public void irFormulario(HttpServletRequest request) throws Exception {

		alert = null;
		view = VIEW_FORMULARIO;
		
		Rol rol = new Rol();
		if (Integer.parseInt(id) > 0) {
			rol = dao.getById(id);
		}
		request.setAttribute("rol", rol);
	}

	public void eliminar(HttpServletRequest request) throws Exception {

		try {

			alert = new Alert();
			alert.setTexto("Rol Eliminado");
			alert.setTipo("alert-success");
			dao.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
			alert.setTipo("alert-danger");
			alert.setTexto("No podemos eliminar el rol por que tiene usuarios creados");
		}

		view = VIEW_LISTADO;
		request.setAttribute("roles", dao.getAll());
	}

	public void guardar(HttpServletRequest request) throws Exception {

		Rol r = new Rol();
		r.setId(Long.parseLong(id));
		r.setNombre(nombre);

		try {
			if (r.getId() > 0) {
				dao.update(r);
			} else {
				dao.insert(r);
			}
			alert.setTexto("Rol guardado con exito");
			alert.setTipo("alert-success");

			// nombre repetido
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alert.setTipo("alert-danger");
			alert.setTexto("<b>" + r.getNombre() + " </b> El rol ya existe!!!");

			// longitud campos nombre y password
		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getMessage().contains("nombre")) {
				
				alert.setTipo("alert-danger");
				alert.setTexto("El <b>nombre</b> debe ser inferior a 50 caracteres");

			}
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}

		view = VIEW_FORMULARIO;
		request.setAttribute("rol", r);

	}

	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");

	}

}
