package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection.Request;

import com.ipartek.formacion.youtube.Comentario;
import com.ipartek.formacion.youtube.controller.pojo.Alert;
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

	private String op;// operacion
	private String id;// id_video
	private String fecha;
	private String texto;// nombre_video
	private String aprobado;// nombre_video
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

			request.setAttribute("comentarios", dao.getAllAprobado());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(VIEW_LISTADO).forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try {
			String[] ComAprobado = request.getParameterValues("ComAprobado");

			if (ComAprobado != null) {
				if(dao.updateAprobar(ComAprobado)){
					alert = new Alert("Se han aprobados los comentarios.", Alert.SUCCESS);
				}
			}else {
				alert = new Alert("Selecciona algún comentario.", Alert.WARNING);
			}
	
			comentarios = (ArrayList<Comentario>) dao.getAllAprobado();
			request.setAttribute("comentarios", comentarios);
			request.getRequestDispatcher(VIEW_LISTADO).forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
