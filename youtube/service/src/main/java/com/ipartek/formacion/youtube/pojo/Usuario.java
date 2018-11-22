package com.ipartek.formacion.youtube.pojo;

import javax.validation.constraints.Size;

public class Usuario {

	private long id;
	@Size(min = 2, max = 50)
	private String nombre;

	public Usuario() {
		super();
		this.nombre = "";
		this.id = -1;

	}

	public Usuario(String nombre) {
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
		return "Usuario [id=" + id + ", nombre=" + nombre + "]";
	}
	
	

}
