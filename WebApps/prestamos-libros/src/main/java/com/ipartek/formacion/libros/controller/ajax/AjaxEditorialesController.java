package com.ipartek.formacion.libros.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.libros.model.EditorialDAO;


@WebServlet("/editoriales")
public class AjaxEditorialesController extends HttpServlet {
	
	EditorialDAO daoEditorial;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		daoEditorial = EditorialDAO.getInstance();
	}

	@Override
	public void destroy() {

		super.destroy();
		daoEditorial = null;
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out = response.getWriter();
			
			Gson gson = new Gson();
	        
			String jsonStudents = gson.toJson(daoEditorial.getAll());
				
			out.print(jsonStudents);
				
			out.flush();		
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
