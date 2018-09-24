package com.ipartek.formacion.supermercado.model;

public class Usuario {

	private String nombre;
	private String contrasenya;
	
	public Usuario() {
		super();
		this.nombre = "";
		this.contrasenya = "";
	}

	public Usuario(String nombre, String contrasenya) {
		this();
		this.nombre = nombre;
		this.contrasenya = contrasenya;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	
	
	
}
