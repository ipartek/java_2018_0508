package com.ipartek.formacion.prestamos.api.controller;

public class ResponseMensaje {

	private String mensaje;

	public ResponseMensaje() {
		super();
		this.mensaje = "Soy una tetera";
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

	@Override
	public String toString() {
		return "ResponseMensaje [mensaje=" + mensaje + "]";
	}

}
