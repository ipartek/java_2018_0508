package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.text.MessageFormat;
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

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/registro")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario>usuarios;
	private UsuarioDAO dao;
	Alert alerta;
       
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = UsuarioDAO.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			usuarios=(ArrayList<Usuario>) dao.getAll();
			HttpSession sesion=request.getSession();
			String idioma = (String)sesion.getAttribute("idioma");			
			Locale locale = new Locale( idioma.split("_")[0] , idioma.split("_")[1] );			
			ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
			String nombre= request.getParameter("nombreRegistro");
			String pass= request.getParameter("pass");
			String pass2= request.getParameter("pass2");
			Usuario u= new Usuario(nombre, pass);
			if (pass.equals(pass2)&&!usuarios.contains(u)) {
				
				
				dao.insert(u);
				sesion.setAttribute("usuario", u);
				alerta.setTexto(MessageFormat.format(idiomas.getString("msj.bienvenida"), nombre));
				alerta.setTipo(Alert.PRIMARY);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
	}

}
