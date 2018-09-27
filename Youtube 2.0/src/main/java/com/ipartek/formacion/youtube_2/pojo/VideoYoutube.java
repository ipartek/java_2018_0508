package com.ipartek.formacion.youtube_2.pojo;

public class VideoYoutube {

	public static final int COD_LONGITUD = 11;
	
	private long id;
	private String cod;
	private String nombre;
	
	public VideoYoutube() {
		super();
	}
	
	public VideoYoutube(long id, String cod, String nombre) {
		this();
		this.id = id;
		this.cod = cod;
		this.nombre = nombre;
	}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
