package com.ipartek.formacion.pojo;

import java.io.Serializable;

public class LibroPapel extends Libro implements Serializable, Imprimible {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LibroPapel() {
		super();
	}

	public LibroPapel(long id, String isbn, String titulo, String editorial, boolean prestado) throws Exception {
		super(id, isbn, titulo, editorial, prestado);
	}

}
