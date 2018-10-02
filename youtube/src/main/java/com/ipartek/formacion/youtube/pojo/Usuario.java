package com.ipartek.formacion.youtube.pojo;

public class Usuario {

	private long id;
	private String nombre;
	private String pass;
	private int tipo; // O: Admin, 1: Cliente

	// CONSTRUCTORES
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.pass = "";
		this.tipo = 1;
	}

	public Usuario(String nombre, String pass) {
		this();
		this.nombre = nombre;
		this.pass = pass;
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
