package com.ipartek.formacion.youtube.controller.back;

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

import com.ipartek.formacion.youtube.Usuario;
import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static UsuarioDAO dao;
	private static RolDAO daoRol;


	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_LISTADO = "usuario/index.jsp";
	private static final String VIEW_FORMULARIO = "usuario/formulario.jsp";

	private String view;
	private Alert alert;

	private String op; //
	private String id;
	private String nombre;
	private String password;
	private String rol;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = UsuarioDAO.getInstance();
		daoRol = RolDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// se ejecuta al parar el servidor
		dao = null;
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

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

	private void listar(HttpServletRequest request) throws Exception {
		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("usuarios", dao.getAll());

	}

	private void irFormulario(HttpServletRequest request) throws Exception {

		alert = null;
		view = VIEW_FORMULARIO;
		Usuario usuario = new Usuario();
		if (Integer.parseInt(id) > 0) {
			usuario = dao.getById(id);
		}
		request.setAttribute("roles", daoRol.getAll());
		request.setAttribute("usuario", usuario);
	}

	private void eliminar(HttpServletRequest request) throws Exception {
		try {
			
			alert = new Alert();
			alert.setTexto("Usuario Eliminado");
			alert.setTipo("alert-success");
			dao.delete(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			alert.setTipo("alert-danger");
			alert.setTexto("No podemos eliminar el usuario por que tiene videos creados");
		}
		
		view = VIEW_LISTADO;
		request.setAttribute("usuarios", dao.getAll());
	}
	// Todo para despues gestionar esta throws Exception

	private void guardar(HttpServletRequest request) throws Exception {
		Usuario u = new Usuario();

		
		try {
			
			u.setId(Long.parseLong(id));
			u.setNombre(nombre);
			u.setPassword(password);
			u.setRol(daoRol.getById(rol));
			
			if( u.getId() > 0 ) {			
				dao.update(u);				
			}else {                 
				dao.insert(u);				
			}			
			alert.setTexto("Usuario guardado");
			alert.setTipo("alert-success");
	
			
		// nombre repetido
		} catch ( SQLIntegrityConstraintViolationException e ) {
			e.printStackTrace();
			alert.setTipo("alert-danger");
			alert.setTexto("<b>" + u.getNombre() + " </b> El usuario ya existe!!!");
		
		//longitud campos nombre y password
		}catch (SQLException e) {
			e.printStackTrace();
			if ( e.getMessage().contains("nombre")) {
				alert.setTipo("alert-danger");
				alert.setTexto("El <b>nombre</b> debe ser inferior a 50 caracteres");
				
			}else {
				alert.setTipo("alert-danger");
				alert.setTexto("La <b>contraseña</b> debe ser inferior a 20 caracteres");
			}			
		}catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}	
		
		
		view = VIEW_FORMULARIO;
		request.setAttribute("usuario", u);
		request.setAttribute("roles", daoRol.getAll());
		
	}

	private void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		password = request.getParameter("password");
		rol = request.getParameter("rol");

	}

}