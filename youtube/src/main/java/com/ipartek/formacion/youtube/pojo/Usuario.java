package com.ipartek.formacion.youtube.pojo;

public class Usuario {
	
	private long id;
	private String nombre;
	private String pass;
	private int rol;
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.pass = "";
		this.rol = 1;
	}

		
	public Usuario(long id, String nombre, String pass, int rol) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
		this.rol = rol;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	public int getRol() {
		return rol;
	}


	public void setRol(int rol) {
		this.rol = rol;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + pass + ", rol=" + rol + "]";
	}
	
}
