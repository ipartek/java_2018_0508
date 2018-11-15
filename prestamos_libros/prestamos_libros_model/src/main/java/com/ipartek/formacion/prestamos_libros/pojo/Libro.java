package com.ipartek.formacion.prestamos_libros.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Libro {
	
	private Long id;
	
	@NotBlank
	@Size(min=2, max=45)
	private String titulo;
	
	@NotBlank
	@Size(min=6, max=18)
	private String isbn;
		
	private Editorial editorial;
	
	public Libro() {
		super();
		this.id = (long) -1;
		this.titulo = "";
		this.isbn = "";
		this.editorial = new Editorial();
	}

	public Libro(Long id, String titulo, String isbn, Editorial editorial) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.editorial = editorial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}
