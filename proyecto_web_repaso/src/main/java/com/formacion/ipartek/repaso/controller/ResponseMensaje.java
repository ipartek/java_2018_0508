package com.formacion.ipartek.repaso.controller;

import java.util.ArrayList;

public class ResponseMensaje {
	
	private String mensaje;
	private ArrayList<String> errores;

	public ResponseMensaje() {
		super();
		mensaje = "Soy una tetera";
		errores = new ArrayList<String>();
	}

	public ResponseMensaje(String mensaje) {
		this();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ArrayList<String> getErrores() {
		return errores;
	}

	public void setErrores(ArrayList<String> errores) {
		this.errores = errores;
	}
	
	public void addError(String e) {
		this.errores.add(e);
	}

	@Override
	public String toString() {
		return "ResponseMensaje [mensaje=" + mensaje + "]";
	}
}
