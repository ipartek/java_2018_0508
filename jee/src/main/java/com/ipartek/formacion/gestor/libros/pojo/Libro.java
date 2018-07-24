package com.ipartek.formacion.gestor.libros.pojo;

//import java.util.Date;

public class Libro {
	
	//CONSTANTES
	public static final int ISBN_MIN_LENGTH = 5;
	public static final String ISBN_MIN_EXCEPTION = "La longitud minima del isbn debe ser " + ISBN_MIN_LENGTH;

	//ATRIBUTOS
	private long id;
	private String isbn;
	private String titulo;
	private String editorial;
	private boolean prestado;
	//private Date inicioPrestamo;
	//private Date finPrestamo;
	
	public Libro() {
		super();
		this.id = -1;
		this.isbn = "";
		this.titulo = "";
		this.editorial = "";
		this.prestado = false;
	}
	
	public Libro(long id, String isbn, String nombre, String editorial, boolean prestado) throws Exception {
		this();
		this.id = id;
		//this.isbn = isbn;
		setIsbn(isbn);
		this.titulo = nombre;
		this.editorial = editorial;
		this.prestado = prestado;
	}

	//GETTERS Y SETTERS
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
	 * Metodo set que comprueba si el ISBN es nulo o menor a 5
	 * Si lo es, manda una excepcion
	 * Si no, guarda el ISBN
	 * @param isbn
	 * @throws Exception
	 */
	public void setIsbn(String isbn) throws Exception {
		if(isbn != null && isbn.trim().length() >= ISBN_MIN_LENGTH) {
			this.isbn = isbn;
		}else {
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
		return "Libro [id=" + id + ", isbn=" + isbn + ", nombre=" + titulo + ", editorial=" + editorial + ", prestado="
				+ prestado + "]";
	}
	
}
