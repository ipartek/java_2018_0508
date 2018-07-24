package com.ipartek.formacion.pojo;

public class LibroElectronico extends Libro {

	private int size; // kb

	public LibroElectronico() {
		super();
		this.size = 0;
	}

	public LibroElectronico(long id, String isbn, String titulo, String editorial, boolean prestado, int size) throws Exception {
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
		return super.toString() + ", LibroElectronico [size=" + size + "]";
	}

	@Override
	public void imprimible() {
		
		System.out.println("PRINT en digital");
	}
	
	

}
