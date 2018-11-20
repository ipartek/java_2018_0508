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

import com.ipartek.formacion.youtube.controller.CrudControllable;
import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/videos")
public class BackofficeVideoController extends HttpServlet implements CrudControllable {

	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario = null;
	private static VideoDAO daoVideo = null;

	private static final String VIEW_LISTADO = "videos/index.jsp";
	private static final String VIEW_FORMULARIO = "videos/form.jsp";

	private String view;
	private Alert alerta;

	private String op;// operacion a realizar
	private String id_video;
	private String nombre;
	private String codigo;
	private String id_usuario;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
		daoVideo = VideoDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoUsuario = null;
		daoVideo = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			alerta = new Alert();
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

			default:// LISTAR

				listar(request);
				break;

			// buscar operacion a realizar
			}
		} catch (Exception e) {
			e.printStackTrace();

			alerta = new Alert();
		} finally {

			request.setAttribute("alert", alerta);
			request.getRequestDispatcher(view).forward(request, response);
			try {
				request.setAttribute("usuarios", daoUsuario.getAll());
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			try {
				listar(request);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	}

	public void guardar(HttpServletRequest request) throws Exception {
		Video video = new Video();
		try {

			video.setId(Long.parseLong(id_video));
			video.setNombre(nombre);
			video.setCodigo(codigo);
			Usuario usuario = new Usuario();
			usuario.setId(Long.parseLong(id_usuario));
			video.setUsuario(usuario);

			if (video.getId() > 0) {
				daoVideo.update(video);
				alerta = new Alert(Alert.SUCCESS, "Video " + video.getNombre() + " actualizado correctamente");
			} else {
				daoVideo.insert(video);
				alerta = new Alert(Alert.SUCCESS, "Video " + video.getNombre() + " añadido correctamente");
			}

		} catch (SQLIntegrityConstraintViolationException e) {// nombre repetido
			e.printStackTrace();
			alerta = new Alert(Alert.WARNING, "El codigo del video ya existe!!");
		} catch (SQLException e) {
			if (e.getMessage().contains("codigo")) {
				alerta = new Alert(Alert.WARNING, "El codigo de video debe ser de 11 caracteres exactos");

			}
		} catch (Exception e) {
			e.printStackTrace();
			alerta = new Alert();
			// longitud de campos nombre y password

		}
		view = VIEW_LISTADO;
		request.setAttribute("video", video);
		request.setAttribute("videos", daoVideo.getAll());
	}

	public void listar(HttpServletRequest request) throws Exception {
		alerta = null;
		view = VIEW_LISTADO;
		int numVideos = daoVideo.getAll().size();
		request.setAttribute("videos", daoVideo.getAll());
		request.setAttribute("numVideos", numVideos);
	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		alerta = null;
		view = VIEW_FORMULARIO;
		if (id_video.equalsIgnoreCase("-1")) {
			request.setAttribute("video", new Video());
		} else {

			request.setAttribute("video", daoVideo.getById(Long.parseLong(id_video)));

		}
		request.setAttribute("usuarios", daoUsuario.getAll());
	}

	public void eliminar(HttpServletRequest request) throws Exception {
		view = VIEW_LISTADO;

		try {
			Video v = daoVideo.getById(Long.parseLong(id_video));
			daoVideo.delete(Long.parseLong(id_video));
			alerta = new Alert(Alert.SUCCESS, "Video " + v.getNombre() + " eliminado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			alerta = new Alert();
		}

		request.setAttribute("videos", daoVideo.getAll());

	}

	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id_video = request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo = request.getParameter("codigo");
		id_usuario = request.getParameter("usuario");

	}
}