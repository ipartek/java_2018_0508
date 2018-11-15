package com.ipartek.formacion.prestamos_libros.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.prestamos_libros.model.UsuarioDAO;
import com.ipartek.formacion.prestamos_libros.pojo.Alert;
import com.ipartek.formacion.prestamos_libros.pojo.Usuario;
import com.ipartek.formacion.prestamos_libros.service.ServiceUsuario;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/backoffice/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceUsuario usuarioService;
	

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == null o update id != null
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_LISTADO = "usuarios/usuarios.jsp";
	private static final String VIEW_FORMULARIO_USUARIO = "usuarios/formAltaModUsuario.jsp";

	private String view;
	private Alert alert;

	private String op; // operacion a realizar
	private String id;
	private String nombre_apellidos;

	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		usuarioService = new ServiceUsuario();

	}

	public void destroy() {
		usuarioService = null;
		
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
		List<Usuario> usuarios = usuarioService.listar();
		request.setAttribute("usuarios", usuarios);
		view = VIEW_LISTADO;

	}

	private void guardar(HttpServletRequest request) throws Exception {
		Usuario u = new Usuario();
		u.setNombre_apellidos(nombre_apellidos);

		try {
		
			if(!"".equals(id)) {
				//modificar
				u.setId(new Long(id));
				if(!usuarioService.modificar(u)){
					alert = new Alert(alert.SUCCESS, "Usuario modificado correctamente.");
				}else{
					alert = new Alert(alert.DANGER, "El usuario no se ha podido modificar.");
				}
			}else {
				//añadir
				if(!usuarioService.crear(u)){
					alert = new Alert(alert.SUCCESS, "Usuario creado correctamente.");
				}else{
					alert = new Alert(alert.DANGER, "El usuario no se ha podido crear.");
				}
			}
		
		}catch(SQLIntegrityConstraintViolationException x) {
			x.printStackTrace();
			alert = new Alert(alert.DANGER, "El nombre del usuario no puede estar repetido.");
		}catch(Exception f) {
			f.printStackTrace();
			alert = new Alert();
		}
		
		List<Usuario> usuarios = usuarioService.listar();
		request.setAttribute("usuarios", usuarios);
		view = VIEW_LISTADO;

	}

	private void irFormulario(HttpServletRequest request) throws Exception {
		if(id!=null) {
			//modificar
			Usuario usuario = usuarioService.buscarId(Long.parseLong(id));
			
			request.setAttribute("usuario", usuario);
			
		}

		view = VIEW_FORMULARIO_USUARIO;
	}

	private void eliminar(HttpServletRequest request) throws Exception {
		try {
			
			if(!usuarioService.eliminar(Long.parseLong(id))){
				alert = new Alert(alert.SUCCESS, "Usuario eliminado correctamente.");
			}else{
				alert = new Alert(alert.DANGER, "El usuario no se ha podido eliminar.");
			}
			
		}catch(SQLIntegrityConstraintViolationException w) {
			w.printStackTrace();
			alert = new Alert(alert.DANGER, "No se puede eliminar un usuario que tenga un libro prestado.");
		}catch(Exception c) {
			c.printStackTrace();
		}
	
		List<Usuario> usuarios = usuarioService.listar();
		request.setAttribute("usuarios", usuarios);
		view = VIEW_LISTADO;
	}

	private void getParameters(HttpServletRequest request) {

		op = request.getParameter("op");
		if(op == null) {
			op = OP_LISTAR;
		}
		id = request.getParameter("id");
		nombre_apellidos = request.getParameter("nombre_apellidos");

	}

}
