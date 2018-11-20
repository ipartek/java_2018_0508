package com.ipartek.formacion.prestamos_libros.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Libro {
	private long id;
	@NotBlank
	@Size(min=2, max=100)
	private String titulo;
	private String isbn;
	private Editorial editorial;
	
	public Libro() {
		
	}

	public Libro(long id, String titulo, String isbn, Editorial editorial) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.editorial = editorial;
	}

	public Long getId() {
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
		return "Libro [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", editorial=" + editorial + "]";
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
