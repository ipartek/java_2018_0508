package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.RolDao;
import com.ipartek.formacion.youtube.model.UsuariosDaoJDBC;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuario")
public class BackofficeUsuarioControllerPuente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuariosDaoJDBC usuariosJDBC;
	private static RolDao rolDao;
	private ArrayList<Usuario> usuarios;
	private String view = "tree";

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	private static final String VIEW_LISTADO = "usuario/index.jsp";
	private String urlView;
	private Alert alert;

	private String op; // operacion a realizar
	private String id;
	private String nombre;
	private String password;
	private String rol;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		// inicializamos el arraydao de usuarios
		usuariosJDBC = UsuariosDaoJDBC.getInstance();
		rolDao = rolDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en doPost backofficeController");

		}

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			alert = new Alert();

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
			request.setAttribute("roles", rolDao.getAll());
			request.setAttribute("alert", alert);
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("view", view);
			request.getRequestDispatcher(urlView).forward(request, response);

		}

	}

	private void listar(HttpServletRequest request) throws Exception {
		usuarios = (ArrayList<Usuario>) usuariosJDBC.getAll();
		urlView = VIEW_LISTADO;
		if (view == null) {
			view = "tree";
		}

	}

	private void guardar(HttpServletRequest request) {
		System.out.println("Guardar");
		Usuario usuarioNuevoActualizar = new Usuario();
		try {
			if (id == null || id == "") { //registro nuevo
				if(nombre != "" && password!= "") {
					usuarioNuevoActualizar.setNombre(nombre);
					usuarioNuevoActualizar.setPass(password);
					usuarioNuevoActualizar.setRol(rolDao.getById( rol));
					usuariosJDBC.insert(usuarioNuevoActualizar);
							
				}
				

			} else {
				if(nombre != "" && password!= "") { //actualizar registro
					
					usuarioNuevoActualizar = usuariosJDBC.getById(id);
					usuarioNuevoActualizar.setNombre(nombre);
					usuarioNuevoActualizar.setPass(password);
					usuarioNuevoActualizar.setRol(rolDao.getById( rol));
					usuariosJDBC.update(usuarioNuevoActualizar);
					
					
				}
				
			}
			
			//nombre repetido
		}catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alert.setTexto("Error usuario duplicado");
		} 
		catch (SQLException e) {
			e.printStackTrace();
			if ( e.getMessage().contains("nombre")) {
				alert = new Alert(Alert.WARNING, "El <b>nombre</b> debe ser inferior a 50 caracteres");
			}else {
				alert = new Alert(Alert.WARNING, "La <b>contraseña</b> debe ser inferior a 20 caracteres");
			}					
		}catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
		
		//para que nos coja el registro recien actualizado/creado y lo ponemos en la vista formulario
		request.setAttribute("usuarioSeleccionado", usuarioNuevoActualizar);
		view = "form";

	}

	private void irFormulario(HttpServletRequest request) throws Exception{
		Usuario usuarioSeleccionado = new Usuario();
		urlView = VIEW_LISTADO;
		view = "form";
		if (id != null) {
			usuarioSeleccionado = usuariosJDBC.getById(id);
			request.setAttribute("usuarioSeleccionado", usuarioSeleccionado);
		}

	}

	private void eliminar(HttpServletRequest request) throws Exception {
		try {
			usuariosJDBC.delete(id);
			alert = new Alert(Alert.WARNING, "Usuario eliminado correctamente");
			listar(request);
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert(Alert.WARNING, "No podemos borrar un usuario con videos asociados");
		}
		

	}

	private void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("usuarioId");
		nombre = request.getParameter("nombre");
		password = request.getParameter("password");
		rol = request.getParameter("rol");
		view = request.getParameter("view");

	}

}
