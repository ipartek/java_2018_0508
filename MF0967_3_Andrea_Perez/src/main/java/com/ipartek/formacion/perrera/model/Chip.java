package com.ipartek.formacion.perrera.model;

public class Chip {

	private String anyo;
	private String numero;
	private long latitud;
	private long longitud;

	public Chip() {
		super();
		this.anyo = "0";
		this.numero = "000000";
		this.latitud = 0;
		this.longitud = 0;
	}

	public Chip(String numero, String anyo, long latitud, long longitud) {
		this();
		this.anyo = anyo;
		this.numero = numero;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public long getLatitud() {
		return latitud;
	}

	public void setLatitud(long latitud) {
		this.latitud = latitud;
	}

	public long getLongitud() {
		return longitud;
	}

	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Chip [anyo=" + anyo + ", numero=" + numero + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}

}
