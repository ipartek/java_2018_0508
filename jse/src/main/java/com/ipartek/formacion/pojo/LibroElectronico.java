package com.ipartek.formacion.pojo;

public class LibroElectronico extends Libro {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5000783294062772982L;
	private int size;// Kb

	// Constructores
	public LibroElectronico() {
		super();
		this.size = 0;
	}

	public LibroElectronico(long id, String isbn, String titulo, String editorial, boolean prestado, int size)
			throws Exception {
		super(id, isbn, titulo, editorial, prestado);
		this.size = size;
	}

	// Getters y Setters
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
