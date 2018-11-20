package com.ipartek.formacion.gestor.libros.pojo;

public class Libro {
	public static final int ISBN_MIN_LENGTH = 5;
	public static final String ISBN_MIN_EXCEPTION = "La longitud minima del isbn es de 5 caracteres ";

	private long id;
	private String isbn;
	private String titulo;
	private String editorial;
	private boolean prestado;

	public Libro() {
		super();
		this.id = -1;
		this.titulo = "";
		this.editorial = "";
		this.prestado = false;
	}

	public Libro( String isbn,String titulo, String editorial, boolean prestamo) throws Exception {
		this();
		this.titulo = titulo;
		this.editorial = editorial;
		this.prestado = prestamo;
		setIsbn(isbn);
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

	/**
	 * guardamos el valor en la variable
	 * 
	 * @param isbn String identificador del libro
	 * @throws Exception si ISBN == null|| ISBN.length < ISBN_MIN_LENGTh
	 */

	public void setIsbn(String isbn) throws Exception {

		if (isbn != null && isbn.length() >= ISBN_MIN_LENGTH) {
			this.isbn = isbn;
		} else {
			throw new Exception(ISBN_MIN_EXCEPTION);
		}

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial=" + editorial + ", prestado="
				+ prestado + "]";
	}

}