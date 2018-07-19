package com.ipartek.formacion.herencia;

import java.util.Date;

import com.ipartek.formacion.pojo.Libro;

public class LibroElectronico extends Libro {
	
	private int size; //kylobytes
	
	public LibroElectronico() {
		super();
		this.size = 0;
	}

	public LibroElectronico(long id, String isbn, String titulo, String editorial, boolean prestado, Date fechaPrestado,
			Date fechaDevolucion, int size) {
		super(id, isbn, titulo, editorial, prestado, fechaPrestado, fechaDevolucion);
		this.size = size;
	}

	public LibroElectronico(long id, String isbn, String titulo, String editorial, boolean prestado) throws Exception {
		super(id, isbn, titulo, editorial, prestado);
	}

	public LibroElectronico(String isbn, String titulo, String editorial, boolean prestado) throws Exception {
		super(isbn, titulo, editorial, prestado);
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
