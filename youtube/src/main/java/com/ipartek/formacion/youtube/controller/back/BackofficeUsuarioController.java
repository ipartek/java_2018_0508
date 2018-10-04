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
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario = null;
	
	public static final String OP_ELIMINAR = "34";
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		daoUsuario = null;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		String id = request.getParameter("id");
		String op = request.getParameter("op");
		
		if ( id != null && op != null && op.equals(OP_ELIMINAR) ) { //ELIMINAR
			
			daoUsuario.delete(Long.parseLong(id));

			usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
			
			
		}else {
		
				if ( id == null ) {											//LISTADO			
					usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
					request.setAttribute("usuarios", usuarios);
					request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
					
				}else {														//DETALLE			
					
					Usuario usuario = new Usuario();
					if ( Integer.parseInt(id) > 0 ) {
						usuario = daoUsuario.getById(Integer.parseInt(id));				
					}
					request.setAttribute("usuario", usuario);
					request.getRequestDispatcher("usuarios/form.jsp").forward(request, response);
				}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger parametros del formulario		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String rol = request.getParameter("rol");
				
			
		Usuario usuario = new Usuario();		
		usuario.setId( Long.parseLong(id)); 
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		usuario.setRol( Integer.parseInt(rol));
				
		if ( usuario.getId() > 0 ) {			//MODIFICAR
			daoUsuario.update(usuario);
		}else {									//INSERT	
			daoUsuario.insert(usuario);
		}
		
		
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("usuarios/form.jsp").forward(request, response);
		
		
	}
	

}
