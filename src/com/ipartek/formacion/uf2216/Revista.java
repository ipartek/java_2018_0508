package com.ipartek.formacion.uf2216;

public class Revista {

	// Constantes
	public static final int MIN_TITULO = 3;
	public static final int MAX_TITULO = 150;
	public static final int ISBN_TAMANO = 10;
	public static final int MIN_PAG = 1;
	public static final boolean PAPEL = false;
	public static final boolean DIGITAL = true;

	// Atributos
	private String titulo;
	private String isbn;
	private int paginas;
	private boolean formato;

	// Constructores
	public Revista() {
		super();
		this.titulo = " ";
		this.isbn = " ";
		this.paginas = 1;
		this.formato = DIGITAL;

	}

	public Revista(String titulo, String isbn, int paginas, boolean formato) {
		this();
		setTitulo(titulo);
		setIsbn(isbn);
		this.paginas = paginas;
		this.formato = formato;
	}

	// Getters y Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo != null) {
			this.titulo = titulo;
		} else {
			this.titulo = " ";
		}

	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if (isbn != null) {
			this.isbn = isbn;
		} else {
			this.isbn = " ";
		}
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public boolean isFormato() {
		return formato;
	}

	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return "titulo=" + titulo + ", isbn=" + isbn + ", paginas=" + paginas + ", formato="
				+ ((formato) ? "DIGITAL" : "PAPEL") + "\n";
	}

}
