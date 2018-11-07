package com.ipartek.formacion.prestamos.api.controller;

public class ResponseMensaje {

	private String mensaje;
	private String[] errores;

	public ResponseMensaje() {
		super();
		this.mensaje = "Soy una tetera";
	}

	public String[] getErrores() {
		return errores;
	}

	public void setErrores(String[] errores) {
		this.errores = errores;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "ResponseMensaje [mensaje=" + mensaje + "]";
	}

}
