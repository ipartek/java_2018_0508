package com.ipartek.formacion.pojo;

public class Usuario {

	private long id;
	private String nombre;
	private String usuario;
	private String password;
	
	//Constructores
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.usuario = "";
		this.password = "";
	}

	public Usuario(long id, String nombre, String usuario, String password) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = password;
	}

	// Getters y setters

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", usuario=" + usuario + ", password=" + password + "]";
	}
	
	
	
	
}
