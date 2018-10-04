package com.ipartek.formacion.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.UsuarioDAO;
import com.ipartek.formacion.pojo.Alert;
import com.ipartek.formacion.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static UsuarioDAO daoUsuario;
	
	private static final String VIEW_FORM_USUARIOS = "usuarios/form.jsp";
	private static final String VIEW_INDEX_USUARIOS = "usuarios/index.jsp";
	
	public static final String OP_ELIMINAR = "1";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alert alert = null;
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		String id = request.getParameter("id");
		String op = request.getParameter("op");
		
		try {
			
			if(id!=null && op != null && op.equals(OP_ELIMINAR)){ /*Eliminar*/
				System.out.println("Borrando...");
				if(daoUsuario.delete(id)) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Usuario borrado con éxito.");
				}else {
					alert = new Alert(Alert.ALERT_DANGER, "No se ha podido crear el usuario.");
				}
				
				usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher(VIEW_INDEX_USUARIOS).forward(request, response);
			}else {
				if(id == null) { /*Mostrar listado de usuarios cuando no llega ningun id*/
					usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
					if(usuarios.size() == 0) {
						alert = new Alert(Alert.ALERT_WARNING, "No se han encontrado usuarios.");
						request.setAttribute("alert", alert);
					}
					request.setAttribute("usuarios", usuarios);
					request.getRequestDispatcher(VIEW_INDEX_USUARIOS).forward(request, response);
				}else { /*Cuando llega un id -1 o id > 0 cargar el formulario vacio o con datos usuario de dicho id*/
					Usuario usuario = new Usuario();
					if(Integer.parseInt(id)>0) {
						usuario = daoUsuario.getById(id);
					}
					request.setAttribute("usuario", usuario);
					request.getRequestDispatcher(VIEW_FORM_USUARIOS).forward(request, response);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alert alert = null;
		Usuario usuario = null;
		String view = VIEW_FORM_USUARIOS;
		
		daoUsuario = UsuarioDAO.getInstance();
		
		//Recoger parametros
		String id = request.getParameter("id"); // 0 = crear, 1 = modificar
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		String rol = request.getParameter("rol");
		
		//Parametro que indica si se esta creando o modificando un usuario.
		
		try {			
			if(nombre != null && contrasena != null) {
				if(nombre.length() <= 50) {
					if(contrasena.length() <= 20) {
						
						usuario = new Usuario();
						usuario.setNombre(nombre);
						usuario.setContrasena(contrasena);
						usuario.setRol(Integer.parseInt(rol));
						
						if(id.equals("-1")) {
							//Crear Usuario nuevo
							if(daoUsuario.insert(usuario)) {
								alert = new Alert(Alert.ALERT_SUCCESS, "Usuario creado con éxito.");
							}else {
								alert = new Alert(Alert.ALERT_DANGER, "No se ha podido crear el usuario.");
							}
						}else{
							//Modificar Usuario existente
							usuario.setId(Long.parseLong(id));
							if(daoUsuario.update(usuario)) {
								alert = new Alert(Alert.ALERT_SUCCESS, "Usuario modificado con éxito.");
							}else {
								alert = new Alert(Alert.ALERT_DANGER, "No se ha podido modificar el usuario.");
							}
						}
					}else {
						alert = new Alert(Alert.ALERT_WARNING, "La contraseña no puede tener más de 20 caracteres.");
					}
				}else {
					alert = new Alert(Alert.ALERT_WARNING, "El nombre de usuario no puede tener más de 50 caracteres.");
				}
			}else {
				alert = new Alert(Alert.ALERT_DANGER, "Debe rellenar todos los campos.");
			}

			request.setAttribute("alert", alert);
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher(view).forward(request, response);

		}catch(Exception e) {
			e.printStackTrace();
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error inesperado.");
		}
		
	}
}
