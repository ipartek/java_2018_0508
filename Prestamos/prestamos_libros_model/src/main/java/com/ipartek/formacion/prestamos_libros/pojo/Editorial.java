package com.ipartek.formacion.prestamos_libros.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Editorial {
	
	private long id;
	
	@NotBlank
	@Size(min=2, max=100)
	private String nombre;
	

	public Editorial() {
		super();
		
	}

	public Editorial(long id, String nombre) {
		super();
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