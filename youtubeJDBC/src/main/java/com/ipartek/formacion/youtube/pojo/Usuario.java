package com.ipartek.formacion.youtube.pojo;

public class Usuario {
	
	private long id;
	private String nombre;
	private String pass;
	private String rol;
	
	public Usuario() {
		super();
		this.nombre = "";
		this.pass = "";
	}

		
	public Usuario(String nombre, String pass) {
		this();
		this.nombre = nombre;
		this.pass = pass;
	}
	
	public Usuario(long id, String nombre, String pass,String rol) {
		this();
		this.id=id;
		this.nombre = nombre;
		this.pass = pass;
		this.rol=rol;
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
		return "Usuario [nombre=" + nombre + ", pass=" + pass + "]";
	}
	
}
