package com.ipartek.formacion.libros.controller.backoffice;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.service.ServicePrestamo;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/backoffice/inicio")
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String VISTA_PRINCIPAL = "prestamos/index.jsp";
	
	private static ServicePrestamo servicioPrestamo;
	
	private static final String OP_LISTAR = "1";
	private static final String OP_PRESTAR = "2"; // Insert ID == -1 o Update ID > 0
	private static final String OP_DEVOLVER = "3";
	
	private static Alert alert;
	
	private static String op;
	
	private static String libro;
	private static String alumno;
	private static String fechaInicio;
	private static String fechaFinal;
	private static String fechaRetorno;
	     
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		servicioPrestamo = ServicePrestamo.getInstance();
	}
	
	
	public void destroy() {
		
		super.destroy();
		servicioPrestamo = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request,response);
	}
	

	
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			getParameters(request);
			
			if (op != null) {
    			
    			switch (op) {
    			case OP_LISTAR:
    				
    				listarActivos(request);
    				break;
    			
    			case OP_DEVOLVER:
    				
    				devolver(request);
    				break;
    				
    			case OP_PRESTAR:
    				
    				prestar(request);
    				break;
    						
    			default:
					
					listarActivos(request);
					break;
				}
    			
    		}		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		} finally {

			request.getSession().setAttribute("alert", alert);
			response.sendRedirect(VISTA_PRINCIPAL);
		}
		
	}

	
	public void getParameters(HttpServletRequest request) {
		
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
    	
    	alumno = request.getParameter("idAlumno");
    	libro = request.getParameter("idLibro");
    	fechaInicio = request.getParameter("fechaInicio");
    	fechaRetorno = request.getParameter("fechaRetorno");
    	fechaFinal = request.getParameter("fechaFinal");
		
	}



	public void listarActivos(HttpServletRequest request) throws SQLException, Exception {
		
		request.getSession().setAttribute("prestamos", servicioPrestamo.prestamosActivos());
		
	}



	public void prestar(HttpServletRequest request) throws SQLException, Exception {
		
		String startDate=fechaInicio;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(startDate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		
		servicioPrestamo.prestar(Long.parseLong(alumno), Long.parseLong(libro), sqlStartDate);
		
	}


	public void devolver(HttpServletRequest request) throws Exception {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
		String startDate=fechaFinal;
		String endDate=fechaRetorno;
		
		java.util.Date sartdate = sdf1.parse(startDate);
		java.sql.Date sqlStartDate = new java.sql.Date(sartdate.getTime());
		
		
		java.util.Date enddate = sdf1.parse(endDate);
		java.sql.Date sqlEndDate = new java.sql.Date(enddate.getTime());
		
		servicioPrestamo.devolver(Long.parseLong(alumno), Long.parseLong(libro), sqlStartDate, sqlEndDate);
		
	}

}
