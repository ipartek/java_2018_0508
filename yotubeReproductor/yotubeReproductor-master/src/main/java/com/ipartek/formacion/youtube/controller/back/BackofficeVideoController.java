package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Alert;
import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;

/**
 * Servlet implementation class BackofficeVideoController
 */
@WebServlet("/backoffice/videos")
public class BackofficeVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoDAO dao;
	private static UsuarioDAO daoUsuario;
	

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_LISTADO = "video/index.jsp";
	private static final String VIEW_FORMULARIO = "video/form.jsp";

	private String view;
	private Alert alert;

	private String op;//operacion
	private String id;//id_video
	private String codigo;
	private String nombre;//nombre_video
	private String usuario;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = VideoDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
		dao = null;
		daoUsuario = null;
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
		view = VIEW_LISTADO;
		request.setAttribute("videos", dao.getAll());

	}

	private void irFormulario(HttpServletRequest request) throws Exception {
		alert = null;
		view = VIEW_FORMULARIO;
		Video video = new Video();
		if (Integer.parseInt(id) > 0) {
			video = dao.getById(id);
		}
		request.setAttribute("usuarios", daoUsuario.getAll());
		request.setAttribute("video", video);
	}

	private void eliminar(HttpServletRequest request) throws Exception {
		try {

			alert = new Alert();
			alert.setTexto("Video Eliminado");
			alert.setTipo("alert-success");
			dao.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
			alert.setTipo("alert-danger");
			alert.setTexto("No podemos eliminar el video por que tiene usuario asociados");
		}

		view = VIEW_LISTADO;
		request.setAttribute("videos", dao.getAll());
	}
	// Todo para despues gestionar esta throws Exception

	private void guardar(HttpServletRequest request) throws Exception {
		Video v = new Video();

		try {

			v.setId(Long.parseLong(id));
			v.setNombre(nombre);
			v.setCodigo(codigo);
			v.setUsuario(daoUsuario.getById(usuario));

			if (v.getId() > 0) {
				dao.update(v);
			} else {
				dao.insert(v);
			}
			alert.setTexto("Video guardado");
			alert.setTipo("alert-success");

			// nombre repetido
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alert.setTipo("alert-danger");
			alert.setTexto("<b>" + v.getNombre() + " </b> El video ya existe!!!");

			// longitud campos nombre y password
		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getMessage().contains("nombre")) {
				alert.setTipo("alert-danger");
				alert.setTexto("El <b>nombre</b> debe ser inferior a 50 caracteres");

			}
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}

		view = VIEW_FORMULARIO;
		request.setAttribute("video", v);
		request.setAttribute("usuarios", daoUsuario.getAll());

	}

	private void getParameters(HttpServletRequest request) {
		
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		codigo = request.getParameter("codigo");
		nombre = request.getParameter("nombre");
		usuario = request.getParameter("usuario");


	}

}
