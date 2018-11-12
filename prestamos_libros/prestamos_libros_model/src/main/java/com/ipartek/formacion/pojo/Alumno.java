package com.ipartek.formacion.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Alumno {

	private long id;
	@NotBlank
	@Size(min=2, max=100)
	private String nombre;
	@NotBlank
	@Size(min=2, max=100)
	private String apellidos;

	public Alumno() {
		super();
		this.id = -1;
		this.nombre = "";
		this.apellidos = "";
	}

	public Alumno(long id, String nombre, String apellidos) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

}
