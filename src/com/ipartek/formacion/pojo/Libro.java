package com.ipartek.formacion.pojo;

public class Libro {

	private static final int MIN_LONG_ISBN = 5;

	long id;
	String titulo;
	String autor;
	String editorial;
	String isbn;
	int numPaginas;
	boolean prestado;

	// CONSTRUCTORES
	public Libro() {
		super();
	}

	public Libro(long id, String titulo, String autor, String editorial, String isbn, int numPaginas,
			boolean prestado) {
		this();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
		this.numPaginas = numPaginas;
		this.prestado = prestado;
	}

	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo != null && !titulo.trim().isEmpty()) {
			this.titulo = titulo.trim();
		}
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (autor != null && !autor.trim().isEmpty()) {
			this.autor = autor.trim();
		}
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		if (editorial != null && !editorial.trim().isEmpty()) {
			this.editorial = editorial;
		}
	}

	public String getIsbn() {
		return isbn;
	}

	/**
	 * Método que establece el ISBN del libro. Lanza una excepción si este es menor
	 * que 5.
	 * 
	 * @param isbn, String
	 * @throws Exception
	 */
	public void setIsbn(String isbn) throws Exception {
		if (isbn != null && isbn.trim().length() > MIN_LONG_ISBN) {
			this.isbn = isbn.trim();
		} else {
			throw new Exception("La longitud del ISBN debe ser mayor que 5");
		}

	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", isbn="
				+ isbn + ", prestado=" + prestado + "]";
	}

}
