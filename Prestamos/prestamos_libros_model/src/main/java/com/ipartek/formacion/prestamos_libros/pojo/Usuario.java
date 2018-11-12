package com.ipartek.formacion.prestamos_libros.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Usuario {

	@NotBlank
	@Size(min = 2, max = 150)
	private Long id;
	private String nombreApellido;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombreApellido) {
		super();
		this.id = id;
		this.nombreApellido = nombreApellido;

	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreApellido=" + nombreApellido + "]";
	}

}
