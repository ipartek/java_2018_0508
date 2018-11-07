package com.ipartek.formacion.prestamos_libros.pojo;

public class Editorial {
	private long id;
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
