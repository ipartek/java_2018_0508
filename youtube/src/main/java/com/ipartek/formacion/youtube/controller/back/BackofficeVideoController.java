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

import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet(description = "Para la gestion de videos", urlPatterns = { "/backoffice/video" })
public class BackofficeVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static VideoDAO daoVideo;

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_LISTADO = "video/index.jsp";
	private static final String VIEW_FORMULARIO = "video/form.jsp";
	private String view;
	private Alert alert;

	private String op; // operacion a realizar
	private String id;
	private String nombre;
	private String codigo;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		daoVideo = VideoDAO.getInstance();

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

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
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

			default: // LISTAR
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

	private void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo = request.getParameter("codigo");

	}

	private void listar(HttpServletRequest request) throws Exception {

		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("videos", daoVideo.getAll());
		request.setAttribute("nVideo", daoVideo.getAll().size());

	}

	private void guardar(HttpServletRequest request) {

		
		Video v = null;
		
		try {

			v = new Video();
			v.setId(Long.parseLong(id));
			v.setNombre(nombre);
			v.setCodigo(codigo);
			
			if (v.getId() == 0) {// INSERT
				daoVideo.insert(v);
			} else { // UPDATE
				daoVideo.update(v);
			}

			alert = new Alert("Video guardado con exito :D", Alert.SUCCESS);

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alert = new Alert("<b>" + v.getNombre() + "</b>, el nombre de usuario ya existe en la BBDD", Alert.WARNING);
		} catch (SQLException e) {
			
			if (e.getMessage().contains("nombre")) {
				alert = new Alert("El nombre es demasiado largo. :(", Alert.WARNING);
			}else {
				alert = new Alert("La contraseña es demasiada larga. :(", Alert.WARNING);
			}
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}

		view = VIEW_FORMULARIO;
		request.setAttribute("video", v);

	}

	private void irFormulario(HttpServletRequest request) throws Exception {
		
		Video v = new Video();

		if (Integer.parseInt(id) > 0) {
			v = daoVideo.getById(id);
		}

		request.setAttribute("video", v);

		view = VIEW_FORMULARIO;
	}

	private void eliminar(HttpServletRequest request) throws Exception {

		// TODO para despues del cafe gestionar esta exception
		if (daoVideo.delete(id)) {

			alert = new Alert();
			alert.setTipo(Alert.SUCCESS);
			alert.setTexto("Se ha borrado el usuario de la BBDD");

		} else {

			alert = new Alert();
			alert.setTexto("Nose ha podido borrar al usuario");

		}

		listar(request);

	}
}
