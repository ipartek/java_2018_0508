package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
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
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarioDeshabilitado")
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuariosDaoJDBC usuariosJDBC;
	private ArrayList<Usuario> usuarios;
	private static RolDao rolDao;
	private ArrayList<Rol> roles;
	private String view = "tree";
	
	
	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2";  //insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	private static final String VIEW_LISTADO = "usuarios/index.jsp";
	private static final String VIEW_FORMULARIO = "usuarios/form.jsp";
	private String urlView;
	private Alert alert;
	
	private String op; //operacion a realizar
	private String id;
	private String nombre;
	private String password;
	private String rol;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		//inicializamos el arraydao de usuarios
		usuariosJDBC =  UsuariosDaoJDBC.getInstance();
		rolDao = rolDao.getInstance();
	}
	
	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String view = request.getParameter("view");
			usuarios = (ArrayList<Usuario>) usuariosJDBC.getAll();
			String id = request.getParameter("usuarioId");
			String accion = request.getParameter("accion");
			String idEliminar = request.getParameter("idEliminar");
			String op = request.getParameter("op");
			Usuario usuarioSeleccionado = new Usuario();
			int idInt = 0;
			
			
/*			if (accion != null) {
				idInt = Integer.parseInt(id);
				if("menos".contentEquals(accion)) {
					System.out.println("usuario menos");
					
					//usuarioSeleccionado = usuarios.get
					//usuarioSeleccionado = usuariosJDBC.getById(id);
				}
				if("mas".contentEquals(accion)) {
					System.out.println("usuario mas");
					usuarioSeleccionado = usuarios.get(idInt+1);
				}
				if(usuarioSeleccionado == null) {
					usuarioSeleccionado = usuariosJDBC.getById(id);
				}
				view = "form";
			}*/
			if(op != null && idEliminar != null) {
				usuariosJDBC.delete(idEliminar);
				
			}
			if(usuarios != null) {
				request.setAttribute("usuarios", usuarios);

			}
			if (view == null) {
				view = "tree";
			}
			//Si viene id automaticamente cambiamos a vista formulario
			if(id != null && accion == null) {
				view = "form";
				usuarioSeleccionado = usuariosJDBC.getById(id);
				/*if("".contentEquals(usuarioSeleccionado.getNombre())){
					usuarioSeleccionado = null;
				}*/
			}
			request.setAttribute("usuarioSeleccionado",usuarioSeleccionado);
			request.setAttribute("view", view);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//response.sendRedirect( "usuario/index.jsp" ); 
			request.getRequestDispatcher("usuario/index.jsp").forward(request, response);
		}
		
	}

/*	private Object getUsuariosVirtuales() {
		Usuario user = new Usuario();
		ArrayList<Usuario> usuariosVirtuales = new ArrayList<Usuario>();
		for(int i = 1; i <= 100;i++) {
			user.setId(i);
			user.setNombre("usuario"+i);
			usuariosVirtuales.add(user);
		}
		return usuariosVirtuales;
	}*/


	private String setView(String treeView, String formView, String kanbanView) {
		if(treeView != null) {
			view = "treeView"; 
		}
		if(formView != null) {
			view = "formView"; 
		}
		if(kanbanView != null) {
			view = "kanbanView"; 
		}
		return view;
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Usuario usuario = null;
			String usuarioId = request.getParameter("usuarioId");
			String nombreUsuario = request.getParameter("nombreUsuario");
			String passwordUsuario = request.getParameter("passwordUsuario");
			//String rol = request.getParameter("rol");
			
			
			
			if(nombreUsuario != null && passwordUsuario != null && usuarioId == null) {
				/*if (rol != null) {
					int intRol = Integer.parseInt(rol);*/
					usuario = new Usuario(nombreUsuario,passwordUsuario);
					//usuarios.add(usuario);
					usuariosJDBC.insert(usuario);
				/*}*/
				
			}
			if(nombreUsuario != null && passwordUsuario != null && usuarioId != null) {
				/*if (rol != null) {*/
					int intId = Integer.parseInt(usuarioId);
					usuario = new Usuario(intId,nombreUsuario,passwordUsuario,new Rol(2,"usuario"));
					//usuarios.add(usuario);
					usuariosJDBC.update(usuario);
				/*}*/
				
			}
			
			request.setAttribute("roles",rolDao.getAll() );
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("usuario/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en doPost backofficeController");
			//response.sendRedirect( "usuario/index.jsp" ); 
			request.getRequestDispatcher("usuario/index.jsp").forward(request, response);
		}
		
		
		
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getParameters();
	}




	private void getParameters() {
		
		
	}

}
