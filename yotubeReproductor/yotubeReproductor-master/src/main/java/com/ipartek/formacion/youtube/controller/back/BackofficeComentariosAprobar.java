package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Alert;
import com.ipartek.formacion.youtube.Comentario;
import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;

/**
 * Servlet implementation class BackofficeComentariosAprobar
 */
@WebServlet("/backoffice/comentarios")
public class BackofficeComentariosAprobar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ComentarioDAO dao;
	private static UsuarioDAO daoUsuario;
	private static VideoDAO daoVideo;
	private ArrayList<Comentario> comentarios;
	private Comentario comentarioInicio;
	
	
	
	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	

	private static final String VIEW_LISTADO = "comentarios/index.jsp";

	private String view;
	private Alert alert;
	
	private String op;//operacion
	private String id;//id_video
	private String fecha;
	private String texto;//nombre_video
	private String aprobado;//nombre_video
	private String usuario;
	private String video;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = ComentarioDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
		daoVideo = VideoDAO.getInstance();
		
	}

	@Override
	public void destroy() {
		super.destroy();
		dao = null;
		daoUsuario = null;
		daoVideo = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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


	private void listar(HttpServletRequest request) throws Exception {
		alert = null;
		view = VIEW_LISTADO
				;
		// listado comentarios
		request.setAttribute("comentarios", dao.getAll());
		
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
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		
		id = request.getParameter("id");
		fecha = request.getParameter("fecha");
		texto = request.getParameter("texto");
		aprobado = request.getParameter("aprobado");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
