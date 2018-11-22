package com.ipartek.formacion.gestiondocente.pojo;

public class Profesor {

	private String nombre;
	private String apellidos;

	public Profesor() {
		super();

		this.nombre = "";
		this.apellidos = "";

	}

	public Profesor(String nombre, String apellidos) {
		this();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
