package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.UsuariosDaoJDBC;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String OP_ELIMINAR = "1";
	public static final String OP_MODIFICAR = "2";
	private static VideoDAO dao;
	private static UsuariosDaoJDBC usuarioDao;
	private ArrayList<Video> videos;	
	private Video videoInicio;
	String editar = null;

	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = VideoDAO.getInstance();
		usuarioDao = usuarioDao.getInstance();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		dao = null;
	}
	
	
	/**
	 * Cada request se ejecuta en un hilo o thread
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Antes de realizar GET o POST");
		
		
		//idiomas @see com.ipartek.formacion.youtube.filter.IdiomaFilter
		HttpSession session = request.getSession();
		String idioma = (String)session.getAttribute("idioma");		
		Locale locale = new Locale( idioma.split("_")[0] , idioma.split("_")[1] );			
		ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
		
		
		super.service(request, response);  //llama a los metodos GET o POST
				
		//despues de realizar GET o POST
		request.setAttribute("videos", videos);
		request.setAttribute("videoInicio", videoInicio);
		String playList =null;
		for(int i=1; i < videos.size();i++ ) {
			 playList += videos.get(i).getCodigo() +",";
		}
		request.setAttribute("playList", playList);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Alert alerta = new Alert();
			//parametros
			String id = request.getParameter("id");
			String op = request.getParameter("op");
			String editar = request.getParameter("editar");
			String videoEditar = request.getParameter("videoEditar");
			String editarNombreGet = request.getParameter("editarNombreGet");
			String editarNombreIdGet = request.getParameter("editarNombreIdGet");
			String edicion = request.getParameter("edicion");
			String modifiCacionNombreModal = request.getParameter("modifiCacionNombreModal");
			/*//solo cuando editar este activo haremos la comprobacion
			if (editar != null) {
				
			}*/
			comprobarEdicionBloque(request,response);
			
			
			
			
			//editar(preparar datos para volcarlos a los campos de modo edicion)

			//editas desde el listado solo 1 registro
			/*if(editarNombreGet != null && editarNombreIdGet != null) {
				
				Video v = dao.getById(editarNombreIdGet);
				v.setNombre(editarNombreGet);
				dao.update(v);
			}*/
			//eliminar ?			
			if ( op != null && OP_ELIMINAR.equals(op) ) {
				if(dao.delete(id)) {
					alerta = new Alert(Alert.SUCCESS,"Video Eliminando correctamente");
				}else {
					alerta = new Alert(Alert.DANGER,"OOps hemos detectado un problema");
				}
			}
			
			//Modificar atraves del modal ?			
			if ( op != null && OP_MODIFICAR.equals(op) ) {
				Video vModificar = dao.getById(id);
				
				vModificar.setNombre(modifiCacionNombreModal);
				dao.update(vModificar);
			}
			
			//listado videos			
			videos = (ArrayList<Video>) dao.getAll();
			
			
			//video de inicio
			videoInicio = new Video();
			if ( id != null && !OP_ELIMINAR.equals(op) ) {
				videoInicio = dao.getById(id);
				
				//guardar video reproducido si esta usuario en session
				HttpSession session = request.getSession();
				Usuario usuario = (Usuario)session.getAttribute("usuario");
				if ( usuario != null ) { //Logeado
				
					ArrayList<Video> reproducidos = (ArrayList<Video>)session.getAttribute("reproducidos");
					if ( reproducidos == null ) {
						reproducidos = new ArrayList<Video>();
					}
					reproducidos.add(videoInicio);
					session.setAttribute("reproducidos", reproducidos);										
					
				}				
				
			}else if ( !videos.isEmpty()) {
				videoInicio = videos.get(0);
			}
			if(editar != null) {
				//establezco el atributo editar para que al refrescar la vista enseñe los campos editables
				request.setAttribute("editar", editar);
				editar = null;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	private void comprobarEdicionBloque(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * TEnemos que preguntar por el patron editarNombreGet(N) donde n sera un numero en incremento
		 * El tope de N sera el tamaño maximo del ArrayList videos
		 */
		videos = (ArrayList<Video>) dao.getAll();
		

		//obtengo el ultimo registro para mirar su indice
		Video x = videos.get(0);
		System.out.println(x.getId());
		for (int i= 0 ; i < x.getId(); i++) {
			//formamos dicha cadena para preguntar al request.getParameter()
			String iString = String.valueOf(i+1);
			String cadenanDefinitiva = "editarNombreGet" + iString;
			//String cadenaiDefinitivaId ="cadenaDefinitivaId" +iString;
			String cadenaDefinitivaId = "editarNombreIdGet" + iString;
			
			System.out.println(cadenanDefinitiva);
			System.out.println(cadenaDefinitivaId);
			String coincidenciaCadenaDefinitiva = request.getParameter(cadenanDefinitiva);
			System.out.println(coincidenciaCadenaDefinitiva);
			//null = para cuando pregunta por un registro que no existe
			//"" = para cuando no se editan algun campo en modo edicion
			if (request.getParameter(cadenanDefinitiva) != null && request.getParameter(cadenanDefinitiva) != "" ) {
				String editarNombreGetX = request.getParameter(cadenanDefinitiva);
				String editarNombreGetIdX = request.getParameter(cadenaDefinitivaId);
				Video v = dao.getById(editarNombreGetIdX);
				v.setNombre(editarNombreGetX);
				dao.update(v);
				
			}
		}	
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Alert alerta = null ;
		try {
			int idInt;
			//recoger parametros
			String codigo = request.getParameter("codigo");
			String nombre = request.getParameter("nombre");
			String editarVideoId = request.getParameter("editarVideoId");
			String editarNombre = request.getParameter("editarNombre");
			String usuarioId = request.getParameter("usuarioId");
			String modifiCacionNombreModal = request.getParameter("modifiCacionNombreModal");
			
			if (editarVideoId != null) {

				Video v = dao.getById(editarVideoId);
				v.setNombre(editarNombre);
				dao.update(v);
			}
			
			//insertar
			if(codigo != null || nombre != null) {
				boolean resultInsert = false; 
				Usuario u = usuarioDao.getById(usuarioId);
				videoInicio = new Video(codigo, nombre,u);
				resultInsert =dao.insert(videoInicio);
				if(!resultInsert) {
					alerta = new Alert();
					alerta.setTexto("Hemos tenido un problema, revise el codigo de su cancion");
					alerta.setTexto(Alert.DANGER);	
				}else {
					alerta = new Alert();
					alerta.setTexto("Okey !");
					alerta.setTexto(Alert.SUCCESS);	
				}
					
			}
			
			
			//pedir listado			
			videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("alerta", alerta);

		} catch (Exception e) {
			e.printStackTrace();
			alerta = new Alert();
		} finally {
			request.setAttribute("alerta", alerta);
		}
	}

}
