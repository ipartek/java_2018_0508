package com.ipartek.formacion.uf2216;

/**
 * 
 * @author Curso Pojo revistas
 */
public class Revistas {

	public static final int TITTLE_MIN_LENGTH = 3;
	public static final int TITTLE_MAX_LENGTH = 150;
	public static final String TITTLE_MIN_EXCEPTION = "La longitud del titulo debe tener mas de 3 caracteres y menos de 150 caracteres";
	public static final int ISBN_MIN_LENGTH = 10;
	public static final String ISBN_MIN_EXCEPTION = "La longitud debe contener 10 caracteres";

	private long id;
	private String isbn;
	private String titulo;
	private int nPaginas;
	boolean formatoPapel; // false = papel true = digital
	String formatoPapel2;

	public Revistas() {
		super();
		this.id = -1;
		this.isbn = "";
		this.titulo = "";
		this.formatoPapel2 = "";
		this.nPaginas = 1;
	}

	public Revistas(long id, String isbn, String titulo, String formatoPapel, int nPaginas) {
		this();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.formatoPapel2 = formatoPapel;
		this.nPaginas = nPaginas;
	}

	public boolean getFormatoPapel() {
		return formatoPapel;
	}

	public void setFormatoPapel(boolean formatoPapel) {

		this.formatoPapel = formatoPapel;

	}

	public int getnPaginas() {
		return nPaginas;
	}

	public void setnPaginas(int nPaginas) {
		if (nPaginas > 0) {
			this.nPaginas = nPaginas;

		}
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

	/**
	 * Se controla que el valor no se nulo y que no tenga menos de 5
	 * 
	 * @param isbn
	 * @throws Exception
	 */
	public void setIsbn(String isbn) throws Exception {
		// controlar primero el null
		if (isbn != null && isbn.length() >= ISBN_MIN_LENGTH) {
			this.isbn = isbn;
		} else {
			throw new Exception(ISBN_MIN_EXCEPTION);
		}

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws Exception {
		// controlar primero el null
		/**
		 * Controlamos que el titulo sea mayor de 3 caracteres y menor de 150 caracteres
		 */
		if (isbn != null && titulo.length() >= TITTLE_MIN_LENGTH && titulo.length() <= TITTLE_MAX_LENGTH) {
			this.titulo = titulo;
		} else {
			throw new Exception(TITTLE_MIN_EXCEPTION);
		}

	}

	@Override
	public String toString() {
		return "Revistas [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", nPaginas=" + nPaginas
				+ ", formatoPapel2=" + formatoPapel2 + "]";
	}
}
