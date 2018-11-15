package com.ipartek.formacion.libros.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;

public class Editorial {
	
	private long id;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String nombre;

	public Editorial() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Editorial(String nombre) {
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
		return "Editorial [id=" + id + ", nombre=" + nombre + "]";
	}

}
