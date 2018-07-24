package com.ipartek.formacion.gestor.libros.pojo;

//POJO

public  class Libro {
	
	//Constantes
	public static final int ISBN_MIN_LENGTH=5;
	public static final String ISBN_MIN_EXCEPTION="La longitud minima del ISBN debe ser " + ISBN_MIN_LENGTH; //El mensaje que lanzara la excepcion
	
	//Atributos SIEMPRE SON PRIVATE
	private String titulo;
	private String editoral;
	private String isbn;
	private long id;
	private boolean prestado;
	
	//Constructor
	public Libro() {
		super();//Llama al object
		//this hace referencia a si mismo
		this.id=-1;
		this.titulo="";
		this.isbn="";
		this.prestado=false;
		
	}
	public Libro(long id,String isbn,String titulo, String editoral,  boolean prestado) throws Exception {
		this();/*importante*/
		this.titulo = titulo;
		this.editoral = editoral;
		//this.isbn=isbn;
		setIsbn(isbn);
		this.id = id;
		this.prestado = prestado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditoral() {
		return editoral;
	}

	public void setEditoral(String editoral) {
		this.editoral = editoral;
	}

	public String getIsbn() {
		return isbn;
	}
/**
 * Guardamos el valor del ISBN
 * @param isbn String identificador del libro
 * @throws Exception si ISBN ES NULL O LA LONGITUD ES MENOR QUE 5 
 */
	public void setIsbn(String isbn) throws Exception {
		
		if(isbn !=null && isbn.length() >= ISBN_MIN_LENGTH) {
				this.isbn=isbn;
		}else {
			throw new Exception(ISBN_MIN_EXCEPTION);
		}
		
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	@Override
	public String toString() {

		return "\n -Libro-" + 
				"\n\t Titulo: " + titulo +
				"\n\t Editoral: " + editoral + 
				"\n\t ISBN:  " + isbn + 
				"\n\t ID: " + id +"\n";
	
	}
	


	
	
	
}
