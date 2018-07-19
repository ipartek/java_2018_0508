package com.ipartek.formacion.pojo;

import java.util.Calendar;
import java.util.Date;

public class Libro {
	private static final int ISBN_LENGHT = 5;
	private static final String MENSAJE_EXCEPTION_ISBN = "El ISBN DE ESTE LIBRO NO ES CORRECTO";
	private static final int DIAS_PRESTAMO = 10;

	private long id;
	private String isbn;
	private String titulo;
	private String editorial;
	boolean prestado;

	// Constructores
	public Libro() {
		super();
		this.id = 0;
		this.isbn = "";
		this.titulo = "";
		this.editorial = "";
		this.prestado = true;

	}

	public Libro(long id, String isbn, String titulo, String editorial, boolean prestado)

			throws Exception {
		this();
		this.setId(id);
		this.setIsbn(isbn);
		this.setTitulo(titulo);
		this.setEditorial(editorial);
		this.setPrestado(prestado);

	}

	// Getters y setters

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
	 * Seteamos el valor del isbn del libro
	 * 
	 * @param isbn String El isbn que se desea asignar a un libro
	 * @throws Exception en caso de que el isbn sea null o con una longitud menor
	 *                   que ISBN_LENGHT
	 */
	public void setIsbn(String isbn) throws Exception {
		if (isbn != null && isbn.trim().length() > ISBN_LENGHT) {
			this.isbn = isbn;
		} else {
			throw new Exception(MENSAJE_EXCEPTION_ISBN);
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

	// Metodos

	@Override
	public String toString() {
		return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial=" + editorial + ", prestado="
				+ prestado + "]";
	}

	public Date calcularPrestamo(Date fechaActual) {
		Date fechaEntrega = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
		calendar.add(Calendar.DAY_OF_YEAR, DIAS_PRESTAMO);
		fechaEntrega = calendar.getTime();
		return fechaEntrega;

	}
}
