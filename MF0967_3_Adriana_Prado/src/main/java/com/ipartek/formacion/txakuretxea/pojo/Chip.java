package com.ipartek.formacion.txakuretxea.pojo;

public class Chip {
	private long id;
	private String codigo;
	private String longitud;
	private String latitud;
	
	public Chip() {
		super();
		codigo = "";
		longitud = "";
		latitud = "";
	}
	
	public Chip(String codigo, String longitud, String altitud) {
		this();
		this.codigo = codigo;
		this.longitud = longitud;
		this.latitud = altitud;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	
	@Override
	public String toString() {
		return "Chip [id=" + id + ", codigo=" + codigo + ", longitud=" + longitud + ", latitud=" + latitud + "]";
	}
	
	
}
