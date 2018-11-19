package com.ipartek.formacion.prestamos_libros.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CrudControllable {
	static final String OP_LISTAR = "1";
	static final String OP_GUARDAR = "2"; //Insert o update en funcion del id (-1 o >0)
	static final String OP_ELIMINAR = "3";
	static final String OP_IR_FORMULARIO = "4";
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void getParameters(HttpServletRequest request);
	
	public void listar(HttpServletRequest request);
	
	public void irFormulario(HttpServletRequest request) throws Exception;
	
	public void guardar(HttpServletRequest request) throws Exception;
	
	public void eliminar(HttpServletRequest request) throws Exception;
}