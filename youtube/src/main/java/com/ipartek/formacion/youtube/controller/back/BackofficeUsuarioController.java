package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet(description = "Para la gestion de usuarios", urlPatterns = { "/backoffice/usuario" })
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UsuarioDAO daoUsuario;

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_LISTADO = "usuario/index.jsp";
	private static final String VIEW_FORMULARIO = "usuario/form.jsp";
	private String view;
	private Alert alert;

	private String op; // operacion a realizar
	private String id;
	private String nombre;
	private String contrasenya;
	private String rol;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();

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
			if (OP_ELIMINAR.equals(op)) {
				response.sendRedirect(request.getContextPath()+"/backoffice/usuario?op="+OP_LISTAR);
			}else{
				request.getRequestDispatcher(view).forward(request, response);
			}
			

		}

	}

	private void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		contrasenya = request.getParameter("contrasenya");
		rol = request.getParameter("rol");
		
	}

	private void listar(HttpServletRequest request) {
		
		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("usuarios", daoUsuario.getAll());
		request.setAttribute("nUsuario", daoUsuario.getAll().size());

	}

	private void guardar(HttpServletRequest request) {
		
		Usuario u = new Usuario();
		u.setId(Long.parseLong(id));
		u.setNombre(nombre);
		u.setContrasenya(contrasenya);
		u.setRol(Integer.parseInt(rol));

		if (u.getId() == 0) {// INSERT

			if (daoUsuario.insert(u)) {
				alert = new Alert();
				alert.setTipo(Alert.SUCCESS);
				alert.setTexto("El usuario creado con exito en la BBDD.");
			} else {
				alert = new Alert();
				alert.setTexto("El usuario no se ha podido crear por algun problema.");
			}

		} else { // UPDATE

			if (daoUsuario.update(u)) {
				alert = new Alert();
				alert.setTipo(Alert.SUCCESS);
				alert.setTexto("El usuario se ha modificado con exito en la BBDD.");
			} else {
				alert = new Alert();
				alert.setTexto("El usuario no se ha podido modificar por algun problema.");
			}
		}
		
		view = VIEW_FORMULARIO;
		request.setAttribute("usuario", u);

	}

	private void irFormulario(HttpServletRequest request) {
		
		Usuario u = new Usuario();

		if (Integer.parseInt(id) > 0) {
			u = daoUsuario.getById(id);
		}
		
		request.setAttribute("usuario", u);

		view = VIEW_FORMULARIO;
	}

	private void eliminar(HttpServletRequest request) {

		if (daoUsuario.delete(id)) {
			
			alert = new Alert();
			alert.setTipo(Alert.SUCCESS);
			alert.setTexto("Se ha borrado el usuario de la BBDD");
			
		} else {
			
			alert = new Alert();
			alert.setTexto("Nose ha podido borrar al usuario");
			
		}
		
		view = VIEW_LISTADO;

	}
}
