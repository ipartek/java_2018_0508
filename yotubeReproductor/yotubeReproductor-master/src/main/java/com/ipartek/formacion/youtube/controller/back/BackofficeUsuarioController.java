package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Alert;
import com.ipartek.formacion.youtube.Usuario;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static UsuarioDAO dao;
	private static ArrayList<Usuario> usuarios = null;

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_LISTADO = "usuario/index.jsp";
	private static final String VIEW_FORMULARIO = "usuario/formulario.jsp";
	private String view;
	private Alert alert;

	private String op; // operacion a realizar
	private String id;
	private String nombre;
	private String password;
	private String rol;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = UsuarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// se ejecuta al parar el servidor
		dao = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			alert = new Alert();

			getParameters(request);

			switch (op) {
			case OP_GUARDAR:
				guardar(request);
				break;
			case OP_ELIMINAR:
				eliminar(request);
				break;
			case OP_IR_FORMULARIO:
				irFormulario(request);
				break;

			default:
				listar(request);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_LISTADO;
			alert = new Alert();
		} finally {

			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	private void listar(HttpServletRequest request) {
		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("usuarios", dao.getAll());	
		

	}

	private void irFormulario(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	private void eliminar(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	private void guardar(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	private void getParameters(HttpServletRequest request) {

		op = ( request.getParameter("op") != null ) ? request.getParameter("op") : OP_LISTAR;	
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		password = request.getParameter("password");
		rol = request.getParameter("rol");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * id = request.getParameter("id"); op = request.getParameter("op");
	 * 
	 * if (op != null) {
	 * 
	 * dao.delete(id);
	 * 
	 * usuarios = (ArrayList<Usuario>) dao.getAll();
	 * 
	 * request.setAttribute("usuarios", usuarios);
	 * request.getRequestDispatcher(VIEW_LISTADO).forward(request, response); } else
	 * {
	 * 
	 * if (id == null) { // LISTADO
	 * 
	 * 
	 * usuarios = (ArrayList<Usuario>) dao.getAll();
	 * 
	 * request.setAttribute("usuarios", usuarios);
	 * request.getRequestDispatcher(VIEW_LISTADO).forward(request, response); } else
	 * { // DETALLE Usuario usuario = new Usuario(); if (Integer.parseInt(id) > 0) {
	 * usuario = dao.getById(id); } request.setAttribute("usuario", usuario);
	 * request.getRequestDispatcher(VIEW_FORMULARIO).forward(request, response); } }
	 * 
	 * }
	 * 
	 * /**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * id = request.getParameter("id"); nombre = request.getParameter("nombre");
	 * password = request.getParameter("password"); rol =
	 * request.getParameter("rol");
	 * 
	 * Usuario usuario = new Usuario(); usuario.setId(Long.parseLong(id));
	 * usuario.setNombre(nombre); usuario.setPassword(password);
	 * usuario.setRol(Integer.parseInt(rol));
	 * 
	 * // Es una modificacion if (usuario.getId() > 0) { dao.update(usuario); } else
	 * { // Es una alta dao.insert(usuario); }
	 * 
	 * request.setAttribute("usuario", usuario);
	 * request.getRequestDispatcher(VIEW_FORMULARIO).forward(request, response);
	 * 
	 * }
	 */

}
