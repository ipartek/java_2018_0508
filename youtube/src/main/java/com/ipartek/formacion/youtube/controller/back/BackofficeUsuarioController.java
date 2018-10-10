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

import com.ipartek.formacion.youtube.controller.CrudControllable;
import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet implements CrudControllable {

	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario = null;
	private static RolDAO daoRol = null;

	private static final String VIEW_LISTADO = "usuarios/index.jsp";
	private static final String VIEW_FORMULARIO = "usuarios/form.jsp";

	private String view;
	private Alert alerta;

	private String op;// operacion a realizar
	private String id;
	private String nombre;
	private String password;
	private String rol;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
		daoRol=RolDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoUsuario = null;
		daoRol = null;
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
			alerta = new Alert();
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

			alerta = new Alert();
		} finally {

			request.setAttribute("alert", alerta);
			request.getRequestDispatcher(view).forward(request, response);
			
			try {
				listar(request);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	}

	public void guardar(HttpServletRequest request) throws Exception {
		Usuario usuario = new Usuario();
		try {

			usuario.setId(Long.parseLong(id));
			usuario.setNombre(nombre);
			usuario.setPass(password);
			usuario.setRol(daoRol.getById(Long.parseLong(rol)));

			if (usuario.getId() > 0) {
				daoUsuario.update(usuario);
				alerta = new Alert(Alert.SUCCESS, "Usuario " + usuario.getNombre() + " actualizado correctamente");
			} else {
				daoUsuario.insert(usuario);
				alerta = new Alert(Alert.SUCCESS, "Usuario " + usuario.getNombre() + " añadido correctamente");
			}

			

		} catch (SQLIntegrityConstraintViolationException e) {// nombre repetido
			e.printStackTrace();
			alerta = new Alert(Alert.WARNING, "El Usuario " + usuario.getNombre() + " ya existe!!");
		} catch (SQLException e) {
			if (e.getMessage().contains("nombre")) {
				alerta = new Alert(Alert.WARNING, "El nombre de usuario debe ser inferior a 50 caracteres");

			} else {
				alerta = new Alert(Alert.WARNING, "El password de usuario debe ser inferior a 50 caracteres");

			}

		} catch (Exception e) {
			e.printStackTrace();
			alerta = new Alert();
			// longitud de campos nombre y password

		}
		view = VIEW_FORMULARIO;
		request.setAttribute("usuario", usuario);
		request.setAttribute("roles", daoRol.getAll());
	}

	public void listar(HttpServletRequest request) throws Exception {
		alerta = null;
		view = VIEW_LISTADO;
		int numUsuarios = daoUsuario.getAll().size();
		request.setAttribute("usuarios", daoUsuario.getAll());
		request.setAttribute("numUsuarios", numUsuarios);
	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		alerta = null;
		view = VIEW_FORMULARIO;
		if (id.equalsIgnoreCase("-1")) {
			request.setAttribute("usuario", new Usuario());
		} else {

			request.setAttribute("usuario", daoUsuario.getById(Long.parseLong(id)));
			
		}
		request.setAttribute("roles", daoRol.getAll());
	}

	public void eliminar(HttpServletRequest request) throws Exception {
		view = VIEW_LISTADO;

		try {
			Usuario u = daoUsuario.getById(Long.parseLong(id));
			daoUsuario.delete(Long.parseLong(id));
			alerta = new Alert(Alert.SUCCESS, "Usuario " + u.getNombre() + " eliminado correctamente");
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alerta = new Alert(Alert.WARNING, "El usuario que intenta eliminar tiene videos asociados");
		} catch (Exception e) {
			e.printStackTrace();
			alerta = new Alert();
		}

		request.setAttribute("usuarios", daoUsuario.getAll());

	}

	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		password = request.getParameter("pass");
		rol = request.getParameter("rol");
	}
}