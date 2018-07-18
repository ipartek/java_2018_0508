package com.ipartek.formacion.pojo;
/**
 * 
 * @author Curso
 *
 */
public class Libro {
	
	public static final int ISBN_MIN_LENGTH = 5;
	public static final String ISBN_MIN_EXCEPTION = "La longitud minima debe ser 5";
	
	private long id;
	private String isbn;
	private String titulo;
	private String editorial;
	private boolean prestado;

	
	public Libro() {
		super();
		this.id = id;
		this.isbn = "";
		this.titulo = "";
		this.editorial = "";
		this.prestado = false;
	}

	public Libro(long id, String isbn, String titulo, String editorial, boolean prestado) {
		this();
		this.id = id;
		this.isbn = isbn;
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
 * Se controla que el valor no se nulo y que no tenga menos de 5
 * @param isbn
 * @throws Exception
 */
	public void setIsbn(String isbn) throws Exception {
		//controlar primero el null
		if (isbn != null && isbn.length() >= ISBN_MIN_LENGTH) {
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

}
