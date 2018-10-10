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
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/video")
public class BackofficeVideoControllerPuente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoDAO videosJDBC;
	private ArrayList<Video> videos;
	private static UsuariosDaoJDBC usuarioDao;
	private ArrayList<Usuario> usuarios;
	private String vista = "lista-video";
	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	
	Alert alerta ;
	String op ;
	
	String videoId ;
	String codigoCancion;
	String nombreCancion ;
	String usuarioCancion;
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		//inicializamos el arraydao de usuarios
		videosJDBC =  videosJDBC.getInstance();
		usuarioDao = usuarioDao.getInstance();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
/*			request.getRequestDispatcher("video/index.jsp").forward(request, response);
*/		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			getParameters(request);
			alerta = new Alert();



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
		}finally {
			usuarios = (ArrayList<Usuario>) usuarioDao.getAll();
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("videos",videos );
			request.setAttribute("vista", vista);
			request.getRequestDispatcher("video/index.jsp").forward(request, response);

		}
	}

	
	private void listar(HttpServletRequest request) {
		try {
			vista = "lista-video";
			videos = (ArrayList<Video>) videosJDBC.getAll();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private void guardar(HttpServletRequest request) {
		try {
			Video v = new Video();

			Usuario u = usuarioDao.getById(usuarioCancion);
			if(videoId == null || videoId =="") {
				//create
				v.setCodigo(codigoCancion);
				v.setNombre(nombreCancion);
				v.setUsuario(u);
				videosJDBC.insert(v);
			}else {//update
				v = videosJDBC.getById(videoId);
				v.setCodigo(codigoCancion);
				v.setNombre(nombreCancion);
				v.setUsuario(u);
				videosJDBC.update(v);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	private void irFormulario(HttpServletRequest request) {
		try {

			vista = "form-video";
			if(videoId != null || videoId != "") {
				if(videoId != "-1") {//actualizar ponemos datos
					Video  v= videosJDBC.getById(videoId);	
					request.setAttribute("video", v);
				}				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	private void eliminar(HttpServletRequest request) {
		try {
			videosJDBC.delete(videoId);
			alerta = new Alert(Alert.WARNING, "Usuario eliminado correctamente");
			listar(request);
		} catch (Exception e) {
			alerta = new Alert(Alert.WARNING, "No podemos borrar un usuario con videos asociados");
		}
		
	}


	private void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		videoId = request.getParameter("videoId");
		codigoCancion = request.getParameter("codigoCancion");
		nombreCancion = request.getParameter("nombreCancion");
		usuarioCancion = request.getParameter("usuarioCancion");
		vista = request.getParameter("vista");
	}

}
