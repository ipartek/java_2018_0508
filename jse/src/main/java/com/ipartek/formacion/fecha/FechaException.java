package com.ipartek.formacion.fecha;

public class FechaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FechaException() {
		super();
	}

	public FechaException(String message) {
		super(message);
	}

	public FechaException(String message, Throwable cause) {
		super(message, cause);
	}

	public FechaException(Throwable cause) {
		super(cause);
	}
} // FIN FechaException
