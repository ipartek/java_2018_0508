package com.ipartek.formacion.controller.back;

import java.io.IOException;
import java.util.ArrayList;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		daoUsuario = UsuarioDAO.getInstance();
		//try catch y mensajes para el usuario
//		ArrayList<Usuario> usuarios = getMockUsers();
		
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
		
		String id = request.getParameter("id");
		
		try {
			if(id == null) {
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher(VIEW_INDEX_USUARIOS).forward(request, response);
			}else {
				Usuario usuario = new Usuario();
				if(Integer.parseInt(id)>0) {
					usuario = daoUsuario.getById(id);
				}
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher(VIEW_FORM_USUARIOS).forward(request, response);
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
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		String rol = request.getParameter("rol");
		
		//Parametro que indica si se esta creando o modificando un usuario. 0 = crear, 1 = modificar
		String op = request.getParameter("op");
		
		try {			
			if(nombre != null && contrasena != null) {
				if(nombre.length() <= 50) {
					if(contrasena.length() <= 20) {
						
						usuario = new Usuario();
						usuario.setNombre(nombre);
						usuario.setContrasena(contrasena);
						usuario.setRol(Integer.parseInt(rol));
						
						if(op.equals("0")) {
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

//	private ArrayList<Usuario> getMockUsers(){
//		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//		for(int i=1;i<=100;i++) {
//			Usuario u = new Usuario("nombre"+i, "123456");
//			u.setId(i);
//			if(u.getId() == 1) {
//				u.setRol(Usuario.ROL_ADMIN);
//			}
//			usuarios.add(u);
//		}
//		return usuarios;
//	}
}
