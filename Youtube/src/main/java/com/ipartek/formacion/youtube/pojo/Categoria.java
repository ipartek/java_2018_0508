package com.ipartek.formacion.youtube.pojo;

public class Categoria {
	
	private long id;
	private String nombre;

	// CONSTRUCTORES
	public Categoria() {
		super();
		this.id = -1;	// No insertada en la BBDD
		this.nombre = "";
	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	//	GETTERS AND SETTERS
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

	// OVERRIDES
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
