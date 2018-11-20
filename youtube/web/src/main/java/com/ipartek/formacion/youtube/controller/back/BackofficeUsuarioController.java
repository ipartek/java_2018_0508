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

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet implements CrudControllable{
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario = null;
	private static RolDAO daoRol = null;
	
	private static final String VIEW_LISTADO = "usuarios/index.jsp";
	private static final String VIEW_FORMULARIO = "usuarios/form.jsp";
	private String view;
	private Alert alert;
	
	private String op; //operacion a realizar
	private String id;
	private String nombre;
	private String password;
	private String rol;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
		daoRol = RolDAO.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		daoUsuario = null;
		daoRol = null;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doProcess(request, response);		
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

			default:  //LISTAR
				listar(request);
				break;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			view = VIEW_LISTADO;
			alert = new Alert();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
			
		}
		
	}

	public void listar(HttpServletRequest request) throws Exception {
		
		alert = null;		
		view = VIEW_LISTADO;
		
		int totalUsuarios=daoUsuario.getAll().size();
		
		request.setAttribute("totalUsuarios", totalUsuarios);	
		request.setAttribute("usuarios", daoUsuario.getAll());		
		
	}

	public void guardar(HttpServletRequest request) {
		Usuario u = new Usuario();
		
		try {
			
			u.setId(Long.parseLong(id));
			u.setNombre(nombre);
			u.setPassword(password);		
			u.setRol( daoRol.getById(Long.parseLong(rol)) );
		
		
			if( u.getId() > 0 ) {			
				daoUsuario.update(u);				
			}else {                 
				daoUsuario.insert(u);				
			}			
			alert = new Alert(Alert.SUCCESS, "Usuario guardado con exito");	
	
		
		
			
		// nombre repetido
		} catch ( SQLIntegrityConstraintViolationException e ) {
			e.printStackTrace();
			alert = new Alert(Alert.WARNING, "<b>" + u.getNombre() +  "</b> ya existe !!!" );
		
		//longitud campos nombre y password
		}catch (SQLException e) {
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
		
		
		view = VIEW_FORMULARIO;
		request.setAttribute("usuario", u);
		
		try {
			request.setAttribute("roles", daoRol.getAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		alert = null;
		view = VIEW_FORMULARIO;
		if ( id.equalsIgnoreCase("-1")) {
			request.setAttribute("usuario", new Usuario() );
		}else {			
			request.setAttribute("usuario", daoUsuario.getById( Long.parseLong(id)));
		}
		
		request.setAttribute("roles", daoRol.getAll() );
	}

	
	public void eliminar(HttpServletRequest request) throws Exception {
		
		try {
			daoUsuario.delete(Long.parseLong(id));
			alert = new Alert(Alert.SUCCESS, "Usuario Eliminado");
		}catch (Exception e) {
			alert = new Alert(Alert.WARNING, "No podemos eliminar el usuario porque tiene videos creados");
		}	
		view = VIEW_LISTADO;
		request.setAttribute("usuarios", daoUsuario.getAll());	
		
	}

	public void getParameters(HttpServletRequest request) {
		
		op = ( request.getParameter("op") != null ) ? request.getParameter("op") : OP_LISTAR;		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		password = request.getParameter("password");
		rol = request.getParameter("rol");
	}
}