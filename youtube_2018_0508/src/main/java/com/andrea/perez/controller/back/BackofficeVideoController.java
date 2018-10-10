package com.andrea.perez.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrea.perez.model.UsuarioDAO;
import com.andrea.perez.model.VideoDAO;
import com.andrea.perez.pojo.Alert;
import com.andrea.perez.pojo.Usuario;
import com.andrea.perez.pojo.Video;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/videos")
public class BackofficeVideoController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_LISTADO = "videos/index.jsp";
	private static final String VIEW_FORMULARIO = "videos/form.jsp";

	private String view;
	private Alert alert = null;

	private String op; // parametros necesarios
	private String id;
	private String codigo;
	private String titulo;
	private String usuario;

	private static VideoDAO daoVideo = null;
	private static UsuarioDAO daoUsuario = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// Se ejecuta solo con la primera peticion. El resto van al service
		super.init(config);
		daoVideo = VideoDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		// Se ejecuta al parar el servidor
		super.destroy();
		daoVideo = null;
		daoUsuario = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
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

	public void listar(HttpServletRequest request) throws Exception {

		view = VIEW_LISTADO;
		request.setAttribute("videos", daoVideo.getAll());

	}

	public void guardar(HttpServletRequest request) {

		Video video = new Video();
		
		try {
			
			video.setTitulo(titulo);
			video.setCodigo(codigo);

			if (video != null) {
				
				Usuario usuarioVideo=new Usuario();
				usuarioVideo.setId(Long.parseLong(usuario));
				
				video.setUsuario(usuarioVideo);
				
			}

			if (!id.equals("")) { // MODIFICAR
				video.setId(Long.parseLong(id));
				if (daoVideo.update(video)) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Registro modificado correctamente");
				}
			} else {
				
				if (daoVideo.insert(video)) { // Insertar
					alert = new Alert(Alert.ALERT_SUCCESS, "Registro agregado correctamente");
				}
			}
			request.setAttribute("usuarios", daoUsuario.getAll());
			
			// nombre repetido
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("video", video);
		view = VIEW_FORMULARIO;

	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		Video video = null;
		if (Integer.parseInt(id) > 0) {
			video = daoVideo.getById(id);
		} else {
			video = new Video();
		}
		view = VIEW_FORMULARIO;
		request.setAttribute("usuarios", daoUsuario.getAll());
		request.setAttribute("video", video);
	}

	public void eliminar(HttpServletRequest request) throws Exception {

		if (id != null) {
			try {
				if (daoVideo.delete(id)) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Se ha eliminado el registro");
				}

			} catch (Exception e) {

				e.printStackTrace();
				alert = new Alert();

			}
			view = VIEW_LISTADO;
			request.setAttribute("videos", daoVideo.getAll());
		}
	}

	public void getParameters(HttpServletRequest request) {

		// parametros necesarios
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		titulo = request.getParameter("titulo");
		codigo = request.getParameter("codigo");
		usuario = request.getParameter("usuario");

	}

}
