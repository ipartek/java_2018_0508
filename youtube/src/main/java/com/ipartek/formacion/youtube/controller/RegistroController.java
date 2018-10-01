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
 * Servlet implementation class registroController
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO dao;
	private ArrayList<Usuario> usuarios;
	
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
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Alert alert = null;
		usuarios = (ArrayList<Usuario>) dao.getAll();
		boolean nombreRepetido = false;
		
		try {
			String nombre = request.getParameter("nombreRegistro");
			String pass = request.getParameter("passRegistro");
			String passRep = request.getParameter("passRegistroRep");
			
			for(Usuario usuario : usuarios) {
				if(usuario.getNombre().equals(nombre)) {
					nombreRepetido = true;
					break;
				}
			}
			
			if(nombreRepetido) {
				alert = new Alert(Alert.DANGER, "El nombre de usuario ya existe en la base de datos, por favor introduzca un nombre diferente.");
			}
			
			else if(pass.equals(passRep)) {				
				
				Usuario u = new Usuario(nombre, pass);
				
				if(dao.insert(u)) {
					alert = new Alert(Alert.SUCCESS, "Ha introducido los datos correctamente");
				}
				
			}else {
				alert = new Alert(Alert.DANGER, "Ha introducido dos contraseñas diferentes, por favor introduzca una única contraseña.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			session.setAttribute("msgRegistro", "");
			session.setAttribute("enlaceRegistro", "");
			session.setAttribute("alert", alert);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
	}

}
