package com.ipartek.formacion.pojo;

public class Libro {

	private static final int MIN_LONG_ISBN = 5;
	private static final String MENSAJE_ERROR_ISBN = "La longitud del ISBN debe ser mayor que " + MIN_LONG_ISBN;

	private long id;
	private String titulo;
	private String autor;
	private String editorial;
	private String isbn;
	private int numPaginas;
	private boolean prestado;

	// CONSTRUCTORES
	public Libro() {
		super();
		this.id = -1;
		this.titulo = "";
		this.autor = "";
		this.editorial = "";
		this.isbn = "";
		this.numPaginas = 0;
		this.prestado = false;
	}

	public Libro(long id, String titulo, String autor, String editorial, String isbn, int numPaginas, boolean prestado)
			throws Exception {
		this();
		this.id = id;
		this.titulo = titulo.trim();
		this.autor = autor;
		this.editorial = editorial.trim();
		setIsbn(isbn);
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
			this.editorial = editorial.trim();
		}
	}

	public String getIsbn() {
		return isbn;
	}

	/**
	 * Método que establece el ISBN del libro.
	 * 
	 * @param isbn, String
	 * @throws Exception si ISBN == null || ISBN.lenght() < 5
	 */
	public void setIsbn(String isbn) throws Exception {
		if (isbn != null && isbn.trim().length() >= MIN_LONG_ISBN) {
			this.isbn = isbn.trim();
		} else {
			throw new Exception(MENSAJE_ERROR_ISBN);
		}

	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
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
				+ isbn + ", numPaginas=" + numPaginas + ", prestado=" + prestado + "]";
	}

	

}
