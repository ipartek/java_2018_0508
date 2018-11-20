package com.ipartek.formacion.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.model.RolDAO;
import com.ipartek.formacion.pojo.Rol;

/**
 * Servlet implementation class BackofficeRolController
 */
@WebServlet("/backoffice/roles")
public class BackofficeRolController extends HttpServlet implements CrudControllable{
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_FORM_ROLES = "roles/form.jsp";
	private static final String VIEW_INDEX_ROLES = "roles/index.jsp";
	
	private String view = "";
	private Alert alert = null;
	
	private static RolDAO daoRol = null;
		
	//Parametros
	private String op; //Operacion a realizar
	private String id; //Id del rol
	private String nombre; //Nombre del rol
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoRol = RolDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
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

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			alert=null;
			
			//Recoge los parametros de la request y los guarda en variables
			getParameters(request);
			
			//Dependiendo del valor del parametro op hace una funcion u otra
			switch (op) {
				case OP_ELIMINAR:
					eliminar(request); //Elimina un usuario de la bbdd
					break;
					
				case OP_GUARDAR:
					guardar(request); //Crea o modifica un usuario en la bbdd
					break;
					
				case OP_IR_FORMULARIO:
					irFormulario(request); //Cambia a la vista del formulario de gestion de usuario
					break;
	
				default: //Listar
					listar(request); //Cambia a la vista de listado de usuarios
					break;
			}
		}catch(Exception e) {
			e.printStackTrace();
			view = VIEW_INDEX_ROLES;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	@Override
	public void listar(HttpServletRequest request){
		try {
			view = VIEW_INDEX_ROLES;
			request.setAttribute("roles", daoRol.getAll());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception{
		Rol rol = null;
		if(Integer.parseInt(id)>0) {
			rol = daoRol.getById(id);
		}else {
			rol = new Rol();
		}
		request.setAttribute("rol", rol);
		view = VIEW_FORM_ROLES;
	}

	@Override
	public void guardar(HttpServletRequest request) {
		Rol rol = null;
		
		rol = new Rol();
		rol.setNombre(nombre);
		
		try {
			if(id.equals("")) {
				//Crear Rol nuevo
				daoRol.insert(rol);
			}else{
				//Modificar Rol existente
				rol.setId(Long.parseLong(id));
				daoRol.update(rol);
			}
			alert = new Alert(Alert.ALERT_SUCCESS, "Usuario guardado con éxito.");
			
		}
		//Nombre repetido
		catch(SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alert = new Alert(Alert.ALERT_WARNING, "El nombre de rol <b>" + rol.getNombre() + "</b> ya existe.");
		}
		//Longitud campo nombre
		catch(SQLException e) {
			e.printStackTrace();
			if(e.getMessage().contains("nombre")) {
				alert = new Alert(Alert.ALERT_WARNING, "El nombre del rol debe tener máx. 50 caracteres.");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("rol", rol);
		view = VIEW_FORM_ROLES;
	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		try {
			daoRol.delete(id);
			alert = new Alert(Alert.ALERT_SUCCESS, "Rol borrado con éxito.");
		}catch(Exception e) {
			e.printStackTrace();
			alert = new Alert(Alert.ALERT_WARNING, "No se puede borrar el rol porque tiene usuarios asociados.");
		}
		view = VIEW_INDEX_ROLES;
		request.setAttribute("roles", daoRol.getAll());
	}

	@Override
	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op"): OP_LISTAR; 
		id = request.getParameter("id"); // 0 = crear, 1 = modificar
		nombre = request.getParameter("nombre");
	}

}
