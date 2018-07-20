package com.ipartek.formacion.uf2216;

public class Revista {

	public static final int TITULO_MIN_LENGTH = 3;
	public static final int TITULO_MAX_LENGTH = 150;
	public static final int ISBN_LENGTH = 10;
	public static final int NUM_PAGINAS_MIN = 1;

	public static final String TITULO_LENGTH_EXCEPTION = "El titulo tiene que tener más de " + TITULO_MIN_LENGTH
			+ " caracteres y menos de " + TITULO_MAX_LENGTH;

	public static final String ISBN_LENGTH_EXCEPTION = "El ISBN debe tener " + ISBN_LENGTH + " caracteres exactos";

	public static final String NUM_PAGINAS_EXCEPTION = "La revista debe tener al menos " + NUM_PAGINAS_MIN + " pagina";

	private String titulo;
	private String isbn;
	private int numPaginas;
	private boolean esDigital;

	public Revista() {
		super();
		this.titulo = "";
		this.isbn = "";
		this.numPaginas = 0;
		this.esDigital = false;
	}

	public Revista(String titulo, String isbn, int numPaginas, boolean esDigital) throws Exception{
		this();
		this.titulo = titulo;
		this.isbn = isbn;
		this.numPaginas = numPaginas;
		this.esDigital = esDigital;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws Exception {
		if (titulo != null && titulo.length() >= 3 && titulo.length() <= 150)
			this.titulo = titulo;
		else
			throw new Exception(TITULO_LENGTH_EXCEPTION);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws Exception {
		if (isbn != null && isbn.length() == 10)
			this.isbn = isbn;
		else
			throw new Exception(ISBN_LENGTH_EXCEPTION);
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) throws Exception {
		if (numPaginas >= 1)
			this.numPaginas = numPaginas;
		else
			throw new Exception(NUM_PAGINAS_EXCEPTION);
	}

	public boolean isEsDigital() {
		return esDigital;
	}

	public void setEsDigital(boolean esDigital) {
		this.esDigital = esDigital;
	}

	@Override
	public String toString() {
		String resul = "Revista con titulo: " + titulo + "\n ISBN: " + isbn + "\n Número de páginas: " + numPaginas;
		if(esDigital == true)
			resul += "\n Formato: Digital";
		else
			resul += "\n Formato: Papel";
		
		return resul;
	}

}
