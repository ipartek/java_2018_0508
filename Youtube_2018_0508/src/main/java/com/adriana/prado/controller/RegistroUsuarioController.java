package com.adriana.prado.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adriana.prado.model.UsuarioDAO;
import com.adriana.prado.pojo.Alert;
import com.adriana.prado.pojo.Usuario;

/**
 * Servlet implementation class RegistroUsuarioController
 */
@WebServlet("/registro")
public class RegistroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_REGISTRO = "registro.jsp";
	private static final String VIEW_HOME = "/inicio";
	
	private static String usuario = "";
	private static String pswd = "";
	private static String pswdRepe = "";
	
	private static UsuarioDAO dao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Aqui llamar a la jsp y poner la alert a null
		Alert alert = null;
		
		try {
			request.setAttribute("alert", alert);
		}catch(Exception e) {
			
		}finally {
			request.getRequestDispatcher(VIEW_REGISTRO).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Alert alert = null;
		Usuario u = null;
		String vista = VIEW_REGISTRO;
		
		dao = UsuarioDAO.getInstance();
		
		try {
			//Recoger parametros
			usuario = request.getParameter("usuario");
			pswd = request.getParameter("pswd");
			pswdRepe = request.getParameter("pswdRepe");
			
			//Realizar comprobaciones
			if(usuario != null && pswd != null && pswdRepe != null) {
				u = new Usuario(usuario, pswd);
				if(pswd.equals(pswdRepe)) {
					if(dao.insert(u)) {
						vista = VIEW_HOME;
						alert = new Alert(Alert.ALERT_SUCCESS, "Usuario registrado correctamente.");
					}else {
						alert = new Alert(Alert.ALERT_DANGER, "El usuario " + usuario + " ya esta registrado.");
					}
				}else {
					alert = new Alert(Alert.ALERT_DANGER, "Las contraseñas no coinciden.");
				}
			}else {
				alert = new Alert(Alert.ALERT_DANGER, "Debes rellenar todos los campos.");
			}
			
			//Enviar atributos e ir a la vista
			request.setAttribute("alert", alert);
		}catch(Exception e) {
			e.printStackTrace();
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error inesperado.");
		}finally {
			if(vista.equals(VIEW_HOME)) {
				request.getSession().setAttribute("alert", alert);
				alert = null;
				response.sendRedirect(request.getContextPath() + VIEW_HOME);
			}else {
				alert = null;
				request.getRequestDispatcher(vista).forward(request, response);
			}			
		}
	}

}
