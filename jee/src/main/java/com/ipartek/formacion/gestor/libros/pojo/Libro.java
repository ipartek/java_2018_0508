package com.ipartek.formacion.gestor.libros.pojo;

import java.util.Date;

public class Libro {

	public static final int ISBN_MIN_LENGTH = 5;
	public static final String ISBN_MIN_EXCEPTION = "La longitud minima del ISBN debe ser " + ISBN_MIN_LENGTH;

	private long id;
	private String isbn;
	private String titulo;
	private String editorial;
	private boolean prestado;
	private Date fechaPrestamo;
	private Date fechaDevolucion;

	public Libro() {
		super();
		this.isbn = "";
		this.titulo = "";
		this.editorial = "";
		this.id = -1;
		this.prestado = false;

	}

	public Libro(String isbn, String titulo, String editorial, boolean prestado) throws Exception {
		this();
		setIsbn(isbn);
		this.titulo = titulo;
		this.editorial = editorial;
		this.prestado = prestado;
	}

	public Libro(long id, String isbn, String titulo, String editorial, boolean prestado) throws Exception {
		super();
		this.id = id;
		setIsbn(isbn);
		this.titulo = titulo;
		this.editorial = editorial;
		this.prestado = prestado;
	}

	public String getIsbn() {
		return isbn;
	}

	/**
	 * Guardamos el valor del isbn
	 * 
	 * @param isbn String indentificador del Libro
	 * @throws Exception si el isbn es nulo o es menor de ISBN_MIN_LENGTH
	 */
	public void setIsbn(String isbn) throws Exception {

		if (isbn != null && isbn.trim().length() >= ISBN_MIN_LENGTH) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {

		this.id = id;
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
				+ prestado + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + "]";
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	/**
	 * obtener hora y fecha con formato:
	 * 
	 * @param fechaPrestamo
	 */
	public void setFechaPrestamo(Date fechaPrestamo) {

		this.fechaPrestamo = fechaPrestamo;

	}

}
