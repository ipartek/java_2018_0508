package com.ipartek.formacion.libreria;

public class Libro {

	private static final int ISBN_MIN_LENGHT = 5;
	private static final String ISBN_MIN_EXCEPTION = "Debe de contener mas de 5 caracteres";
	private long id;
	private String isbn;
	private String titulo;
	private String editorial;
	private boolean prestado;

	public Libro() {
		super();
		this.id = -1;
		this.isbn = "";
		this.titulo = "";
		this.editorial = "";
		this.prestado = false;
	}

	public Libro(long id, String isbn, String titulo, String editorial, boolean prestado) throws Exception {
		this();
		this.id = id;
		setIsbn(isbn);
		this.titulo = titulo;
		this.editorial = editorial;
		this.prestado = prestado;
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
	 * Guardamos el valor del ISBN
	 * 
	 * @param isbn String identificador del Libro
	 * @throws Exception si ISBN == null || ISBN.lenght < ISBN_MIN_LENGHT
	 */
	public void setIsbn(String isbn) throws Exception {
		if (isbn != null && isbn.trim().length() >= ISBN_MIN_LENGHT) {
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
