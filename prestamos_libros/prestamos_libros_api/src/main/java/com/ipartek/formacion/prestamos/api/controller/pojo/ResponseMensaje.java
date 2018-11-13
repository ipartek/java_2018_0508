package com.ipartek.formacion.prestamos.api.controller.pojo;

import java.util.ArrayList;

public class ResponseMensaje {
	private String mensaje;
	private ArrayList<String> errores;

	public ResponseMensaje() {
		super();
		this.mensaje = "";
		this.errores = new ArrayList<String>();

	}

	public ResponseMensaje(String mensaje) {		
		this();
		this.mensaje = mensaje;
	}

	public ArrayList<String> getErrores() {
		return errores;
	}



	public void setErrores(ArrayList<String> errores) {
		this.errores = errores;
	}



	

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void addError(String error) {
		this.errores.add(error);
	}

	@Override
	public String toString() {
		return "ResponseMensaje [mensaje=" + mensaje + "]";
	}

}
