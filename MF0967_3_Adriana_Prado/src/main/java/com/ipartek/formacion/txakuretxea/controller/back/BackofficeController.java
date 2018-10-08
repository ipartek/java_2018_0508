package com.ipartek.formacion.txakuretxea.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.txakuretxea.model.PerroDAO;
import com.ipartek.formacion.txakuretxea.pojo.Alert;

/**
 * Servlet implementation class BackofficeController
 */
@WebServlet("/backoffice/home")
public class BackofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static PerroDAO daoPerro = null;
	
	private static final String VIEW_INDEX = "home.jsp";
	
	private Alert alert = null;
	private String view = "";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoPerro = PerroDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoPerro = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		alert = null;
		
		try {
			if(daoPerro.getAll().size() == 0) {
				alert = new Alert(Alert.ALERT_WARNING, "No se han encontrado perros.");
			}
			view = VIEW_INDEX;
			request.setAttribute("perros", daoPerro.getAll());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}
}
