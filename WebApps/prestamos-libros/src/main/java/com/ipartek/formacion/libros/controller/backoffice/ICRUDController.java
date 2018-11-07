package com.ipartek.formacion.libros.controller.backoffice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICRUDController {
	
	final String OP_LISTAR = "1";
	final String OP_GUARDAR = "2"; // Insert ID == -1 o Update ID > 0
	final String OP_ELIMINAR = "3";
	final String OP_IR_FORMULARIO = "4";
	
	public void doProcess (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void getParameters (HttpServletRequest request);
	
	public void listar (HttpServletRequest request) throws SQLException, Exception;
	
	public void guardar (HttpServletRequest request) throws SQLException, Exception;
	
	public void irFormularioDeAlta (HttpServletRequest request) throws NumberFormatException, Exception;
	
	public void eliminar (HttpServletRequest request) throws Exception;
	


}
