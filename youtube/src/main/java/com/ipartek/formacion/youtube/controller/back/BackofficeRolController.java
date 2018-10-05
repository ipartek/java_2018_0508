package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Rol;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet(description = "Para la gestion de los roles", urlPatterns = { "/backoffice/rol" })
public class BackofficeRolController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static RolDAO daoRol;

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_LISTADO = "rol/index.jsp";
	private static final String VIEW_FORMULARIO = "rol/form.jsp";
	private String view;
	private Alert alert;

	private String op; // operacion a realizar
	private String id;
	private String nombre;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		daoRol = RolDAO.getInstance();

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

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);

		}

	}

	private void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");

	}

	private void listar(HttpServletRequest request) throws Exception {

		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("roles", daoRol.getAll());
		request.setAttribute("nRoles", daoRol.getAll().size());

	}

	private void guardar(HttpServletRequest request) {

		Rol r = new Rol();
		r.setId(Long.parseLong(id));
		r.setNombre(nombre);
		
		try {

			if (r.getId() == -1) {// INSERT
				daoRol.insert(r);
			} else { // UPDATE
				daoRol.update(r);
			}

			alert = new Alert("Rol guardado con exito :D", Alert.SUCCESS);

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alert = new Alert("<b>" + r.getNombre() + "</b>, el nombre de rol ya existe en la BBDD", Alert.WARNING);
		} catch (SQLException e) {
			
			if (e.getMessage().contains("nombre")) {
				alert = new Alert("El nombre es demasiado largo. :(", Alert.WARNING);
			}
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}

		view = VIEW_FORMULARIO;
		request.setAttribute("rol", r);

	}

	private void irFormulario(HttpServletRequest request) throws Exception {

		Rol r = new Rol();

		if (Integer.parseInt(id) > 0) {
			r = daoRol.getById(id);
		}

		request.setAttribute("rol", r);

		view = VIEW_FORMULARIO;
	}

	private void eliminar(HttpServletRequest request) throws Exception {

		// TODO para despues del cafe gestionar esta exception
		if (daoRol.delete(id)) {

			alert = new Alert();
			alert.setTipo(Alert.SUCCESS);
			alert.setTexto("Se ha borrado el rol de la BBDD");

		} else {

			alert = new Alert();
			alert.setTexto("Nose ha podido borrar el rol.");

		}

		listar(request);

	}
}
