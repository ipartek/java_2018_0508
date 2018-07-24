import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saludo")
public class SaludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RequestDispatcher dispatch = null;
	private static String VIEW_INDEX = "index.jsp";
	private static String VIEW_SALUDO = "saludo.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("pasamos por doGet");
		
		try {
			dispatch = request.getRequestDispatcher(VIEW_INDEX);
			
			// 1.recibir parametros
			String nombre = request.getParameter("nombre");
			String ap1 = request.getParameter("ap1");
			String ap2 = request.getParameter("ap2");

			// 2.validar parametros

			// 3.llamar modelo DAO

			// 4.enviar atributos a la vista
			request.setAttribute("nombre", nombre);
			request.setAttribute("ap1", ap1);
			request.setAttribute("ap2", ap2);

			// 5.ir a la vista

			//request.getRequestDispatcher("saludo.jsp").forward(request, response);
			
			dispatch = request.getRequestDispatcher(VIEW_SALUDO);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dispatch.forward(request, response);
		}


		// TODO hacer un nuevo controlador que tenga de mapping saludo y sele envie un
		// parametro "nombre" por get
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		// 1.recibir parametros
		String nombre = request.getParameter("nombre");
		
		// 2.validar parametros
		if(nombre=="") {
			request.setAttribute("mensaje", "Introduce un nombre");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		// 3.llamar modelo DAO

		// 4.enviar atributos a la vista
		request.setAttribute("nombre", nombre);

		// 5.ir a la vista
		
		request.getRequestDispatcher("saludo.jsp").forward(request, response);

	}

}
