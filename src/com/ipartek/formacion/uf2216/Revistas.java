package com.ipartek.formacion.uf2216;

public class Revistas {

	public static final int ISBN_MIN_LENGTH = 10;
	public static final String ISBN_MIN_EXCEPTION = "La longitud minima del isbn es de 10 caracteres ";

	public static final int PAGINAS_MIN_LENGTH = 1;
	public static final String PAGINAS_MIN_EXCEPTION = "Los numeros de paginas debe ser  minimo de 1 pagina  ";

	public static final int TITULO_MIN_LENGTH = 3;
	public static final int TITULO_MAX_LENGTH = 150;
	public static final String TITULO_EXCEPTION = "El titulo tiene que ser entre 3 y 150 caracteres";

	private long id;
	private String titulo;
	private String isbn;
	private int paginas;
	private boolean formato;

	public Revistas() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.paginas = 0;
		this.formato = false;

	}

	public Revistas(String titulo, String isbn, int paginas, boolean formato) throws Exception {
		this();
		setTitulo(titulo);
		setIsbn(isbn);
		setPaginas(paginas);
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

	public void setTitulo(String titulo) throws Exception {

		if (titulo.length() > TITULO_MIN_LENGTH && titulo.length() < TITULO_MAX_LENGTH) {
			this.titulo = titulo;
		} else {
			throw new Exception(TITULO_EXCEPTION);
		}
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws Exception {

		if (isbn != null && isbn.length() <= ISBN_MIN_LENGTH) {
			this.isbn = isbn;
		} else {
			throw new Exception(ISBN_MIN_EXCEPTION);
		}

	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) throws Exception {

		if (paginas != 0 && paginas >= PAGINAS_MIN_LENGTH) {
			this.paginas = paginas;
		} else {
			throw new Exception(PAGINAS_MIN_EXCEPTION);
		}

	}

	public boolean isFormato() {
		return formato;
	}

	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		String f = "";
		if (formato == true) {
			f = "digital";
		} else if (formato == false) {
			f = "papel";
		}

		return "Revistas [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", paginas=" + paginas + ", formato="
				+ f + "]";
	}

}
