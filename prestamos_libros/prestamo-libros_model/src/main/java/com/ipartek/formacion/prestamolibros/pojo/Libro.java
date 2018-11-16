package com.ipartek.formacion.prestamolibros.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Libro {

	private long id;

	@NotBlank(message = "No puede estar vacio")
	@Size(min = 2, max = 50, message = "El tamaño tiene que estar entre 2 y 50")
	private String titulo;

	@NotBlank(message = "No puede estar vacio")
	@Size(min = 2, max = 50, message = "El tamaño tiene que estar entre 2 y 50")
	private String isbn;

	private Editorial editorial;

	public Libro() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.editorial = new Editorial();

	}

	public Libro(long id, String titulo, String isbn, Editorial editorial, boolean prestrado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.editorial = editorial;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", editorial=" + editorial + ", prestado="
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (id != other.id)
			return false;
		return true;
	}

	

	
	
	
	

}
