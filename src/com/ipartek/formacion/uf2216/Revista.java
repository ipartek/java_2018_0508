package com.ipartek.formacion.uf2216;

public class Revista {
	
	//CONSTANTES
	public static final int TITULO_MIN_LENGTH = 3;
	public static final int TITULO_MAX_LENGTH = 150;
	public static final int ISBN_LENGTH = 10;
	public static final int NUM_MIN_PAGINAS = 1;
	public static final boolean FORMATO_DIGITAL = true;
	public static final boolean FORMATO_PAPEL = false;
	
	//ATRIBUTOS
	private String titulo;
	private String isbn;
	private int numPaginas;
	private boolean formato;
	
	public Revista() {
		super();
		this.titulo = "";
		this.isbn = "";
		this.numPaginas = -1;
		this.formato = false;
	}
	
	public Revista(String titulo, String isbn, int numPaginas, boolean formato) {
		this();
		this.titulo = titulo;
		this.isbn = isbn;
		this.numPaginas = numPaginas;
		this.formato = formato;
	}

	//GETTERS Y SETTERS
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

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public boolean isFormato() {
		return formato;
	}

	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", isbn=" + isbn + ", numPaginas=" + numPaginas + ", formato=" + formato
				+ "]";
	}
	
}
