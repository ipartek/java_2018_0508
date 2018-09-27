package com.ipartek.formacion.libroElectronico.model.pojo;

public class Usuario {
	private int id;
	private String nombre;
	private String pass;
	
	public Usuario() {
		super();
		this.id=-1;
		this.nombre = "";
		this.pass = "";
	}

		
	public Usuario(int id, String nombre, String pass) {
		this();
		this.id=id;
		this.nombre = nombre;
		this.pass = pass;
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
