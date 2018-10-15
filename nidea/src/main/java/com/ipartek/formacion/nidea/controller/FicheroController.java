package com.ipartek.formacion.nidea.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ipartek.formacion.nidea.pojo.Alert;

/**
 * Servlet implementation class 'FicheroController'
 * 
 * @see Servlet
 */
@WebServlet("/subida-fichero")
@MultipartConfig
		(fileSizeThreshold = 1024 * 1024 * 2, 	// 2MB
		maxFileSize = 1024 * 1024 * 10, 		// 10MB
		maxRequestSize = 1024 * 1024 * 50) 		// 50MB
public class FicheroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "uploadFiles";

	public FicheroController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("fichero.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Localizar el Path Absoluto de la aplicacion Web
		String appPath = request.getServletContext().getRealPath("");
		
		// constructs path of the directory to save uploaded file
		String savePath = appPath + File.separator + SAVE_DIR;

		// Crea directorio de desgtino si no existe
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		StringBuilder sb = new StringBuilder();
		
		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			
			// refines the fileName in case it is an absolute path
			fileName = new File(fileName).getName();
			part.write(savePath + File.separator + fileName);
			
			sb= new StringBuilder();
			sb.append("Fichero: \t" + fileName);
			sb.append("\nRuta: \t" + savePath + File.separator + fileName);
		}
		
		request.setAttribute("alerta", new Alert(sb.toString(), Alert.SUCCESS));
		getServletContext().getRequestDispatcher("/fichero.jsp").forward(request, response);
	}

	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
