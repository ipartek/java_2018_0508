package com.andrea.perez.pojo;

public class Rol {
	public static final int ROL_ADMIN = 1;
	public static final int ROL_USER = 2;

	private long id;
	private String nombre;
	
	

	public Rol() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Rol(long id, String nombre) {
		this();
		this.id = id;
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
