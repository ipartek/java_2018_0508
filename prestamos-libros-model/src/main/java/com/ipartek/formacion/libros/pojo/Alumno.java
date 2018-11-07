package com.ipartek.formacion.libros.pojo;

public class Alumno {
	
	private long id;
	private String nombre;
	
	public Alumno() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Alumno(String nombre) {
		this();
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
