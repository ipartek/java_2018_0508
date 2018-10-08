package com.ipartek.formacion.perrera.pojo;

public class Chip {
	
	private String numero;
	
	private double latitud;
	private double longitud;

	//	CONSTRUCTORES
	public Chip() {
		super();
	}
	

	public Chip(String numero, double latitud, double longitud) {
		super();
		this.numero = numero;
		this.latitud = latitud;
		this.longitud = longitud;
	}


	//	GETTERS AND SETTERS
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

}
