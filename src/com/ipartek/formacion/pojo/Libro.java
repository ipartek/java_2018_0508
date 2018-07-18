package com.ipartek.formacion.pojo;

import java.util.*;


public class Libro {

	// constantes
	// public final static char SEXO_INDEFINIDO = 'i';

	public static final long ISBN_MIN_LENGTH = 5;
	public static final String ISBN_MIN_EXCEPTION = "El ISBN debe ser mayor o igual que " + ISBN_MIN_LENGTH;
	
	private long id;
	private String isbn;
	private String titulo;
	private String editorial;
	private boolean prestado;
	private Date fechaPrestado;
	private Date fechaDevuelto;
	
	
	// Constructores

	public Libro() {
		super();
		this.id = -1;
		this.titulo = "";
		this.editorial = "";
		this.prestado = false;
		this.fechaPrestado = null;
		this.fechaDevuelto = null;
		}
	
	public Libro(long id, String isbn, String titulo, String editorial) throws Exception {
		this();
		setId(id);
		setIsbn(isbn);
		setTitulo(titulo);
		setEditorial(editorial);
		this.fechaPrestado = null;
		this.fechaDevuelto = null;
	}

	// Getters and Setters
	
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
 * guarda el valor de Isbn
 * @param isbn String identificador del libro
 * @throws Exception si ISBN es null o menor de 5 caracteres
 */
	public void setIsbn(String isbn) throws Exception {
		if ( (isbn!=null) && (isbn.length() >= ISBN_MIN_LENGTH) )
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

	public Date getFechaDevuelto() {
		return fechaDevuelto;
	}

	public void setFechaDevuelto(Date fechaDevuelto) {
		this.fechaDevuelto = fechaDevuelto;
	}

	@Override
	public String toString() {
		return "libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial=" + editorial + ", prestado="
				+ prestado + ", fechaPrestado=" + fechaPrestado + ", fechaDevuelto=" + fechaDevuelto + "]";
	}
			
}