package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet(description = "Para la gestion de usuarios", urlPatterns = { "/backoffice/usuario" })
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static UsuarioDAO daoUsuario;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		daoUsuario = UsuarioDAO.getInstance();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Alert alert = null;
		
		String vista = "usuario/index.jsp";
		
		try {
			
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
			Usuario u = null;
			
			String id = request.getParameter("id");
			
			if (id == null) {
				
				if (usuarios.isEmpty()) {
					alert = new Alert();
					alert.setTexto("Aun no hay registro en esta tabla");
					session.setAttribute("Alert", alert);
				}
				request.setAttribute("usuarios", usuarios);
				
			}else {
				
				u = new Usuario();
				
				if(Integer.parseInt(id)>0) {
					u = daoUsuario.getById(id);
				}
				if (u == null) {
					alert = new Alert();
					alert.setTexto("El usuario no existe en la BBDD");
					session.setAttribute("Alert", alert);
				}else {
					request.setAttribute("usuario", u);
					vista = "usuario/form.jsp";
				}
				
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Alert alert = null;
		
		try {
			
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String contrasenya = request.getParameter("contrasenya");
			String rol = request.getParameter("rol");
			
			Usuario u = new Usuario();
			u.setId(Long.parseLong(id));
			u.setNombre(nombre);
			u.setContrasenya(contrasenya);
			u.setRol(Integer.parseInt(rol));
			
			if (Integer.parseInt(id) == 0) {// INSERT
				
				if(daoUsuario.insert(u)) {
					alert = new Alert();
					alert.setTipo(Alert.SUCCESS);
					alert.setTexto("El usuario creado con exito en la BBDD.");
				}else {
					alert = new Alert();
					alert.setTexto("El usuario no se ha podido crear por algun problema.");
				}
				
			}else { // UPDATE
				
				if(daoUsuario.update(u)) {
					alert = new Alert();
					alert.setTipo(Alert.SUCCESS);
					alert.setTexto("El usuario se ha modificado con exito en la BBDD.");
				}else {
					alert = new Alert();
					alert.setTexto("El usuario no se ha podido modificar por algun problema.");
				}
			}
			
			request.setAttribute("alert", alert);
			request.setAttribute("usuario", u);
			request.getRequestDispatcher("usuario/form.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
