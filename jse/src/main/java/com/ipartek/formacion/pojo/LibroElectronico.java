package com.ipartek.formacion.pojo;

public class LibroElectronico extends Libro {
	
	private int size; //Kb
	
	public LibroElectronico() {
		super();
		this.size = 0;
	}
	
	public LibroElectronico(long id, String isbn, String titulo, String editorial, boolean prestado, int size) throws Exception {
		super(id, isbn, titulo, editorial, prestado);
		this.size = size;
	}
	
	//Getters y setters, no hace falta hacerlo para los demás atributos 
	//de libro porque los hereda del padre
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return super.toString() + "LibroElectronico [size=" + size + "]";
	}

	
	

}
