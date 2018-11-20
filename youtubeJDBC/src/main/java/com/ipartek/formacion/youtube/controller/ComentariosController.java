package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.ComentariosDao;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/publicar")
public class ComentariosController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String vista = "lista-video";
	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	
	Alert alerta ;
	String op ;

	private static ComentariosDao comentariosDao;


	String editar = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		comentariosDao = ComentariosDao.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// se ejecuta al parar el servidor

		comentariosDao = null;
	}

	/**
	 * Cada request se ejecuta en un hilo o thread
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Antes de realizar GET o POST");

		super.service(request, response); // llama a los metodos GET o POST

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			doProcess(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			doProcess(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = 0;
		try {
			String id_video = request.getParameter("id_video");
			String id_usuario = request.getParameter("id_usuario");
			String texto = request.getParameter("texto");
			Usuario u = new Usuario();
			u.setId(Long.parseLong(id_usuario));
			Video v = new Video();
			v.setId(Long.parseLong(id_video));
			Comentario c = new Comentario();
			c.setTexto(texto);
			c.setUsuario(u);
			c.setVideo(v);
			comentariosDao.insert(c);
			id = v.getId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Pasamos el id del video para que siga como video de inicio
			response.sendRedirect(request.getContextPath() + "/inicio?id=" + id);
		}

	}

}
