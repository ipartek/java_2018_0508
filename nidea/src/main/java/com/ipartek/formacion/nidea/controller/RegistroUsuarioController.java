package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.nidea.model.ProductosDao;
import com.ipartek.formacion.nidea.model.UsuariosDao;
import com.ipartek.formacion.nidea.pojo.Producto;
import com.ipartek.formacion.nidea.pojo.Usuario;



/**
 * Servlet implementation class ListarControler
 */
@WebServlet("/RegistroUsuarioControler")
public class RegistroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuariosDao usuariosDao;
	private static ArrayList<Usuario> usuarios;
	private String msg;
	private static boolean error;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList test = new ArrayList<Producto>();
		System.out.println("***GET***");
		
		request.getRequestDispatcher("usuarioBienvenida.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("***POST***");
			//recogemos parametros
			String nombreUsuario = request.getParameter("nombreUsuario");
			String passUsuario = request.getParameter("passUsuario");
			String emailUsuario = request.getParameter("emailUsuario");
			String replyPassUsuario = request.getParameter("replyPassUsuario");
			usuariosDao =  usuariosDao.getInstance();
			usuarios =  (ArrayList<Usuario>) usuariosDao.getAll();
			
			long id = 0;
			
			//validamos
			
			boolean errorPassReg = comprarUsuarioPassReg(passUsuario,replyPassUsuario);
			boolean errorNombre = comprobarUsuarioNombrel(nombreUsuario);
			boolean errorEmail = comprobarUsuarioEmail(emailUsuario);
			
			if (errorPassReg || errorNombre || errorEmail) {
				request.setAttribute("msg", msg);
				request.setAttribute("error", error);
			}else {
				id = getIdOnDao();
				usuariosDao.insert(new Usuario(id,nombreUsuario,emailUsuario,passUsuario));
				request.setAttribute("nombre", nombreUsuario);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher("usuarioBienvenida.jsp").forward(request, response);
		}
			
		
		
	}

	private long getIdOnDao() {
		return usuarios.size()+1;
	}

	private boolean comprarUsuarioPassReg(String passUsuario, String replyPassUsuario) {
		
		if(passUsuario.contentEquals(replyPassUsuario) && replyPassUsuario.contentEquals(passUsuario)) {
			error = false;
		}
		else {
			error = true ;
		}
		return error;
	}

	private boolean comprobarUsuarioNombrel(String nombreUsuario) {
		if(usuarios.size() > 0) {
			for (Usuario u : usuarios) {
				if ( nombreUsuario.equals( u.getNombre() ) ){
					error = true;
					msg = "Error intentelo con otro nombre de usuario";
				}
			}
			if (error == false) {
				msg = "Ya tenemos un usuario con esta direcion de correo";
			}
		}
		return error;
	}

	private boolean comprobarUsuarioEmail( String emailUsuario) {
		
		if(usuarios.size() > 0) {
			for (Usuario u : usuarios) {
				if ( emailUsuario.equals( u.getEmail() ) ){
					error = true;
					msg = "Ya tenemos un usuario con esta direcion de correo";
				}
			}
			
		}
		return error;
		
	}

}
