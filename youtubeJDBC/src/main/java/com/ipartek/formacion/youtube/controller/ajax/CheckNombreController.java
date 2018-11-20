package com.ipartek.formacion.youtube.controller.ajax;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.ComentariosDao;
import com.ipartek.formacion.youtube.model.UsuariosDaoJDBC;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/checknombre")
public class CheckNombreController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static UsuariosDaoJDBC usuariosDao;
	private static Usuario usuario;
	String msg;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		

	}

	@Override
	public void destroy() {
		super.destroy();
		// se ejecuta al parar el servidor


	}

	/**
	 * Cada request se ejecuta en un hilo o thread
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



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
		try {
			
			// respondo en formato json
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        String nombre = request.getParameter("nombre");
	        usuariosDao = usuariosDao.getInstance();
	        if( usuariosDao.checkByName(nombre)) {

	        	msg = "nombre no disponible";
	        }else {
	        	msg = "nombre disponible";
	        }
	        
			
			
			//todo consultar dao
			//usuario = usuariosDao.get
			
			//respuesta salida
			PrintWriter out = response.getWriter();

	        out.print("{\"resultado\": \" "+msg+" "+nombre+"\" }");
	        out.flush();   
		} catch (Exception e) {
			// TODO: handle exception
		}
		 	
		
	}

}
