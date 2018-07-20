package com.ipartek.formacion.uf2216;

public class Revistas {
	
	private String titulo;
	private String isbn;
	private int paginas;
	private String formato; //si lo ponía boolean me daba problemas en el gestor de revistas...
                            // ...y al final he decidido ponerlo string para que funcionase bien	
	
	public Revistas() {
		
		super();
		this.titulo="";
		this.isbn="";
		this.paginas=1;
		this.formato="";
	}
	
	public Revistas(String titulo, String isbn, int paginas, String formato) {
		
		this();
		this.titulo=titulo;
		this.isbn=isbn;
		this.paginas=paginas;
		this.formato=formato;
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getformato() {
		return formato;
	}

	public void setformato(String isbn) {
		this.isbn = formato;
	}

	@Override
	public String toString() {
		return "Revistas [titulo=" + titulo + ", isbn=" + isbn + ", paginas=" + paginas + ", formato=" + formato + "]";
	}
	
	

}
