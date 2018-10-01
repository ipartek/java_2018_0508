package com.ipartek.formacion.youtube.controller;

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
 * Servlet implementation class RegistrarController
 */
@WebServlet("/registrarse")
public class RegistrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String OP_ELIMINAR = "1";
	public static final String OP_MODIFICAR = "2";
	
	private static UsuarioDAO dao;
	private ArrayList<Usuario> usuarios;
	Alert alert = new Alert();
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = UsuarioDAO.getInstance();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		dao = null;
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);  //llama a los metodos GET o POST
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		String id = request.getParameter("id");
		String op = request.getParameter("op");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		//eliminar ?			
		if ( op != null && OP_ELIMINAR.equals(op) ) {
			if ( dao.delete(id) ) {
				alert = new Alert(Alert.SUCCESS, "Usuario eliminado correctamente");
			}else {
				alert = new Alert();
			}
		}
		
		//modificar
		if ( op != null && OP_MODIFICAR.equals(op) ) {
			//recuperar usuario por id
			Usuario u = dao.getById(id);
			
			//meter nuevo nombre y password al usuario recuperado
			u.setNombre(nombre);
			u.setPass(password);
			
			//hacer update
			if(dao.update(u)) {
				alert = new Alert(Alert.SUCCESS, "Usuario modificado correctamente");
			}else {
				alert = new Alert();
			}
		}
		
		//listado videos			
		usuarios = (ArrayList<Usuario>) dao.getAll();
		
		}catch(Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}finally {
			request.setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + "/inicio" );
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		try {
			
			String nombre = request.getParameter("usuario");
			String password = request.getParameter("password");
			
			Usuario u = new Usuario();
			u.setNombre(nombre);
			u.setPass(password);
			u.setRol(1);
			
			if ( dao.insert(u) ) {
				alert = new Alert(Alert.SUCCESS, "Usuario registrado correctamente");
			}else {
				alert = new Alert(Alert.WARNING, "ERROR, no se pudo registrar el usuario.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + "/inicio" ); 
		}
	}

}
