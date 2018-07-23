package com.ipartek.formacion.ejercicios.xml;

public class Casa {

	private int numHabitaciones;
	private float precio;
	private float latitud;
	private float longitud;

	public Casa() {
		super();
		this.numHabitaciones = 0;
		this.precio = 0;
		this.latitud = 0;
		this.longitud = 0;
	}

	public Casa(int numHabitaciones, float precio, float latitud, float longitud) {
		this();
		this.numHabitaciones = numHabitaciones;
		this.precio = precio;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	
	
	

}
