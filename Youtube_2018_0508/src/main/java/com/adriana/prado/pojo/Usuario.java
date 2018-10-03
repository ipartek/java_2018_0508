package com.adriana.prado.pojo;

public class Usuario {
	private long id;
	private String nombre;
	private String contrasena;
	private int rol; //TODO crear pojo y tabla Rol
	
	public static final int ROL_ADMIN = 0;
	public static final int ROL_USER = 1;
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasena = "";
		this.rol = ROL_USER;
	}

	public Usuario(String nombre, String contraseña) {
		this();
		this.nombre = nombre;
		this.contrasena = contraseña;
	}
	
//	public Usuario(String nombre, String contraseña, int rol) {
//		this();
//		this.nombre = nombre;
//		this.contrasena = contraseña;
//		this.rol = rol;
//	}
	
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return id + "- "+ nombre + "-" + contrasena;
	}
	
}
