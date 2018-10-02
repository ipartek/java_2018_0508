package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

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
	private static final String VIEW_INICIO = "/inicio";
	private static UsuarioDAO daoUsuario;
	
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
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Alert alert = null;
		
		try {
			String nombre = request.getParameter("nombreRegistro");
			String pass = request.getParameter("passRegistro");
			String passRep = request.getParameter("passRegistroRep");
			
			if(pass.equals(passRep)) {				
				
				Usuario u = new Usuario(nombre, pass);
				
				if(daoUsuario.insert(u)) {
					alert = new Alert(Alert.SUCCESS, "Se ha registrado correctamente, por favor inicie sesión");
				
				}else {
					alert = new Alert(Alert.DANGER, "El nombre de usuario <i>" + u.getNombre() + "</i> ya existe en la base de datos, por favor introduzca un nombre diferente.");
				}
				
			}else {
				alert = new Alert(Alert.DANGER, "Ha introducido dos contraseñas diferentes, por favor introduzca una única contraseña.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
			
		}finally {
			session.setAttribute("msgRegistro", "");
			session.setAttribute("enlaceRegistro", "");
			session.setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + VIEW_INICIO);
		}
		
	}

}
