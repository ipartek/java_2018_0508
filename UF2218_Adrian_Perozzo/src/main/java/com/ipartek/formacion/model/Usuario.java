package com.ipartek.formacion.model;

public class Usuario {
	
	private String nombre;
	private String contasenya;
	
	public Usuario() {
		super();
		this.nombre = "";
		this.contasenya="";
	}

	public Usuario(String nombre, String contasenya) {
		this();
		this.nombre = nombre;
		this.contasenya = contasenya;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContasenya() {
		return contasenya;
	}

	public void setContasenya(String contasenya) {
		this.contasenya = contasenya;
	}
	

}
