package com.ipartek.formacion.cursos.pojo;

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

	public Profesor(String nombre, String apellidos) {
		this();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
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
		return "Profesor [nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

}
