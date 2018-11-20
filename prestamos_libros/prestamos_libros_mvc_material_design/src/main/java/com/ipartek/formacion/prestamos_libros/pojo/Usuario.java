package com.ipartek.formacion.prestamos_libros.pojo;

public class Usuario {
	
	private Long id;
	private String nombre_apellidos;
	
	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombre_apellidos) {
		super();
		this.id = id;
		this.nombre_apellidos = nombre_apellidos;
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_apellidos() {
		return nombre_apellidos;
	}
	public void setNombre_apellidos(String nombre_apellidos) {
		this.nombre_apellidos = nombre_apellidos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre_apellidos=" + nombre_apellidos + "]";
	}

}
