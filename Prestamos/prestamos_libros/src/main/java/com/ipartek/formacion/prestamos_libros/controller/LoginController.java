package com.ipartek.formacion.prestamos_libros.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.prestamos_libros.controller.pojo.Alert;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.pojo.UsuarioLogin;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	private static final long serialVersionUID = 1L;
	private ServicePrestamo prestamoService;
	
	private Alert alert;
	
	private String COMPROBARUSUARIO = "admin";
	private String COMPROBARCONTRASENYA = "admin";
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		prestamoService = new ServicePrestamo();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		prestamoService = null;
	}

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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		alert = null;
		HttpSession session = request.getSession();
		String view = "/home.jsp";
		
		try{
			
			//recoger parametros
			String usuario = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			String recordar = (String)request.getParameter("recuerdame");
			
			
			if(COMPROBARUSUARIO.equals(usuario)){
				if(COMPROBARCONTRASENYA.equals(pass)){
					
					UsuarioLogin u = new UsuarioLogin(usuario, pass);
					
					session.setAttribute("usuarioLogin",u);
					session.setMaxInactiveInterval(60*5); // 5min 60*5
					
					Cookie cNombre = new Cookie("cNombre", u.getNombre());
					
					if ( recordar != null) {
						
						cNombre.setMaxAge(60*60*24*30*3); // 3meses
						
					}else {
						cNombre.setMaxAge(0); // No guardar
					}
					
					response.addCookie(cNombre);
					
					//entrada a lista de libros prestados
					view = "/backoffice/index.jsp";
					
					//entrada a libros no prestados
					//view = "/backoffice/libro";
					
					List<Prestamo> prestamos = prestamoService.listar();
					
					request.setAttribute("prestamos", prestamos);
				}else{
					alert = new Alert(Alert.DANGER, "Contraseña incorrecta");
				}
			}else{
				alert = new Alert(Alert.DANGER, "Usuario incorrecto");
			}
			
		}catch(Exception e){
			LOG.error(e);
		}finally {
			session.setAttribute("alert", alert);			
			//response.sendRedirect(request.getContextPath() + view );
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		
		
	}

}
