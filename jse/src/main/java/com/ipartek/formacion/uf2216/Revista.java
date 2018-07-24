package com.ipartek.formacion.uf2216;



public class Revista {
	
	public static final int TITULO_MIN_LENGTH = 3;
	public static final int TITULO_MAX_LENGTH = 150;
	public static final int ISBN_LENGTH = 10;
	public static final int PAGINAS_MIN_LENGTH = 1;
	
	public static final String TITULO_MENSAJE_EXCEPTION = "El título debe contener entre " + TITULO_MIN_LENGTH + 
			" y " + TITULO_MAX_LENGTH + " caracteres";
	
	public static final String ISBN_MENSAJE_EXCEPTION = "El ISBN debe contener " + ISBN_LENGTH + " caracteres";
	
	private String titulo;
	private String isbn;
	private int nPaginas;
	private boolean formato;
	
	
	public Revista() {
		super();
		this.titulo = "";
		this.isbn = "";
		this.nPaginas = PAGINAS_MIN_LENGTH;
		this.formato = false;
	}
	
	
	public Revista(String titulo, String isbn, int nPaginas, boolean formato) throws Exception {
		this();
		this.setTitulo(titulo);
		this.setIsbn(isbn);
		this.setnPaginas(nPaginas);
		this.setFormato(formato);
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Guardamos el valor del título de la revista
	 * @param titulo String título de la revista
	 * @throws Exception si el titulo es null, si es menor que 3 o si es mayor que 150 caracteres.
	 */
	public void setTitulo(String titulo) throws Exception {
		
		if(titulo != null && titulo.trim().length() >= TITULO_MIN_LENGTH && 
				titulo.trim().length() <= TITULO_MAX_LENGTH) {
			
			this.titulo = titulo;
			
		}else {
			throw new Exception(TITULO_MENSAJE_EXCEPTION);
		}
		
		
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	/**
	 * Guardamos el valor del isbn de la revista
	 * @param titulo String identificador de la revista
	 * @throws Exception si el isbn es null o si no contiene 10 caracteres exactos.
	 */
	public void setIsbn(String isbn) throws Exception {
		
		if(isbn != null && isbn.trim().length() == ISBN_LENGTH) {
			this.isbn = isbn;
			
		}else {
			throw new Exception(ISBN_MENSAJE_EXCEPTION);
		}
		
		
	}
	
	public int getnPaginas() {
		return nPaginas;
	}
	
	public void setnPaginas(int nPaginas) {

		if(nPaginas >= PAGINAS_MIN_LENGTH) {
			this.nPaginas = nPaginas;
			
		}else {
			this.nPaginas = PAGINAS_MIN_LENGTH;
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
		return "Revista [titulo=" + titulo + ", isbn=" + isbn + ", nPaginas=" + nPaginas + ", formato=" + formato + "]";
	}

}
