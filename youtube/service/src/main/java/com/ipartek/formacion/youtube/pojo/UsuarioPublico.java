package com.ipartek.formacion.youtube.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UsuarioPublico {

	private long id;
	
	@NotBlank
	@Size(min=2, max=50)
	private String nombre;

	public UsuarioPublico() {
		super();
		this.id = -1;
		this.nombre = "";
		
	}

	public UsuarioPublico(String nombre) {
		super();
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
		return "UsuarioPublico [id=" + id + ", nombre=" + nombre + "]";
	}
		
}
