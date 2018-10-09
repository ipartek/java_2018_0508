package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CrudControllable {
	
	final String OP_LISTAR = "1";
	final String OP_GUARDAR = "2";	//insert (id == -1) o update (id > 0) dependiendo del id
	final String OP_ELIMINAR = "3";
	final String OP_IR_FORMULARIO = "4";
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void getParameters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void listar(HttpServletRequest request) throws Exception;
	
	public void guardar(HttpServletRequest request);
	
	public void irFormulario(HttpServletRequest request) throws Exception;
	
	public void eliminar(HttpServletRequest request) throws Exception;

}
