package com.ipartek.formacion.youtube.pojo;

public class Usuario {

	private long id;
	private String nombre;
	private String contrasenya;
	private int rol;
	
	public Usuario() {
		super();
		this.nombre = "";
		this.contrasenya = "";
	}

	public Usuario(String nombre, String contrasenya) {
		this();
		this.nombre = nombre;
		this.contrasenya = contrasenya;
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

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	
	
	
}
