package com.ipartek.formacion.uf2216;

public class Revista {
	
	private String titulo;		// tamaño mínimo 3 letras, máximo 150
	private String isbn;		// string de longitud 10
	private int paginas;		// mínimo 1
	private boolean formato;	// true == digital     false == papel

	public final static int TITULO_MIN_LONG = 3 ;
	public final static int TITULO_MAX_LONG = 150 ;
	
	public final static int PAGINAS_MIN = 1 ;

	public final static int ISBN_LENGTH = 10 ;
	public static final String ISBN_LENGTH_EXCEPTION = "El ISBN debe tener 10 numeros de longitud" + ISBN_LENGTH;	

	
	// Constructores
	public Revista() {
		super();
		this.titulo = "";
		this.isbn = "";
		this.paginas = -1;
		this.formato = false;
		
	}

	public Revista(String titulo, String isbn, int paginas, boolean formato) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.paginas = paginas;
		this.formato = formato;
	}

	// Getters and setters
	public String getTitulo() {
		return titulo;
	}


	public boolean setTitulo(String titulo) throws Exception {
		
		boolean correcto = false;
		
		if ( titulo != null ) {
			titulo = titulo.trim();				
			if ( (titulo.length()>=TITULO_MIN_LONG) && (titulo.length()<=TITULO_MAX_LONG) )  {
				this.titulo = titulo;
				correcto = true;
			}else {
				throw new Exception( "El titulo debe estar entre " + TITULO_MIN_LONG + " y " + TITULO_MAX_LONG + "caracteres" );
			}
		} else {
			throw new Exception( "NULL_Exception introduciendo titulo" );
		}	
		
		return correcto;
	}


	public String getIsbn() {
		return isbn;
	}

/*
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
*/
	
	public void setIsbn(String isbn) throws Exception {
		
		if ( isbn != null ) {
			isbn = isbn.trim();				
			if ( isbn.length() != ISBN_LENGTH) {
				throw new Exception( "El ISBN debe tener 10 numeros de longitud" );
			}else {
				this.isbn = isbn;
			}
		} else {
			throw new Exception( "NULL_Exception introduciendo ISBN" );
		}	
		
		
	}

	public int getPaginas() {
		return paginas;
	}


	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}


	public boolean isFormato() {
		return formato;
	}


	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	// Metodo toString propio para la clase.
	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", isbn=" + isbn + ", paginas=" + paginas + ", formato=" + formato + "]";
	}
	
	
	

}
