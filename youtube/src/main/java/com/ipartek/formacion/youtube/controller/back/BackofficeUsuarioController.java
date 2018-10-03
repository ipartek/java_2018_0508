package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

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
	private static final int OP_ELIMINAR = 1;


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
		
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
		Alert alert = null;
		String view = "usuarios/index.jsp";
		
		try {
			String id = request.getParameter("id");
			String op = request.getParameter("op");
			
			if(id == null) {
				request.setAttribute("usuarios", usuarios);
				
			}else {
				Usuario usuario = new Usuario();
				
				if(Integer.parseInt(id) > 0) {
					usuario = daoUsuario.getById(Long.parseLong(id));
				}
				
				request.setAttribute("usuario", usuario);
				view = "usuarios/formulario.jsp";
				
				if(op != null && Integer.parseInt(op) == 1) {
				Usuario u = daoUsuario.getById(Long.parseLong(id));
				
				if(daoUsuario.delete(u.getId())) {
					alert = new Alert(Alert.SUCCESS, "Usuario eliminado correctamente");
					
					usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
					request.setAttribute("alert", alert);
					request.setAttribute("usuarios", usuarios);
					view = "usuarios/index.jsp";
				}
			}
			}
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		
		}finally {
			request.getRequestDispatcher(view).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		ArrayList<Usuario> usuarios = null;
		Alert alert = null;
		
		//Recoger parámetros
		try {
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("pass");
			String rol = request.getParameter("rol");
			usuario.setId(Long.parseLong(id));
			usuario.setNombre(nombre);
			usuario.setPass(pass);
			usuario.setRol(Integer.parseInt(rol));
			
			//TODO comprobar si es CREAR o MODIFICAR y llamar DAO
			
			if(Long.parseLong(id) == -1) {
				
				daoUsuario.insert(usuario);
				alert = new Alert(Alert.SUCCESS, "Usuario creado con éxito");
				
			
			}else {
				
				daoUsuario.update(usuario);
				alert = new Alert(Alert.SUCCESS, "Usuario modificado con éxito");
				
			}
			
			

			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			alert = new Alert();
		
		}finally {
			usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
			request.setAttribute("alert", alert);
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
		}
		
	}

}
