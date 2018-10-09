package com.ipartek.formacion.txakur.pojo;

public class Chip {
	
	private String id;
	private double latitud;
	private double longitud;
	
	public Chip() {
		super();
		this.id = "";
		this.latitud = 0;
		this.longitud = 0;
		
	}

	public Chip(String id, double latitud, double longitud) {
		this();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Chip [id=" + id + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
	
	

}
