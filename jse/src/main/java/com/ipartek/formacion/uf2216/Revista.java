package com.ipartek.formacion.uf2216;

/**
 * Clase que gestiona "POJO" del tipo Revista.
 * 
 * @see https://es.wikipedia.org/wiki/Plain_Old_Java_Object
 * @author Curso
 *
 */
public class Revista {

	// CONSTANTES DE CLASE
	protected static final int MIN_LONG_TITULO = 3;
	protected static final int MAX_LONG_TITULO = 150;

	protected static final int LONG_ISBN = 10;

	protected static final int MIN_NUM_PAGINAS = 1;

	// VARIABLES DE CLASE
	private long id;

	private String titulo;
	private String isbn;

	private int numPaginas;

	private boolean formato;

	// CONSTRUCTORES
	public Revista() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.numPaginas = 1;
		this.formato = false;
	}

	public Revista(long id, String titulo, String isbn, int numPaginas, boolean formato) {
		super();
		this.id = id;
		setTitulo(titulo);
		setIsbn(isbn);
		setNumPaginas(numPaginas);
		this.formato = formato;
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

	/**
	 * Establece el título de la revista.
	 * 
	 * @param titulo, cadena de caracteres
	 * @throws RevistaException, si titulo.length < 3 || titulo.length >150
	 */
	public void setTitulo(String titulo) throws RevistaException {
		if (titulo != null && titulo.length() >= MIN_LONG_TITULO && titulo.length() <= MAX_LONG_TITULO) { // Longitud
																											// correcta

			this.titulo = titulo;
		} else {

			throw new RevistaException("Longitud del título errónea.");
		}
	}

	public String getIsbn() {
		return isbn;
	}

	/**
	 * Establece el ISBN de la Revista
	 * 
	 * @param isbn, entero
	 * @throws RevistaException, si ISBN tiene menos de LONG_ISBN digitos
	 * @SE
	 */
	public void setIsbn(String isbn) throws RevistaException {

		if (isbn.length() == LONG_ISBN) { // Longitud correcta

			this.isbn = isbn;
		} else { // Longitud incorrecta

			throw new RevistaException("Longitud del ISBN errónea.");
		}
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	/**
	 * Establece el número de páginas de la revista.
	 * 
	 * @param numPaginas, entero
	 * @throws RevistaException, si numPaginas < MIN_NUM_PAGINAS
	 */
	public void setNumPaginas(int numPaginas) throws RevistaException {
		if (numPaginas >= MIN_NUM_PAGINAS) { // Número de páginas correcto

			this.numPaginas = numPaginas;
		} else { // Número de páginas incorrecto

			throw new RevistaException("Número de páginas erróneo.");
		}

	}

	public boolean isFormato() {
		return formato;
	}

	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	// OTROS MÉTODOS Y FUNCIONES
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.titulo);
		sb.append(" - ");
		
		sb.append(this.isbn);
		sb.append(" - ");
		
		sb.append(this.numPaginas);
		sb.append(" pags. - ");
		
		
		if (this.formato) {
			sb.append("Formato .EPUB");
		} else {
			sb.append("Formato Papel");
		}
		
		
		return sb.toString();
	}

}
