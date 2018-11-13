package com.ipartek.formacion.prestamolibros.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Alumno {
	
	private long id;
	@NotBlank(message="No puede estar vacio")
	@Size(min=2,max=50 ,message="El tamaño tiene que estar entre 2 y 50")
	private String nombre;
	@NotBlank(message="No puede estar vacio")
	@Size(min=2,max=50 ,message="El tamaño tiene que estar entre 2 y 50")
	private String apellidos;
	
	public Alumno() {
		super();
		this.id = -1;
		this.nombre = "";
		this.apellidos = "";
	}

	public Alumno(String nombre, String apellidos) {
		this();
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
