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
	private static UsuarioDAO daoUsuario = null;
	
	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2";  //insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	
	private static final String VIEW_LISTADO = "usuarios/index.jsp";
	private static final String VIEW_FORMULARIO = "usuarios/form.jsp";
	private String view;
	private Alert alert;
	
	private String op; //operacion a realizar
	private String id;
	private String nombre;
	private String password;
	private String rol;
	
	
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
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doProcess(request, response);		
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			alert = new Alert();
			
			getParameters(request);
			
			switch (op) {
			case OP_ELIMINAR:
				eliminar(request);
				break;
			case OP_IR_FORMULARIO:
				irFormulario(request);
				break;	
			case OP_GUARDAR:
				guardar(request);
				break;	

			default:  //LISTAR
				listar(request);
				break;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			view = VIEW_LISTADO;
			alert = new Alert();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
			
		}
		
	}

	private void listar(HttpServletRequest request) {
		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("usuarios", daoUsuario.getAll());		
		
	}

	private void guardar(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	private void irFormulario(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	private void eliminar(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	private void getParameters(HttpServletRequest request) {
		
		op = ( request.getParameter("op") != null ) ? request.getParameter("op") : OP_LISTAR;		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		password = request.getParameter("password");
		rol = request.getParameter("rol");
	}

}
