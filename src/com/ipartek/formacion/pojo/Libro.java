package com.ipartek.formacion.pojo;

/**
 * 
 * Pojo de Libros<br>
 * --------------<br>
 * Atributos: <br>
 * private long id; <br>
 * private String isbn; <br>
 * private String titulo; <br>
 * private String editorial; <br>
 * private boolean prestado; <br>
 * 
 * Si se termina crear los siguientes atributos:<br>
 * private date fechaInicioPrestamo;<br>
 * private date fechaFinPrestamo;<br>
 * 
 * Crear una validacion que sea:<br>
 * Si el ISBN es menor que 5 o es null trows new exception.<br>
 * 
 * @author Ainara
 *
 */

public class Libro implements Cloneable {

	private static final int ISBN_MIN_LENGTH = 5;
	private static String ISBN_MIN_EXCEPTION = "La longitud mínima debe de ser " + ISBN_MIN_LENGTH;

	// Atributos encapsulados.
	private long id;
	private String isbn;
	private String titulo;
	private String editorial;
	private boolean prestado;
	// private date fechaInicio
	// private date fechaFin

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
	 * Guardamos el valor de ISBN
	 * 
	 * @param isbn String identificador del libro
	 * @throws Exception si el ISBN == null||ISBN.length < ISBN_MIN_LENGTH
	 */

	public void setIsbn(String isbn) throws Exception {
		if (isbn != null && isbn.length() > ISBN_MIN_LENGTH) {
			// isbn = isbn.trim();
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
		return "Identificador: " + id + "\t" + " ISBN: " + isbn + "\t" + " Título: " + titulo + "\t" + " Editorial: "
				+ editorial + "\t" + " Prestado: " + prestado + "\t" + "";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
