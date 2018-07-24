package com.ipartek.formacion.pojo;

public 


class LibroElectronico extends Libro {

	private int size; // Kb

	// Constructor
	public LibroElectronico() {
		super();
		this.size = 0;
	}
	
	public LibroElectronico(long id, String titulo, String isbn, String editorial, boolean prestado, int size)
			throws Exception {
		super(id, titulo, isbn, editorial, prestado);
		this.size = size;
	}

	// Getters y Setter
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return super.toString() + "LibroElectronico size=" + size;
	}

}
