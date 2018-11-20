package com.ipartek.formacion.libros.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Libro implements Cloneable {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	private long id;
	
	@NotBlank
	@Size(min = 3, max = 150)
	private String titulo;
	
	@NotBlank
	@Size(min = 13, max = 20)
	private String isbn;
	
	private Editorial editorial;
	
	
	public Libro() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.editorial = new Editorial();
	}
	
	public Libro(String titulo, String isbn, int n_ejemplares, Editorial editorial) {
		this();
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
		return "Libro [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", editorial=" + editorial + "]";
	}



	
	

}