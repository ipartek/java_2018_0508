package com.casa.practicas.pojo;



public class Chip {

	
	private String nIdentificacion;
	private String latitud;
	private String longitud;
	
	
	public Chip() {
		super();
		this.nIdentificacion= "";
		this.latitud = "";
		this.longitud = "";
	}


	public Chip(String nIdentificacion, String latitud, String longitud) {
		this();
		this.nIdentificacion = nIdentificacion;
		this.latitud = latitud;
		this.longitud = longitud;
	}


	public String getnIdentificacion() {
		return nIdentificacion;
	}


	public void setnIdentificacion(String nIdentificacion) {
		this.nIdentificacion = nIdentificacion;
	}


	public String getLatitud() {
		return latitud;
	}


	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}


	public String getLongitud() {
		return longitud;
	}


	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	
}

