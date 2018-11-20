package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Comentario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/comentarios")
public class BackofficeComentarioController extends HttpServlet implements ICRUDController {
	
	public static final String OP_VER_PENDIENTES = "5";
	public static final String OP_APROBAR = "6";

	private static final long serialVersionUID = 1L;
	private static ComentarioDAO daoComentario = null;

	private static final String VIEW_LISTADO = "comentarios/index.jsp";
	private static final String VIEW_FORMULARIO = "comentarios/form.jsp";
	private static final String VIEW_MODERAR = "comentarios/aprobar-comentarios.jsp";
	

	private String view;
	private Alert alert;

	private String op; // Operacion a realizar

	private String id;
	private String texto;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoComentario = ComentarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoComentario = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		alert = new Alert();
		try {

			getParameters(request);

			switch (op) {
			case OP_ELIMINAR:

				eliminar(request);
				alert = new Alert(Alert.SUCCESS, "Comentarios eliminado");
				break;
			case OP_IR_FORMULARIO:

				irFormularioDeAlta(request);
				break;
			case OP_GUARDAR:

				guardar(request);
				break;
			case OP_VER_PENDIENTES:

				getComentariosPendientes(request);
				break;
			case OP_APROBAR:
				
				aprobarComentarios(request);
				alert = new Alert(Alert.SUCCESS, "Comentarios aprobados");
				break;
			default: // LISTAR

				listar(request);
				break;
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			view = VIEW_LISTADO;
			
		} finally {

			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	private void aprobarComentarios(HttpServletRequest request) throws NumberFormatException, Exception {
		
		String[]  idComentariosAprobados = request.getParameterValues("aprobados");
		Comentario comentario;
		
		for (int i = 0; i < idComentariosAprobados.length; i++) {
			
			comentario = daoComentario.getById(Long.parseLong(idComentariosAprobados[i]));
			comentario.setAprobado(true);
			daoComentario.update(comentario);
			System.out.println("Comentario aprobado");
			
		}
		
		getComentariosPendientes(request);
		
	}

	private void getComentariosPendientes(HttpServletRequest request) throws Exception {
		
		ArrayList<Comentario> pendientes = (ArrayList<Comentario>) daoComentario.getAllByAprobado(0);
		
		request.setAttribute("comentariosPendientes", pendientes);
		
		view = VIEW_MODERAR;
		
	}

	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		texto = request.getParameter("texto");
	}
	

	@Override
	public void listar(HttpServletRequest request) throws Exception {
		
		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("comentarios", daoComentario.getAll());
	}

	@Override
	public void guardar(HttpServletRequest request) throws SQLException {
		Comentario comentario = new Comentario();
		
		comentario.setId(Long.parseLong(id));
		comentario.setTexto(texto);

		try {

			if (comentario.getId() > 0) {
				
				daoComentario.update(comentario); // UPDATE
				alert = new Alert(Alert.SUCCESS, "Comentario modificado.");
				
			} else {
				
				daoComentario.insert(comentario); // INSERT
				alert = new Alert(Alert.SUCCESS, "Comentario creado.");
			}

		} catch (SQLIntegrityConstraintViolationException e) { // Error entrada duplicada
			
			alert = new Alert(Alert.WARNING, "El comentario ya existe.");

		} catch (SQLException e) { // Longitud de campos incorrecta
			
			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			e.printStackTrace();

		} catch (Exception e) { // Errores que no son de SQL

			alert = new Alert();
			e.printStackTrace();
		}

		view = VIEW_FORMULARIO;
		request.setAttribute("comentario", comentario);

	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws Exception {
		alert = null;

		if (id.equalsIgnoreCase("-1")) {
			request.setAttribute("comentario", new Comentario());
		} else {
			request.setAttribute("comentario", daoComentario.getById(Long.parseLong(id)));
		}

		view = VIEW_FORMULARIO;

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		try {

			if (daoComentario.delete(Long.parseLong(id))) {
				
				view = VIEW_LISTADO;
				request.setAttribute("comentarios", daoComentario.getAll());
			}

		} catch (SQLException e) {

			alert = new Alert(Alert.WARNING, "No podemos eliminar el rol porque tiene usuarios asociados.");
			view = VIEW_LISTADO;
		} 	
	}

}
