package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario;
	
	private static final String VIEW_INICIO_ADMIN = "/backoffice/inicio";
	private static final String VIEW_INICIO_USER = "/inicio";
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Alert alert = new Alert();
		HttpSession session = request.getSession();
		String view = VIEW_INICIO_USER;
		
		try {
	
			daoUsuario = UsuarioDAO.getInstance();
			
			//idiomas @see com.ipartek.formacion.youtube.filter.IdiomaFilter
			String idioma = (String)session.getAttribute("idioma");			
			Locale locale = new Locale( idioma.split("_")[0] , idioma.split("_")[1] );			
			ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
			
			//recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			String recuerda = request.getParameter("recuerdame");
			
			Cookie cRecuerda = new Cookie("cRecuerda", "5");
			
			if("1".equals(recuerda)) {
				cRecuerda.setValue(usuarioNombre);
				cRecuerda.setMaxAge(60*60*24*30*3); //3meses
			}else {
				cRecuerda.setValue("");
				cRecuerda.setMaxAge(0); //No guardar
			}
			
			response.addCookie(cRecuerda);
			
			Usuario u = new Usuario(usuarioNombre, pass);
			
			if(daoUsuario.login(u)) {
				alert.setTexto(MessageFormat.format(idiomas.getString("msj.bienvenida"), usuarioNombre));
				alert.setTipo(Alert.PRIMARY);
			
				//guardar Usuario en session
				u.setNombre(usuarioNombre);
				u.setPassword(pass);
				session.setAttribute("usuario", u);
				
				if(u.getRol() == Usuario.ROL_ADMIN) {
					view = VIEW_INICIO_ADMIN;
				}
				
			}else {
				alert.setTexto("Credenciales incorrectas. Si aún no te has registrado, puedes hacerlo desde este enlace.");
			}
			
			session.setMaxInactiveInterval(60*5); // 5min
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + view ); 
		}
		
		
	}

}
