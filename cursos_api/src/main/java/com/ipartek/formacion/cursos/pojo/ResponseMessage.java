package com.ipartek.formacion.cursos.pojo;

import java.util.ArrayList;

public class ResponseMessage {

	private String mensaje;

	private ArrayList<String> errores;

	public ResponseMessage() {

		super();
		this.mensaje = "ERROR: Inesperado.";
		this.errores = null;
	}
	
	public ResponseMessage(String mensaje) {

		super();
		this.mensaje = mensaje;
		this.errores = null;
	}
	
	public ResponseMessage(String mensaje, ArrayList<String> errores) {
		super();
		this.mensaje = mensaje;
		this.errores = errores;
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

	@Override
	public String toString() {
		return "ResponseMessage [mensaje=" + mensaje + ", errores=" + errores + "]";
	}
	
	// TODO: Errores.

}
