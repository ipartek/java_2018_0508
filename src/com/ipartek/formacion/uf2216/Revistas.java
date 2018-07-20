package com.ipartek.formacion.uf2216;

public class Revistas {

	private static final int ISBN_LENGHT = 10;
	private static final String ISBN_EXCEPTION = null;
	private long id;
	private String titulo;
	private String isbn;
	private int numPaginas;
	private boolean digital;

	public Revistas() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.numPaginas = 0;
		this.digital = false;
	}

	public Revistas(long id, String titulo, String isbn, int numPaginas, boolean digital) throws Exception {
		this();
		this.id = id;
		this.titulo = titulo;
		setIsbn(isbn);
		this.numPaginas = numPaginas;
		this.digital = digital;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws Exception {
		if (titulo != null) {
			titulo = titulo.trim();
			this.titulo = titulo;
		} else {
			throw new Exception();
		}
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws Exception {
		if (isbn != null && isbn.trim().length() == ISBN_LENGHT) {
			this.isbn = isbn;
		} else {
			throw new Exception(ISBN_EXCEPTION);
		}
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public boolean isDigital() {
		return digital;
	}

	public void setDigital(boolean digital) {
		this.digital = digital;
	}

	@Override
	public String toString() {
		return "Revistas [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", numPaginas=" + numPaginas
				+ ", digital=" + digital + "]";
	}

}
