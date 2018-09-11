package com.ipartek.formacion.nidea.pojo;

public class Usuario {

	private String nombre;
	private String password;
	private String email;
	
	public Usuario() {
		super();
		this.nombre = "";
		this.password="";
		this.email="";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
