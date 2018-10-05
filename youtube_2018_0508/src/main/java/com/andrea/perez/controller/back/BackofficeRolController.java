package com.andrea.perez.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.hibernate.validator.internal.xml.GetterType;

import com.andrea.perez.model.ComentarioArrayDAO;
import com.andrea.perez.model.RolDAO;
import com.andrea.perez.model.UsuarioDAO;
import com.andrea.perez.model.VideoDAO;
import com.andrea.perez.pojo.Alert;
import com.andrea.perez.pojo.Rol;
import com.andrea.perez.pojo.Usuario;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/roles")
public class BackofficeRolController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == "" o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	private static final String VIEW_LISTADO = "roles/index.jsp";
	private static final String VIEW_FORMULARIO = "roles/form.jsp";

	private String view;
	private Alert alert = null;

	private String op; // parametros necesarios
	private String id;
	private String nombre;

	private static RolDAO daoRol = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// Se ejecuta solo con la primera peticion. El resto van al service
		super.init(config);
		daoRol = RolDAO.getInstance();
	}

	@Override
	public void destroy() {
		// Se ejecuta al parar el servidor
		super.destroy();
		daoRol = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

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

	private void listar(HttpServletRequest request) throws Exception {

		view = VIEW_LISTADO;
		request.setAttribute("roles", daoRol.getAll());

	}

	private void guardar(HttpServletRequest request) {

		Rol rol = new Rol();

		
			rol.setId(Long.parseLong(id));
		
		
		rol.setNombre(nombre);

		try {
			if (!id.equals("")) { // MODIFICAR

				if (daoRol.update(rol)) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Rol modificado correctamente");
				}
			} else if (daoRol.insert(rol)) { // Insertar
				alert = new Alert(Alert.ALERT_SUCCESS, "Rol registrado correctamente");
			}
			// nombre repetido
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alert = new Alert(Alert.ALERT_WARNING, "<b>" + rol.getNombre() + " ya existe!!");

		} catch (SQLException e) { // Longitud nombre o pass mas largo de lo debido

			if (e.getMessage().contains("nombre")) {
				alert = new Alert(Alert.ALERT_WARNING,
						" superado  el maximo de caracteres permitido(50) para el nombre");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("rol", rol);
		view = VIEW_FORMULARIO;

	}

	private void irFormulario(HttpServletRequest request) throws Exception {
		Rol rol = null;
		if (Integer.parseInt(id) > 0) {
			rol = daoRol.getById(id);
		} else {
			rol = new Rol();
		}
		view = VIEW_FORMULARIO;
		request.setAttribute("rol", rol);
	}

	private void eliminar(HttpServletRequest request) throws Exception {

		if (id != null) {
			try {
				if (daoRol.delete(id)) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Se ha eliminado el rol");
				}

			} catch (Exception e) {

				e.printStackTrace();
				alert = new Alert(Alert.ALERT_WARNING, "No puedes eliminar un rol asociado a un usuario ");

			}
			view = VIEW_LISTADO;
			request.setAttribute("roles", daoRol.getAll());
		}
	}

	private void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");

	}

}
