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
public class BackofficeUsuarioController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario;
	private static RolDAO daoRol;
	
	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2";	//insert (id == -1) o update (id > 0) dependiendo del id
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	
	private static final String VIEW_LISTADO = "usuarios/index.jsp";
	private static final String VIEW_FORMUALRIO = "usuarios/formulario.jsp";
	private String view = "";
	private Alert alert;
	
	private String op;	//Operación a realizar
	private String id;
	private String nombre;
	private String pass;
	private String rol;


	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		daoUsuario = UsuarioDAO.getInstance();
		daoRol = RolDAO.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
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
			
			alert = null;
			
			getParameters(request,response);
			
			//Buscar operación a realizar
			
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
			
		}finally {
			//Vas a algún lao
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
			
		}
	
	}

	public void getParameters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		op = (request.getParameter("op") != null)?request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");		
		pass = request.getParameter("pass");		
		rol = request.getParameter("rol");
		
	}

	public void listar(HttpServletRequest request) throws Exception {

		try {
			view = VIEW_LISTADO;
			request.setAttribute("nUsuarios", daoUsuario.getAll().size());
			request.setAttribute("usuarios", daoUsuario.getAll());
			
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
	}

	public void guardar(HttpServletRequest request) throws Exception {
		
		Usuario usuario = new Usuario();
			
		try {
			usuario.setId(Long.parseLong(id));
			usuario.setNombre(nombre);
			usuario.setPass(pass);
			usuario.setRol(daoRol.getById(Long.parseLong(rol)));
				
			if(usuario.getId() == -1) {	//Crear nuevo usuario
						
				daoUsuario.insert(usuario);
				alert = new Alert(Alert.SUCCESS, "Usuario <b>" + usuario.getNombre() + "</b> creado con éxito");
						
			}else {		//Modificar usuario existente
						
				daoUsuario.update(usuario);
				alert = new Alert(Alert.SUCCESS, "Usuario <b>" + usuario.getNombre() + "</b> modificado con éxito");
						
			}
				
		//Nombre repetido
		}catch(SQLIntegrityConstraintViolationException e){
			e.printStackTrace();
			alert = new Alert(Alert.WARNING, "El usuario <b>" + usuario.getNombre() + "</b> ya existe.");
				
		//Longitud de campos nombre y password
				
		}catch(SQLException e){
				
			if(e.getMessage().contains("nombre")) {
				alert = new Alert(Alert.WARNING, "El nombre debe contener como máximo 50 caracteres.");
			}
			else if(e.getMessage().contains("password")) {
					alert = new Alert(Alert.WARNING, "La contraseña debe contener como máximo 20 caracteres.");
			}
			
			e.printStackTrace();
				
		}catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
				
		}
			
		view = VIEW_FORMUALRIO;
		request.setAttribute("usuario", usuario);
		request.setAttribute("roles", daoRol.getAll());
		
	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		
		try {
			Usuario usuario = new Usuario();
			
			if(Integer.parseInt(id) > 0) {
				usuario = daoUsuario.getById(Long.parseLong(id));
			}
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("roles", daoRol.getAll());
			view = VIEW_FORMUALRIO;
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
	}

	public void eliminar(HttpServletRequest request) throws Exception {

		try {
			if(id != null && op != null && OP_ELIMINAR.equals(op)) {	//Eliminar
				Usuario u  = daoUsuario.getById(Long.parseLong(id));
				if(daoUsuario.delete(Long.parseLong(id))) {
					alert = new Alert(Alert.SUCCESS, "Usuario <b>" + u.getNombre() + "</b> eliminado correctamente");
					
				}else {
					alert = new Alert(Alert.WARNING, "No hemos podido eliminar el usuario");
				}
				
			}			
		} 
		
		catch (SQLIntegrityConstraintViolationException e) {
			alert = new Alert(Alert.WARNING, "No se puede eliminar el usuario, ya que tiene uno o más videos creados.");
		
		}catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
		listar(request);
		
	}
	
	
}
