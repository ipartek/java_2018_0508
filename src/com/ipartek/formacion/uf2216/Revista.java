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

	private long id;
	private String titulo;
	private String isbn;
	private int numPaginas;
	private boolean esDigital;

	public Revista() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.numPaginas = 0;
		this.esDigital = false;
	}

	public Revista(long id, String titulo, String isbn, int numPaginas, boolean esDigital) {
		this();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.numPaginas = numPaginas;
		this.esDigital = esDigital;
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
		String resul = "Revista [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", numPaginas=" + numPaginas;
		if(esDigital == true)
			resul += ", esDigital=Digital]";
		else
			resul += ", esDigital=Papel]";
		
		return resul;
	}

}
