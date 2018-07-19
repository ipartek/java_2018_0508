package com.ipartek.formacion.pojo;

public class LibroElectronico extends Libro {

	public LibroElectronico() {
		super();
		this.size = 0;

	}


	private int size;// Kb

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
