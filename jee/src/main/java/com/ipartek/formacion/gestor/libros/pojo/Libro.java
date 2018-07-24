package com.ipartek.formacion.gestor.libros.pojo;

import java.util.Calendar;

public class Libro {
	
	public static final int ISBN_MIN_LENGTH = 5;
	public static final String ISBN_MENSAJE_EXCEPTION = "La longitud mínima del ISBN debe ser " + ISBN_MIN_LENGTH;
	
	Calendar calendar = Calendar.getInstance();
	
	private long id;
	private String isbn;
	private String titulo;
	private String editorial;
	private boolean prestado;
	private String inicioPrestamo;
	private String finPrestamo;
	
	
	public Libro() {
		super();
		this.id = -1;
		this.isbn = "";
		this.titulo = "";
		this.editorial = "";
		this.prestado = false;
		this.inicioPrestamo = calendar.get(Calendar.DATE) + " / " + calendar.get(Calendar.MONTH) + " / " + calendar.get(Calendar.YEAR);
	}

	public Libro(long id, String isbn, String titulo, String editorial, boolean prestado) throws Exception {
		this();
		this.setId(id);
		this.setIsbn(isbn);
		this.setTitulo(titulo);
		this.setEditorial(editorial);
		this.setPrestado(prestado);
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
	 * Guardamos el valor de isbn
	 * @param isbn String identificador del libro
	 * @throws Exception si el isbn es null o menor que 5
	 */
	public void setIsbn(String isbn) throws Exception {
		
		if(isbn != null && isbn.trim().length() >= ISBN_MIN_LENGTH) {
			this.isbn = isbn;
		}else {
			throw new Exception(ISBN_MENSAJE_EXCEPTION);
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

	public String getInicioPrestamo() {
		return inicioPrestamo;
	}

	public void setInicioPrestamo(String inicioPrestamo) {
		this.inicioPrestamo = inicioPrestamo;
	}

	public String getFinPrestamo() {
		return finPrestamo;
	}

	public void setFinPrestamo(String finPrestamo) {
		this.finPrestamo = finPrestamo;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial=" + editorial + ", prestado="
				+ prestado + "]";
	}

}
