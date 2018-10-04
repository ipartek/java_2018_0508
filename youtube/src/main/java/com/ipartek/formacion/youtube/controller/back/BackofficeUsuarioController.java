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
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario;
	
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
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		daoUsuario = null;
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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
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

	private void getParameters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		op = (request.getParameter("op") != null)?request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");

		if(id != null && Integer.parseInt(id) == 1 && OP_ELIMINAR.equals(op)) {
			alert = new Alert(Alert.DANGER, "El usuario admin no puede ser eliminado");
			op = OP_LISTAR;
		}
		if(nombre != null && nombre.length() > 50) {
			alert = new Alert(Alert.DANGER, "El nombre debe contener como máximo 50 caracteres");
			op = OP_IR_FORMULARIO;
		}
		
		pass = request.getParameter("pass");
		
		if(pass != null && pass.length() > 20) {
			alert = new Alert(Alert.DANGER, "La contraseña debe contener como máximo 20 caracteres");
			op = OP_IR_FORMULARIO;
		}
		
		rol = request.getParameter("rol");
		
	}

	private void listar(HttpServletRequest request) {

		try {
			view = VIEW_LISTADO;
			request.setAttribute("nUsuarios", daoUsuario.getAll().size());
			request.setAttribute("usuarios", daoUsuario.getAll());
			
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
	}

	private void guardar(HttpServletRequest request) {
		
		try {
			Usuario usuario = new Usuario();

			usuario.setId(Long.parseLong(id));
			usuario.setNombre(nombre);
			usuario.setPass(pass);
			usuario.setRol(Integer.parseInt(rol));
			
			if(Long.parseLong(id) == -1) {	//Crear nuevo usuario
				
				daoUsuario.insert(usuario);
				alert = new Alert(Alert.SUCCESS, "Usuario <b>" + usuario.getNombre() + "</b> creado con éxito");
				listar(request);
				
			}else {		//Modificar usuario existente
				
				daoUsuario.update(usuario);
				alert = new Alert(Alert.SUCCESS, "Usuario <b>" + usuario.getNombre() + "</b> modificado con éxito");
				listar(request);
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
	}

	private void irFormulario(HttpServletRequest request) {
		
		try {
			Usuario usuario = new Usuario();
			
			if(Integer.parseInt(id) > 0) {
				usuario = daoUsuario.getById(Long.parseLong(id));
			}
			
			request.setAttribute("usuario", usuario);
			view = VIEW_FORMUALRIO;
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
	}

	private void eliminar(HttpServletRequest request) {

		try {
			if(id != null && op != null && OP_ELIMINAR.equals(op)) {	//Eliminar
				Usuario u  = daoUsuario.getById(Long.parseLong(id));
				daoUsuario.delete(Long.parseLong(id));
				alert = new Alert(Alert.SUCCESS, "Usuario <b>" + u.getNombre() + "</b> eliminado correctamente");
				listar(request);
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
	}
	
	
}
