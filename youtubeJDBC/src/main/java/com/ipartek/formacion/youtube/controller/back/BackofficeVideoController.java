package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuariosDaoJDBC;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/video")
public class BackofficeVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoDAO videosJDBC;
	private ArrayList<Video> videos;
	private String view = "tree";
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		//inicializamos el arraydao de usuarios
		videosJDBC =  videosJDBC.getInstance();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String view = request.getParameter("view");
			String id = request.getParameter("id");
			videos = (ArrayList<Video>) videosJDBC.getAll();
			Video videoSeleccionado = new Video();

			
			if(videos != null) {
				request.setAttribute("videos", videos);
			}
			
			if (view == null) {
				view = "tree";
			}
			//Si viene id automaticamente cambiamos a vista formulario
			if(id != null) {
				view = "form";
				videoSeleccionado = videosJDBC.getById(id);
			}
			
			request.setAttribute("view", view);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			request.getRequestDispatcher("video/index.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
