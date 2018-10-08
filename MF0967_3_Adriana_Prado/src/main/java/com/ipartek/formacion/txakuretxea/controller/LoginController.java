package com.ipartek.formacion.txakuretxea.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.txakuretxea.model.PerroDAO;
import com.ipartek.formacion.txakuretxea.pojo.Alert;
import com.ipartek.formacion.txakuretxea.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String user = "";
	private String pswd = "";
	
	private Alert alert = null;
	private String view = "";
	
	private static final String VIEW_LOGIN = "login.jsp";
	private static final String VIEW_HOME = "home.jsp";
	
	Map<String, String> listaUsuarios = new HashMap<String, String>();
	private static PerroDAO daoPerro = null;
       
	@Override
	public void init() throws ServletException {
		super.init();
		listaUsuarios.put("scobby", "galletas");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		alert = null;
		
		daoPerro = PerroDAO.getInstance();
		
		try {
			
			//Recoger parametros
			user = request.getParameter("nombre");
			pswd = request.getParameter("pswd");
			
			//Validar parametros recibidos
			if(!listaUsuarios.isEmpty()) {
				if(listaUsuarios.containsKey(user) && pswd.equals(listaUsuarios.get(user))){
					Usuario u = new Usuario(user, pswd);
					
					//Guardar Usuario en session
					session.setAttribute("usuario", u);
					session.setMaxInactiveInterval(60*60); //1 hora
					
					alert = new Alert(Alert.ALERT_SUCCESS, "Bienvenido " + u.getNombre() + "!");
					
					request.setAttribute("perros", daoPerro.getAll());
					view = VIEW_HOME;
					
				}else {
					alert = new Alert(Alert.ALERT_DANGER, "Credenciales incorrectas.");
					view = VIEW_LOGIN;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}	
	}

}
