package com.ipartek.formacion.pojo;

public class LibroElectronico extends Libro {

	// Atributos
	private int size;

	
	public LibroElectronico() {
		super();
		this.size = 0;
	}
	
	public LibroElectronico(long id, String isbn, String titulo, String editorial, boolean prestado, int size) throws Exception {
		super(id, isbn, titulo, editorial, prestado);
		this.size = size;
	}



	// getters and setters

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return super.toString() + "LibroElectronico [size=" + size + "]";
	}; // Kb
	
	
	
}
