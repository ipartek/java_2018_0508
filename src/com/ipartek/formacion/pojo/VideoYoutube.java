package com.ipartek.formacion.pojo;

public class VideoYoutube {
	
	//ATRIBUTOS
	long id;
	String codigo;
	String nombre;
	
	public VideoYoutube() {
		super();
		this.id = -1;
		this.codigo = "";
		this.nombre = "";
	}
	
	public VideoYoutube(long id, String codigo, String nombre) {
		this();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
	}

	//GETTERS Y SETTERS
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
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "VideoYoutube [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
}
