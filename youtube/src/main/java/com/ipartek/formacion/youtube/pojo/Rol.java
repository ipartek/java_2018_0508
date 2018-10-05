package com.ipartek.formacion.youtube.pojo;

public class Rol {

	private long id;
	private String nombre;

	public Rol() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Rol(long id, String nombre) {
		this();
		this.id = id;
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
