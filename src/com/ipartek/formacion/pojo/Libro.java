package com.ipartek.formacion.pojo;

public class Libro {

	private static final String EXCEPTION_MESSAGE_ISBN = "ERROR tiene que contener al menos 5 caracteres de tamaño";
	private static final int ISBN_MIN_SIZE = 5;
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
		setId(id);
		setIsbn(isbn);
		setTitulo(titulo);
		setEditorial(editorial);
		setPrestado(prestado);
		
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
	 * @param isbn String identificador del libro
	 * @throws Exception si ISBN == null or ISBN < ISBN_MIN_SIZE
	 */
	public void setIsbn(String isbn) throws Exception {
		if (isbn.trim().length() < ISBN_MIN_SIZE || isbn == null) {
			throw new Exception(EXCEPTION_MESSAGE_ISBN);

		} else {
			this.isbn = isbn;
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
