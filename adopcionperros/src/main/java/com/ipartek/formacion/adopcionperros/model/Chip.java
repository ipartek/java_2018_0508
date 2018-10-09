package com.ipartek.formacion.adopcionperros.model;

public class Chip {
	private String numIdentificacion;
	private String longitud;
	private String latitud;

	public Chip(String numIdentificacion, String longitud, String latitud) {
		super();
		this.numIdentificacion = numIdentificacion;
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public String getNumIdentificacion() {
		return numIdentificacion;
	}

	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

}
