package com.ipartek.formacion.uf2216;

import java.io.Serializable;

public class Revista implements Serializable {

	static private final boolean DIGITAL = true;
	static private final boolean PAPEL = false;

	private int id;
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

	public Revista(int id, String titulo, String isbn, int numPag, boolean formato) {
		this();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.numPag = numPag;
		this.formato = formato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return "Revista [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", numPag=" + numPag + ", formato="
				+ formato + "]";
	}

}
