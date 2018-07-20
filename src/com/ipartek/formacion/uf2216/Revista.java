package com.ipartek.formacion.uf2216;

public class Revista {

	private long id;
	private String titulo;
	private String isbn;
	private int numPag;
	private boolean formato;

	public Revista() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.numPag = 0;
		this.formato = false;

	}

	public Revista(long id, String titulo, String isbn, int numPag, boolean formato) {
		this();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.numPag = numPag;
		this.formato = formato;
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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public boolean isFormato() {
		return formato;
	}

	public void setFormato(boolean formato) {

		this.formato = formato;
	}

	@Override
	public String toString() {
		String d = "Digital";
		String p = "Papel";
		String atributos = "";
		if (this.formato) {
			atributos = "Revista " + id + ": titulo: " + titulo + ", isbn: " + isbn + ", numPag: " + numPag
					+ ", formato: " + d;
		} else {
			atributos = "Revista " + id + ": titulo: " + titulo + ", isbn: " + isbn + ", numPag: " + numPag
					+ ", formato: " + p;
		}

		return atributos;

	}

}
