package com.ipartek.formacion.pojo;

public class Usuario {
	long id;
	String nombre;
	String email;
	String password;
	
	//constructor
	public Usuario() {
		super();
		this.id = 1;
		this.nombre = "usuario prueba";
		this.email = "email@gmail.com"  ;
		this.password = "12345" ;
	}
	
	//getter y setters
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + "]";
	}

	
}
