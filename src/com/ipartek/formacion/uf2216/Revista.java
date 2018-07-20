package com.ipartek.formacion.uf2216;

public class Revista {
	
	//CONSTANTES
	public static final int TITULO_MIN_LENGTH = 3;
	public static final int TITULO_MAX_LENGTH = 150;
	public static final String TITULO_LENGTH_EXCEPTION = "La longitud del Titulo deber ser entre 3 y 150 caracteres.";
	public static final int ISBN_LENGTH = 10;
	public static final String ISBN_LENGTH_EXCEPTION = "La longitud del ISBN debe ser exactamente de 10 numeros.";
	public static final int NUM_MIN_PAGINAS = 1;
	public static final String NUM_MIN_PAGINAS_EXCEPTION = "El numero minimo de paginas de la revista debe ser superior a 1.";
	public static final boolean FORMATO_DIGITAL = true;
	public static final boolean FORMATO_PAPEL = false;
	public static final String FORMATO_EXCEPTION = "El formato de la revista debe ser true (Digital) o false (Papel)";
	
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
	
	public Revista(String titulo, String isbn, int numPaginas, boolean formato) throws Exception {
		this();
		setTitulo(titulo);
		setIsbn(isbn);
		setNumPaginas(numPaginas);
		setFormato(formato);
	}

	//GETTERS Y SETTERS
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo set que comprueba si el Titulo es nulo o si su longitud es mayor a 3 y menor a 150
	 * Si lo es, guarda el Titulo
	 * Si no, manda una excepcion
	 * @param titulo
	 * @throws Exception
	 */
	public void setTitulo(String titulo) throws Exception {
		if(titulo != null && titulo.length() > TITULO_MIN_LENGTH && titulo.length() < TITULO_MAX_LENGTH) {
			this.titulo = titulo;
		}else {
			throw new Exception(TITULO_LENGTH_EXCEPTION);
		}
		
	}

	public String getIsbn() {
		return isbn;
	}

	/**
	 * Metodo set que comprueba si el ISBN es nulo o igual a 10
	 * Si lo es, guarda el ISBN
	 * Si no, manda una excepcion
	 * @param isbn
	 * @throws Exception
	 */
	public void setIsbn(String isbn) throws Exception {
		if(isbn != null && isbn.trim().length() == ISBN_LENGTH) {
			this.isbn = isbn;
		}else {
			throw new Exception(ISBN_LENGTH_EXCEPTION);
		}
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	/**
	 * Metodo set que comprueba que el numero de paginas es mayor al minimo establecido (1)
	 * Si lo es, guarda el Numero de paginas
	 * Si no, manda una excepcion
	 * @param numPaginas
	 * @throws Exception
	 */
	public void setNumPaginas(int numPaginas) throws Exception {
		if(numPaginas > NUM_MIN_PAGINAS) {
			this.numPaginas = numPaginas;
		}else {
			throw new Exception(NUM_MIN_PAGINAS_EXCEPTION);
		}
		
	}

	public boolean isFormato() {
		return formato;
	}

	/**
	 * Metodo que comprueba si el formato es true (Digital) o false (Papel)
	 * Si lo es, guarda el formato
	 * Si no, manda una excepcion
	 * @param formato
	 * @throws Exception
	 */
	public void setFormato(boolean formato) throws Exception {
		if(formato == FORMATO_DIGITAL || formato == FORMATO_PAPEL) {
			this.formato = formato;
		}else {
			throw new Exception(FORMATO_EXCEPTION);
		}
		
	}

	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", isbn=" + isbn + ", numPaginas=" + numPaginas + ", formato=" + formato
				+ "]";
	}
	
}
