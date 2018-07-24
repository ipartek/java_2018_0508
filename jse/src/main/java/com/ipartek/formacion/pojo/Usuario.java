package com.ipartek.formacion.pojo;

public class Usuario {
	
	private long id;
	private String nombre;
	private String email;
	private String password;
	
	public Usuario() {
		super();
		this.setId(-1);
		this.setNombre("");
		this.setEmail("");
		this.setPassword("");		
	}
	
	public Usuario(long id, String nombre, String email, String password) {
		this();
		this.setId(id);
		this.setNombre(nombre);
		this.setEmail(email);
		this.setPassword(password);
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
