package com.ipartek.formacion.uf2216;



public class Revista {
	
	public static final int TITULO_MIN_LENGTH = 3;
	public static final int TITULO_MAX_LENGTH = 150;
	public static final int ISBN_LENGTH = 10;
	public static final int PAGINAS_MIN_LENGTH = 1;
	
	public static final String TITULO_MENSAJE_EXCEPTION = "El título debe contener entre " + TITULO_MIN_LENGTH + 
			" y " + TITULO_MAX_LENGTH + " caracteres";
	
	public static final String ISBN_MENSAJE_EXCEPTION = "El ISBN debe contener " + ISBN_LENGTH + " caracteres";
	
	public static final String PAGINAS_MENSAJE_EXCEPTION = "La revista debe tener al menos " + PAGINAS_MIN_LENGTH + " pagina/s";
	
	private String titulo;
	private String isbn;
	private int nPaginas;
	private boolean formato;
	
	
	public Revista() {
		super();
		this.titulo = "";
		this.isbn = "";
		this.nPaginas = 0;
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
	public void setnPaginas(int nPaginas) throws Exception {

		if(nPaginas >= PAGINAS_MIN_LENGTH) {
			this.nPaginas = nPaginas;
			
		}else {
			throw new Exception(PAGINAS_MENSAJE_EXCEPTION);
		}
		
	}
	public boolean isFormato() {
		return formato;
	}
	public void setFormato(boolean formato) {
		this.formato = formato;
	}

}
