package com.ipartek.formacion.youtube.pojo;

public class Usuario {


	public static final int ROL_ADMIN = 0;
	public static final int ROL_USER = 1;
	
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
		this.nombre = nombre.trim();
		this.contrasenya = contrasenya.trim();
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
		this.nombre = nombre.trim();
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya.trim();
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenya=" + contrasenya + ", rol=" + rol + "]";
	}
	
	
}
