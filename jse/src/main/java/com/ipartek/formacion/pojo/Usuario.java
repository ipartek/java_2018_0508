package com.ipartek.formacion.pojo;

public class Usuario {

	// Atributos
	private long id;
	private String nombre;
	private String email;
	private String password;

	// Constructores

	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.email = "";
		this.password = "";
	}

	public Usuario(long id, String nombre, String email, String password) {
		this();
		this.setId(id);
		this.setNombre(nombre);
		this.setEmail(email);
		this.setPassword(password);
	}

	// Getters y Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = (id >= 0) ? id : 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = (nombre != null) ? nombre : "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = (email != null) ? email : "";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = (password != null) ? password : "";
	}

	// Metodos

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + "]";
	}
}
