package com.ipartek.formacion.youtube.pojo;

public class Rol {
	
	private int id;
	private String nombre;
	public static final int ROL_ADMIN = 1;
	public static final int ROL_USER = 2;
	
	public Rol() {
		super();
		this.id= -1;
		this.nombre="";
	}
	public Rol(int id, String nombnre) {
		super();
		this.id = id;
		this.nombre = nombnre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
	
}