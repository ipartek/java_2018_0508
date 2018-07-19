package com.ipartek.formacion.pojo;
/**
 * Herencia
 * @author Curso
 *
 */
public  class LibroElectronico extends Libro {
	private int size; //kb
	
	void encenderluz() {
		System.out.println("Luz encendida");
	}

	public LibroElectronico() {
		super();
		this.size = 0;
		
	}

	public LibroElectronico(long id, String isbn, String titulo, String editorial, boolean prestado, int size) {
		super(id, isbn, titulo, editorial, prestado);
		this.size = 0;
	}

	@Override
	public String toString() {
		return super.toString()+  "LibroElectronico [size=" + size + "]";
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
