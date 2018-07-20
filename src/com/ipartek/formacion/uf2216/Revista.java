package com.ipartek.formacion.uf2216;

public class Revista {

	private long id;
	private String titulo;
	private String isbn;
	private int numeroPaginas;
	private boolean formato; // true == digital false == papel

	public static final long ID_MIN = 0;
	public static final int TITULO_MIN_SIZE = 3;
	public static final int TITULO_MAX_SIZE = 150;
	public static final int ISBN_SIZE = 10;
	public static final int NUMEROPAGINAS_MIN = 1;

	public Revista() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.numeroPaginas = 0;
		this.formato = false;

	}

	public Revista(long id, String titulo, String isbn, int numeroPaginas, boolean formato) throws Exception {
		this();
		this.setId(id);
		this.setTitulo(titulo);
		this.setIsbn(isbn);
		this.setNumeroPaginas(numeroPaginas);
		this.setFormato(formato);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) throws Exception {
		if (id < ID_MIN) {
			throw new Exception("ERROR el campo 'id' es menor que " + ID_MIN);
		} else {
			this.id = id;
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws Exception {

		if (titulo == null) {
			throw new Exception("ERROR el campo 'titulo' es nulo");

		} else if (titulo.length() > TITULO_MIN_SIZE && titulo.length() < TITULO_MAX_SIZE) {
			this.titulo = titulo;

		} else {
			throw new Exception("ERROR el campo 'titulo' tiene un tamaño incorrecto");

		}

	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws Exception {
		if (isbn == null) {
			throw new Exception("ERROR el campo 'isbn' es nulo");

		} else if (isbn.length() == ISBN_SIZE) {
			this.isbn = isbn;

		} else {
			throw new Exception("ERROR el campo 'isbn' tiene un tamaño incorrecto");

		}

	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) throws Exception {
		if (numeroPaginas < NUMEROPAGINAS_MIN) {
			throw new Exception("ERROR el campo 'numero de paginas' es menor que " + NUMEROPAGINAS_MIN);
		} else {
			this.numeroPaginas = numeroPaginas;
		}

	}

	/**
	 * Devuelve el tipo de formato de la revista
	 * 
	 * @return boolean indicando el tipo de formato ( true si es digital , false si
	 *         es papel)
	 */
	public boolean isFormato() {
		return formato;
	}

	/**
	 * Recoge el tipo de formato de la revista indicando por un boolean ( true si es
	 * digital , false si es papel)
	 */
	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		String str="";
		str+="REVISTA " + this.getId()+"\n";
		str+="TITULO     : " + this.getTitulo()+"\n";
		str+="ISBN       : " + this.getIsbn()+"\n";
		str+="Nº PAGINAS : " + this.getNumeroPaginas()+"\n";
		str+="FORMATO    : " + ((this.isFormato()) ? "Digital" : "Papel")+"\n";
		str+="\n";

		return str;
	}

}
