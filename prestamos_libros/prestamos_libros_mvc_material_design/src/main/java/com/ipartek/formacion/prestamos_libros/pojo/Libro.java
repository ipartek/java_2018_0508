package com.ipartek.formacion.prestamos_libros.pojo;

public class Libro {
	private Long id;
	private String titulo;
	private String isbn;
	private Editorial editorial;
	
	public Libro() {
		
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
