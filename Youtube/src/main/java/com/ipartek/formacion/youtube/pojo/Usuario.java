package com.ipartek.formacion.youtube.pojo;

public class Usuario {
	
	private long id;
	private String nombre;
	private String password;
	
	private Rol rol; // 1: Admin, 2: Usuario

	// CONSTRUCTORES
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.password = "";
		this.rol = new Rol();
	}

	public Usuario(String nombre, String password) {
		this();
		this.nombre = nombre;
		this.password = password;
	}

	// GETTERS AND SETTERS
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

	public String getPassword() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", password=" + password + "]";
	}

}
