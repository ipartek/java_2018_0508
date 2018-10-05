package com.ipartek.formacion.pojo;

public class Rol {
	private long id;
	private String nombre;
	
	public Rol() {
		super();
		id = -1;
		nombre = "";
	}

	public Rol(String nombre) {
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
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}
}
