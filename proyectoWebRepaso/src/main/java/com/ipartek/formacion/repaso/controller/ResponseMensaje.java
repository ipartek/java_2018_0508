package com.ipartek.formacion.repaso.controller;

import java.util.ArrayList;

public class ResponseMensaje {

	private String mensaje;
	private ArrayList<String> errores;

	public ResponseMensaje() {
		super();
		this.errores = new ArrayList<String>();
		this.mensaje = "Soy una tetera";
	}

	public ResponseMensaje(String mensaje) {
		super();
		this.mensaje = mensaje;

	}

	public ResponseMensaje(String mensaje, ArrayList<String> errorViolation) {
		super();
		this.mensaje = mensaje;
		this.errores = errorViolation;
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

	public void setErrores(ArrayList<String> errorViolation) {
		this.errores = errorViolation;
	}

	@Override
	public String toString() {
		return "ResponseMensaje [mensaje=" + mensaje + ", errorViolation=" + errores + "]";
	}

}
