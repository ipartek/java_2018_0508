package com.ipartek.formacion.prestamos.api.controller;

import java.util.Set;
import java.util.TreeSet;

public class ResponseMensaje {
	
	private String mensaje;
	private Set<String> errores;

	public ResponseMensaje() {
		super();
		this.mensaje = "Soy una tetera";
		this.errores = new TreeSet<String>();
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
	
	public Set<String> getErrores() {
		return errores;
	}

	public void setErrores(Set<String> errores) {
		this.errores = errores;
	}
	
	public void addError( String error) {
		this.errores.add(error);
	}

	@Override
	public String toString() {
		return "ResponseMensaje [mensaje=" + mensaje + "]";
	}
	
}
