package com.ipartek.formacion.uf2216;

public class Revista {

	private static int ISBN_LONG = 10;
	private static String ISBN_LONG_EXCEPTION = "La longitud a de ser de " + ISBN_LONG;

	private static final int TITULO_MIN_LENGTH = 3;
	private static final int TITULO_MAX_LENGTH = 150;
	private static String TITULO_EXCEPTION = "La longitud mínima debe de ser " + TITULO_MIN_LENGTH + " y la máxima de "
			+ TITULO_MAX_LENGTH;

/*	private static final int PAGINAS_MIN_EXCEPTION = 1;
	private static String PAGINAS_EXCEPTION = "El número de páginas mínimo a de ser " + PAGINAS_MIN_EXCEPTION;*/

	private long id;
	private String titulo;
	private String isbn;
	private int paginas;
	private boolean formato;

	public Revista() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.paginas = 0;
		this.formato = false;
	}

	public Revista(long id, String titulo, String isbn, int paginas, boolean formato) {
		this();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.paginas = paginas;
		this.formato = formato;
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

	public void setIsbn(String isbn) throws Exception {
		
		if (isbn != null ) {
			this.isbn = isbn;
		} else {
			throw new Exception(ISBN_LONG_EXCEPTION);
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws Exception {
		
		if (titulo != null) {
			this.titulo = titulo;
		}else {
			throw new Exception(TITULO_EXCEPTION);
		}
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) throws Exception {
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
		return "IDENTIFICADOR: " + id + " TÍTULO: " + titulo + " ISBN: " + isbn + " PÁGINAS: " + paginas + " FORMATO: "
				+ formato;
	}

}