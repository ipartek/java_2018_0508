package com.ipartek.formacion.uf2216;

public class Revista {
	//Constantes
		public static final int ISBN_MAX_LENGTH=10;
		public static final String ISBN_MAX_EXCEPTION="La longitud maxima del ISBN debe ser " + ISBN_MAX_LENGTH; //El mensaje que lanzara la excepcion
		public static final boolean DIGITAL=true;
		public static final boolean PAPEL=false;
	//Atributos
		private String titulo;
		private String isbn;
		private int numPaginas;
		private boolean formato;
		
		
		
	//Constructor
		public Revista() {
			super();//Llama al object
			//this hace referencia a si mismo
			this.titulo="";
			this.isbn="";
			this.numPaginas=1;
			this.id=-1;
			this.formato=DIGITAL;
			
		}
		public Revista(String titulo, String isbn, int numPaginas, long id,boolean formato) throws Exception {
			this();
			this.titulo = titulo;
			//this.isbn = isbn;
			setIsbn(isbn);
			this.numPaginas = numPaginas;
			this.id=id;
			this.formato = formato;
		}
	
		
	
		//GETTERS Y SETTERS
		public String getTitulo() {
			return titulo;
		}
		
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		
		public String getIsbn() {
			return isbn;
		}
		
		/**
		 *  Guardamos el valor del ISBN
		 * @param isbn String identificador de la revista
		 * @throws Exception si ISBN ES NULL O LA LONGITUD ES MAYOR QUE 10
		 */
		public void setIsbn(String isbn)  {
			/*TODO QUE HAGO CON ESTO*/
			/*if(isbn !=null && isbn.length() <= ISBN_MAX_LENGTH) {
				this.isbn=isbn;
			}else {
				throw new Exception(ISBN_MAX_EXCEPTION);
			}*/
			this.isbn=isbn;
		}
		
		public int getNumPaginas() {
			return numPaginas;
		}
		
		public void setNumPaginas(int numPaginas) {
			this.numPaginas = numPaginas;
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
		public boolean isFormato() {
			return formato;
		}
		
		public void setFormato(boolean formato) {
			this.formato = formato;
		}
}
