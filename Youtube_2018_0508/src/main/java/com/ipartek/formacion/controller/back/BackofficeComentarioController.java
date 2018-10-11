package com.ipartek.formacion.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.ComentarioArrayDAO;
import com.ipartek.formacion.model.RolDAO;
import com.ipartek.formacion.model.UsuarioDAO;
import com.ipartek.formacion.pojo.Alert;

/**
 * Servlet implementation class BackofficeComentarioController
 */
@WebServlet("/backoffice/comentarios")
public class BackofficeComentarioController extends HttpServlet implements CrudControllable{
	private static final long serialVersionUID = 1L;
	
	private static ComentarioArrayDAO daoComentarios;
	
	private static final String VIEW_INDEX_COMENTARIOS = "comentarios/index.jsp";
	
	Alert alert = null;
	String view = "";
	
	//Parametros
	String op;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoComentarios = ComentarioArrayDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoComentarios = null;
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

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			alert=null;
			
			//Recoge los parametros de la request y los guarda en variables
			getParameters(request);
			
			//Dependiendo del valor del parametro op hace una funcion u otra
			switch (op) {
				case OP_ELIMINAR:
					eliminar(request); //Elimina un usuario de la bbdd
					break;
					
				case OP_GUARDAR:
					guardar(request); //Crea o modifica un usuario en la bbdd
					break;
					
				case OP_IR_FORMULARIO:
					irFormulario(request); //Cambia a la vista del formulario de gestion de usuario
					break;
	
				default: //Listar
					listar(request); //Cambia a la vista de listado de usuarios
					break;
			}
		}catch(Exception e) {
			e.printStackTrace();
			view = VIEW_INDEX_COMENTARIOS;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	@Override
	public void getParameters(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
