package com.ipartek.formacion.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Editorial {
	private long id;
	
	@NotBlank
	@Size(min=2, max=50)
	private String nombre;
	
	public Editorial() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Editorial(long id, String nombre) {
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
		return "Editorial [id=" + id + ", nombre=" + nombre + "]";
	}
}