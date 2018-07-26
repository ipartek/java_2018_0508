package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.libros.model.LibroArrayDAO;
import com.ipartek.formacion.gestor.libros.pojo.Libro;

@WebServlet("/listar")

public class PrestamosController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	static private int ULTIMO_ID = 1;
	static LibroArrayDAO dao;
	
//	private static final Logger LOG = Logger.getLogger(name);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			System.out.println("Pasamos por doGet");
			
			// 1.- Recibir Parametros
			
			
			
			// 2.- Validar Parametros
			
			
			
			// 3.- LLamar modelo DAO
			
			dao = LibroArrayDAO.getInstance();
			
			dao.insert(new Libro(ULTIMO_ID, "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA",
					"9788416001460", "LIBROS DEL K.O", true));
			ULTIMO_ID++;
			dao.insert(new Libro(ULTIMO_ID, "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED", "9788467575057",
					"EDICIONES SM", false));
			ULTIMO_ID++;
			dao.insert(new Libro(ULTIMO_ID, "MATEMÁTICAS TRIMESTRAL SAVIA-15", "9788467575071", "EDICIONES SM", false));
			ULTIMO_ID++;
			dao.insert(new Libro(ULTIMO_ID, "LA VOZ DE TU ALMA", "9788461716098", "AUTOR-EDITOR", true));
			ULTIMO_ID++;
			dao.insert(new Libro(ULTIMO_ID, "LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014 ",
					"9788467569957", "EDICIONES SM", false));
			ULTIMO_ID++;
			dao.insert(new Libro(ULTIMO_ID, "NEW HIGH FIVE 1 PUPILS BOOK PACK", "9781380013835",
					"MACMILLAN CHILDRENS BOOKS", false));
			ULTIMO_ID++;
			dao.insert(new Libro(ULTIMO_ID, "NEW HIGH FIVE 3 PUPILS BOOK", "9781380011718", "MACMILLAN CHILDRENS BOOKS",
					false));
			ULTIMO_ID++;
			
			// 4.- Enviar atributos a la vista
			
			request.setAttribute("biblioteca", dao.getAll());
			
			// 5.- Ir a la vista
			
			request.getRequestDispatcher("listado.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
