package com.ipartek.formacion.gestiondocentes.pojo;

public class Profesor {
	private long codigo;
	private String nombre;
	private String apellidos;
	
	public Profesor() {
		super();
		this.codigo = -1;
		this.nombre = "";
		this.apellidos = "";
	}

	public Profesor(long codigo, String nombre, String apellidos) {
		this();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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

	@Override
	public String toString() {
		return "Profesor [codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

}
