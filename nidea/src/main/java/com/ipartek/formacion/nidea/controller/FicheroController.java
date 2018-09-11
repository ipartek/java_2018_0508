package com.ipartek.formacion.nidea.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ipartek.formacion.nidea.pojo.Alert;

/**
 * Servlet implementation class FicheroController
 */
@WebServlet("/subida-fichero")
@MultipartConfig(   fileSizeThreshold=1024*1024*2, 	// 2MB file’s size that is greater than this threshold will be directly written to disk, instead of saving in memory
					maxFileSize=1024*1024*10,      // 10MB maximum size for a single upload file
					maxRequestSize=1024*1024*50)   // 50MB maximum size for a request
public class FicheroController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "uploadFiles";
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("fichero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Path Absoluto App Web
	        String appPath = request.getServletContext().getRealPath("");
	        
	        // Path para guardar ficheros
	        String savePath = appPath + File.separator + SAVE_DIR;
	         
	        // crea directorio si no existe
	        File fileSaveDir = new File(savePath);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdir();
	        }
	         
	        //lectura ficheros, PUEDEN SUBIR VARIOS DE GOLPE
	        for (Part part : request.getParts()) {
	        	
	        	//leer fichero subido
	            String fileName = extractFileName(part);	            
	            fileName = new File(fileName).getName();
	            part.write(savePath + File.separator + fileName);
	            
	            //Mensaje Alert
	            StringBuilder mensaje = new StringBuilder();
	            mensaje.append("Fichero Subido con exito<br>");
	            mensaje.append("Nombre: " + fileName + "<br>");	           
	            mensaje.append("Directorio: " + savePath + File.separator + fileName );
	            request.setAttribute("alert", new Alert(Alert.SUCCESS, mensaje.toString() ));
	        }
	        
	       
		}catch (Exception e) {
			request.setAttribute("alert", new Alert(Alert.DANGER, e.getMessage() ));
		}  finally {
			 getServletContext().getRequestDispatcher("/fichero.jsp").forward(request, response);
		}
    }
    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

}