package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/videos")
public class BackofficeVideoController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;
	
	private static VideoDAO daoVideo = null;
	private static UsuarioDAO daoUsuario = null;

	private static final String VIEW_LISTADO = "videos/index.jsp";
	private static final String VIEW_FORMULARIO = "videos/form.jsp";

	private String view;
	private Alert alert;

	private String op; // Operacion a realizar

	private String id;
	private String codigo;
	private String nombre;
	private String idUsuario;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		daoVideo = VideoDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		
		super.destroy();
		daoVideo = null;
		daoUsuario = null;
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

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
				break;
			case OP_IR_FORMULARIO:

				irFormularioDeAlta(request);
				break;
			case OP_GUARDAR:

				guardar(request);
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

	public void getParameters (HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo = request.getParameter("codigo");
		idUsuario = request.getParameter("idUsuario");
	}

	@Override
	public void listar (HttpServletRequest request) throws SQLException, Exception {

		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("videos", daoVideo.getAll());
	}

	@Override
	public void guardar (HttpServletRequest request) throws SQLException, Exception {
		Video video = new Video();

		video.setId( Long.parseLong(id) );
		video.setCod( codigo );
		video.setNombre( nombre );
		
		video.setUsuario( daoUsuario.getById( Long.parseLong( idUsuario ))); // FK video_has_usuario

		try {

			if (video.getId() > 0) {

				daoVideo.update(video); // Debemos hacer un UPDATE
				alert = new Alert(Alert.SUCCESS, "Video modificado.");

			} else {

				daoVideo.insert(video); // Debemos hacer un INSERT
				alert = new Alert(Alert.SUCCESS, "Video creado.");
			}

		} catch (SQLIntegrityConstraintViolationException e) { // Error entrada duplicada

			alert = new Alert(Alert.WARNING, "El video ya existe.");

		} catch (SQLException e) { // Longitud de campos incorrecta

			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			e.printStackTrace();

		} catch (Exception e) { // Errores que no son de SQL

			alert = new Alert();
			e.printStackTrace();
		}

		view = VIEW_FORMULARIO;
		
		request.setAttribute("usuarios", daoUsuario.getAll());
		request.setAttribute("video", video);	

	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws NumberFormatException, Exception {
		alert = null;

		if (id.equalsIgnoreCase("-1")) {
			request.setAttribute("video", new Video());
		} else {
			request.setAttribute("video", daoVideo.getById(Long.parseLong(id)));
		}
		
		request.setAttribute("usuarios", daoUsuario.getAll());
		view = VIEW_FORMULARIO;

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		try {

			if (daoVideo.delete(Long.parseLong(id))) {

				alert = new Alert(Alert.SUCCESS, "Video eliminado.");
				view = VIEW_LISTADO;
				request.setAttribute("videos", daoVideo.getAll());
			}

		} catch (SQLException e) {

			alert = new Alert(Alert.WARNING, "No podemos eliminar el video porque tiene usuarios asociados.");
			view = VIEW_LISTADO;
		}
	}

}
