package com.ipartek.formacion.youtube.pojo;

public class Usuario {
	
	private long id;
	private String nombre;
	private String password;
	private int rol; //TODO crear Pojo y tabla 'Rol'
	
	public static final int ROL_ADMIN = 0;
	public static final int ROL_USER = 1;
	
	public Usuario() {
		super();
		this.id=-1;
		this.nombre = "";
		this.password = "";
		this.rol = ROL_USER;
	}

		
	public Usuario(String nombre, String password) {
		this();
		this.nombre = nombre;
		this.password = password;
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

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", rol=" + rol + "]";
	}

}