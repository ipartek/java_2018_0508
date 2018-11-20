package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.RolDao;
import com.ipartek.formacion.youtube.pojo.Rol;


/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/rol")
public class BackofficeRolController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	private static RolDao rolDao;
	private ArrayList<Rol> roles;
	private String view = "tree";

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	private static final String VIEW_LISTADO = "rol/index.jsp";
	private String urlView;
	private Alert alert;

	private String op; // operacion a realizar
	private String id;
	private String nombre;


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		// inicializamos el arraydao de usuarios
		rolDao = RolDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en doPost backofficeController");

		}

	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
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
			request.setAttribute("alert", alert);
			request.setAttribute("roles", roles);
			request.setAttribute("view", view);
			request.getRequestDispatcher(urlView).forward(request, response);

		}

	}

	public void listar(HttpServletRequest request) throws Exception {
		roles = (ArrayList<Rol>) rolDao.getAll();
		urlView = VIEW_LISTADO;
		if (view == null) {
			view = "tree";
		}

	}

	public void guardar(HttpServletRequest request) {
		System.out.println("Guardar");
		Rol rolNuevoActualizar = new Rol();
		try {
			if (id == null || id == "") { //registro nuevo
				if(nombre != "" ) {
					rolNuevoActualizar.setNombre(nombre);

					/*usuarioNuevoActualizar.setRol(Integer.parseInt(rol));*/
					rolDao.insert(rolNuevoActualizar);
							
				}
				

			} else {
				if(nombre != "" ) { //actualizar registro
					
					rolNuevoActualizar = rolDao.getById(id);
					rolNuevoActualizar.setNombre(nombre);

					/*usuarioNuevoActualizar.setRol(Integer.parseInt(rol));*/
					rolDao.update(rolNuevoActualizar);
					
					
				}
				
			}
			
			//nombre repetido
		/*}catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alert.setTexto("Error usuario duplicado");
		} 
		catch (SQLException e) {
			e.printStackTrace();
			if ( e.getMessage().contains("nombre")) {
				alert = new Alert(Alert.WARNING, "El <b>nombre</b> debe ser inferior a 50 caracteres");
			}else {
				alert = new Alert(Alert.WARNING, "La <b>contraseña</b> debe ser inferior a 20 caracteres");
			}					*/
		}catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
		
		//para que nos coja el registro recien actualizado/creado y lo ponemos en la vista formulario
		request.setAttribute("rolNuevoActualizar", rolNuevoActualizar);
		view = "form";

	}

	public void irFormulario(HttpServletRequest request) throws Exception{
		Rol rolSeleccionado = new Rol();
		urlView = VIEW_LISTADO;
		view = "form";
		if (id != null) {
			rolSeleccionado = rolDao.getById(id);
			request.setAttribute("rolSeleccionado", rolSeleccionado);
		}

	}

	public void eliminar(HttpServletRequest request) throws Exception {
		try {
			getParameters(request);
			rolDao.delete(id);
			alert = new Alert(Alert.WARNING, "rol eliminado correctamente");
			listar(request);
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert(Alert.WARNING, "No podemos borrar un rol con Usuario asociaados");
		}
		

	}

	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");

		view = request.getParameter("view");

	}

}
