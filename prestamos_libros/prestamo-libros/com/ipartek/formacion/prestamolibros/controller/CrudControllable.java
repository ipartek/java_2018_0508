package com.ipartek.formacion.prestamolibros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CrudControllable {

	final String OP_LISTAR = "1";
	final String OP_GUARDAR = "2";// INSERT id=-1 O UPDATE id>0
	final String OP_ELIMINAR = "3";
	final String OP_IR_FORMULARIO = "4";
	final String ENCODE = "UTF-8";

	public void getParameters(HttpServletRequest request);

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	public void guardar(HttpServletRequest request) throws Exception;

	public void listar(HttpServletRequest request) throws Exception;

	public void irFormulario(HttpServletRequest request) throws Exception;

	public void eliminar(HttpServletRequest request) throws Exception;
}
