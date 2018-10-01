package com.ipartek.formacion.youtube.pojo;

public class Usuario {

	private long id;
	private String nombre;
	private String pass;
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.pass = "";
	}

		
	public Usuario(String nombre, String pass) {
		this();
		this.id = -1;
		this.nombre = nombre;
		this.pass = pass;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + pass + "]";
	}
	
}
