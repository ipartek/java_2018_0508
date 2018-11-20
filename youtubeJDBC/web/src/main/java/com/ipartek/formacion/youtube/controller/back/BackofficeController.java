package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.ComentariosDao;
import com.ipartek.formacion.youtube.model.RolDao;
import com.ipartek.formacion.youtube.model.UsuariosDaoJDBC;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Comentario;

/**
 * Servlet implementation class BackofficeController
 */
@WebServlet("/backoffice/inicio")
public class BackofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_INICIO = "/backoffice/index.jsp";
	
	private static UsuariosDaoJDBC usuariosDao;
	private static VideoDAO videosDao;
	private static RolDao rolDao;
	private static ComentariosDao comentarioDao;
	private static ArrayList<Comentario> comentarioSinAprobar;
	private static ArrayList<Comentario> comentarios;
       
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		//inicializamos el arraydao de usuarios
		usuariosDao =  UsuariosDaoJDBC.getInstance();
		videosDao = VideoDAO.getInstance();
		rolDao = RolDao.getInstance();
		comentarioDao = ComentariosDao.getInstance();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("usuarios",usuariosDao.getAll());
			request.setAttribute("videos", videosDao.getAll());
			request.setAttribute("roles", rolDao.getAll());
			request.setAttribute("comentarios", comentarioDao.getAll());
			request.setAttribute("comentarios", comentarioSinAprobar());
		} catch (Exception e) {
			
		}finally {
			request.getRequestDispatcher(VIEW_INICIO).forward(request,response);
		}
	}

	private int comentarioSinAprobar() {
		try {
			comentarioSinAprobar = new ArrayList<Comentario>();
			comentarios = (ArrayList<Comentario>) comentarioDao.getAll();
			for(Comentario c: comentarios) {	
				if(!c.isAprobado()) {
					comentarioSinAprobar.add(c);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comentarioSinAprobar.size();
		
		
	}

}
