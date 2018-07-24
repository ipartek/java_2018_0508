package com.ipartek.formacion.pojo;

public class LibroElectornico extends Libro {

	private int size; //Kb
	
	public LibroElectornico() {
		super();
		this.size = 0;		
	}

	
	
	public LibroElectornico(long id, String isbn, String titulo, String editorial, boolean prestado, int size) throws Exception {
		super(id, isbn, titulo, editorial, prestado);
		this.size = size;		
	}



	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return  " LibroElectornico [size=" + size + "]" + super.toString();
	}
	
	
}
