package com.ipartek.formacion.pojo;

/**
 * Hereda todo del padre que es la clase Libro
 * 
 * @author andreaPerez
 *
 */
public class LibroElectronico extends Libro {

	private int size;// kb

	public LibroElectronico() {
		super();
		this.size = 0;
	}

	//Constructor con campos del padre y el del hijo "size"
	public LibroElectronico(long id, String isbn, String titulo, String editorial, boolean prestado, int size)
			throws Exception {
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
		return super.toString() + "LibroElectronico [size=" + size + "]";
	}

}
