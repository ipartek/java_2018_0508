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
import com.ipartek.formacion.youtube.pojo.Rol;

/**
 * Servlet implementation class BackofficeRolController
 */
@WebServlet("/backoffice/roles")
public class BackofficeRolController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	private static RolDAO daoRol;

	private static final String VIEW_LISTADO = "roles/index.jsp";
	private static final String VIEW_FORMUALRIO = "roles/formulario.jsp";
	private String view = "";
	private Alert alert;

	private String op;	//Operación a realizar
	private String id;
	private String nombre;

	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		daoRol = RolDAO.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
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
		
	}

	public void listar(HttpServletRequest request) throws Exception {

		try {
			view = VIEW_LISTADO;
			request.setAttribute("nRoles", daoRol.getAll().size());
			request.setAttribute("roles", daoRol.getAll());
			
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
	}

	public void guardar(HttpServletRequest request) {
		
	
			Rol rol = new Rol();

			rol.setId(Long.parseLong(id));
			rol.setNombre(nombre);
			
			try {
				if(rol.getId() == -1) {		//Crear nuevo rol
					
					daoRol.insert(rol);
					alert = new Alert(Alert.SUCCESS, "Rol <b>" + rol.getNombre() + "</b> creado con éxito");
					
				}else {		//Modificar rol existente
					
					daoRol.update(rol);
					alert = new Alert(Alert.SUCCESS, "Rol <b>" + rol.getNombre() + "</b> modificado con éxito");
				}
				
			//Nombre repetido
			}catch(SQLIntegrityConstraintViolationException e){
				e.printStackTrace();
				alert = new Alert(Alert.WARNING, "El rol <b>" + rol.getNombre() + "</b> ya existe.");
				
			//Longitud de campos nombre	
			}catch(SQLException e){
				
				alert = new Alert(Alert.WARNING, "El nombre debe contener como máximo 50 caracteres.");
				
			}catch (Exception e) {
				e.printStackTrace();
				alert = new Alert();
				
			}
			
			view = VIEW_FORMUALRIO;
			request.setAttribute("rol", rol);
		
	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		
		try {
			Rol rol = new Rol();
			
			if(Long.parseLong(id) >= 0) {
				rol = daoRol.getById(Long.parseLong(id));
			}
			
			request.setAttribute("rol", rol);
			view = VIEW_FORMUALRIO;
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
	}

	public void eliminar(HttpServletRequest request) throws Exception {

		try {
			
			//Eliminar
			Rol r  = daoRol.getById(Long.parseLong(id));
			if(daoRol.delete(Long.parseLong(id))) {
				alert = new Alert(Alert.SUCCESS, "Rol <b>" + r.getNombre() + "</b> eliminado correctamente");
					
			}else {
				alert = new Alert(Alert.WARNING, "No hemos podido eliminar el rol.");
			}
						
		} 
		
		catch (SQLIntegrityConstraintViolationException e) {
			alert = new Alert(Alert.WARNING, "No hemos podido eliminar el rol porque tiene usuarios asociados.");
		
		}catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
		listar(request);
		
	}

}
