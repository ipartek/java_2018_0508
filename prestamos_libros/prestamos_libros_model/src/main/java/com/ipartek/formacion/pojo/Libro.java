package com.ipartek.formacion.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Libro {

	private long id;
	@NotBlank
	@Size(min=8, max=20)
	private String isbn;
	@NotBlank
	@Size(min=2, max=255)
	private String titulo;
	private Editorial editorial;

	public Libro() {
		super();
		this.id = -1;
		this.isbn = "";
		this.titulo = "";
		this.editorial = new Editorial();
	}

	public Libro(long id, String isbn, String titulo) {
		this();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial=" + editorial + "]";
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
