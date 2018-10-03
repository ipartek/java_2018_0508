package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Usuario> usuarios;
	UsuarioDAO dao;
	Alert alerta;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioDAO.getInstance();
		usuarios = (ArrayList<Usuario>) dao.getAll();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		alerta=new Alert();
		String id = request.getParameter("id");
		if (id == null) {
			request.setAttribute("usuarios", usuarios);
			
			
		} else {
			Usuario usuario = new Usuario();
			if (Integer.parseInt(id) >= 0) {
				usuario = dao.getById(Long.parseLong(id));
				dao.delete(Long.parseLong(id));
				request.setAttribute("usuario", usuario);
				alerta.setTipo(Alert.SUCCESS);
				alerta.setTexto("Usuario eliminado correctamente");

			}
			
		}
		request.setAttribute("alert", alerta);
		usuarios= (ArrayList<Usuario>) dao.getAll();
		request.setAttribute("usarios", usuarios);
		
		request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Creo el usuario
		Usuario usuario = new Usuario();
		alerta= new Alert();
		try {

			// recoger parametros del formulario

			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("pass");
			String rol = request.getParameter("rol");

			// Seteo los valores de los atributos con los parametros recogidos de la jsp
			usuario.setId(Long.parseLong(id));
			usuario.setNombre(nombre);
			usuario.setPass(pass);
			usuario.setRol(Integer.parseInt(rol));

			// TODO comprobar si es crear o modificar y llamar DAO

			if (Long.parseLong(id) == -1) {
				dao.insert(usuario);
				
				alerta.setTexto("Usuario insertado correctamente");
				alerta.setTipo(Alert.SUCCESS);
				
			} else {
				dao.update(usuario);
				alerta.setTexto("Usuario actualizado correctamente");
				alerta.setTipo(Alert.SUCCESS);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			alerta.setTexto("Ha ocurrido un error por favor vuelva a intentarlo.");
			alerta.setTipo(Alert.DANGER);
		} finally {
			usuarios = (ArrayList<Usuario>) dao.getAll();
			request.setAttribute("alert", alerta);
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
		}

	}

}
