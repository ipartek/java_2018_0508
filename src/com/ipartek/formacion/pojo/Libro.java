package com.ipartek.formacion.pojo;

import java.util.Date;

import com.ipartek.formacion.herencia.Imprimible;
import com.ipartek.formacion.herencia.Serializable;

public class Libro implements Serializable, Imprimible{

	public static final int ISBN_MIN_LENGTH = 5;
	public static final String ISBN_MIN_EXCEPTION = "La longitud minima del ISBN tiene que ser " + ISBN_MIN_LENGTH;

	private long id;
	private String isbn;
	private String titulo;
	private String editorial;
	private boolean prestado;
	private Date fechaPrestado;
	private Date fechaDevolucion;

	public Libro() {
		super();
		this.id = -1;
		this.isbn = "";
		this.titulo = "";
		this.editorial = "";
		this.prestado = false;
		this.fechaPrestado = null;
		this.fechaDevolucion = null;
	}

	public Libro(long id, String isbn, String titulo, String editorial, boolean prestado) throws Exception {
		//Cuando en un constructor con param no se añaden todas las variables que existen
		this();
		this.id = id;
		setIsbn(isbn);
		this.titulo = titulo;
		this.editorial = editorial;
		this.prestado = prestado;
	}

	public Libro(String isbn, String titulo, String editorial, boolean prestado) throws Exception {
		this();
		setIsbn(isbn);
		this.titulo = titulo;
		this.editorial = editorial;
		this.prestado = prestado;
	}

	public Libro(long id, String isbn, String titulo, String editorial, boolean prestado, Date fechaPrestado,
			Date fechaDevolucion) {
		this();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.prestado = prestado;
		this.fechaPrestado = fechaPrestado;
		this.fechaDevolucion = fechaDevolucion;
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
	 * @param isbn String identificador de libro
	 * @throws Exception si ISBN == null || ISBN.length() < ISBN_MIN_LENGTH
	 */
	public void setIsbn(String isbn) throws Exception {
		// if (isbn.length() < ISBN_MIN_LENGTH || isbn == null)
		if (isbn != null && isbn.trim().length() >= ISBN_MIN_LENGTH)
			this.isbn = isbn;
		else
			throw new Exception(ISBN_MIN_EXCEPTION);
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
	
	public Date getFechaPrestado() {
		return fechaPrestado;
	}

	public void setFechaPrestado(Date fechaPrestado) {
		this.fechaPrestado = fechaPrestado;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial=" + editorial + ", prestado="
				+ prestado + "]";
	}

	@Override
	public void imprimir() {
		
	}

}
