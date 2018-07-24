package com.ipartek.formacion.herencia;

import com.ipartek.formacion.pojo.Libro;

// Libro -> LibroElectrinico -> Ebook

//---------> Libro en Papel
//---Interfaces -> Serializable -> Imprimible (imprimir) ------------->Interfaz1, Interfaz2

public class LibroElectronico extends Libro {

	// VARIABLES DE LA CLASE
	private int size; // Kb

	// CONSTRUCTORES
	public LibroElectronico() {
		super();
		this.size = 0;
	}

	public LibroElectronico(long id, String titulo, String autor, String editorial, String isbn, int numPaginas,
			boolean prestado, int size) throws Exception {

		super(id, titulo, autor, editorial, isbn, numPaginas, prestado);
		this.size = size;
	}

	// GETTERS AND SETTERS
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return super.toString() + " [size=" + size + "]";
	}

}
