package com.ipartek.formacion.uf2216;

import java.io.File;
import java.io.Serializable;

public class Revista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Atributos
	private String titulo;
	private String isbn;
	private int numPag;
	private boolean formato;

	// Constructores
	public Revista() {
		super();
		this.titulo = "";
		this.isbn = "";
		this.numPag = 1;
		this.formato = false;

	}

	public Revista(String titulo, String isbn, int numPag, boolean formato) {
		this();
		this.setTitulo(titulo);
		this.setIsbn(isbn);
		this.setNumPag(numPag);
		this.setFormato(formato);

	}

	// Getters y Setters

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

	// metodos

	public boolean escribirFichero(File fichero, Revista revist) {
		boolean result = false;

		return result;

	}

	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", isbn=" + isbn + ", numPag=" + numPag + ", formato=" + formato + "]";
	}

}
