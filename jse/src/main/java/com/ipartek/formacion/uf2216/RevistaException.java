package com.ipartek.formacion.uf2216;

/**
 * Clase Excepción del tipo Runtime que gestiona las excepciones explícitas de
 * la Clase Revista.
 * 
 * @see RuntimeException
 * 
 * @author Curso
 *
 */
public class RevistaException extends RuntimeException {

	/**
	 * Obtenido de la fecha actual.
	 */
	private static final long serialVersionUID = 20072018;

	public RevistaException() {
		super();
	}

	public RevistaException(String message) {
		super(message);
	}

	public RevistaException(String message, Throwable cause) {
		super(message, cause);
	}

	public RevistaException(Throwable cause) {
		super(cause);
	}

}
