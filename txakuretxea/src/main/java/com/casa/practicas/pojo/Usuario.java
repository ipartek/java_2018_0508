package com.casa.practicas.pojo;



public class Usuario {
	private static long contadorId = 0;
	private long id;
	private String nombre;
	private String email;
	private String password;
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.email = "";
		this.password = "";
	}
	
	public Usuario(String usuarioNombre, String pass) {
		this();
		this.id = -1; 
		this.nombre = nombre;
		this.email = email;
	}
	
	public Usuario(long id,String nombre,String email, String password) {
		this();
		this.id = id; 
		this.nombre = nombre;
		this.email = email;
		this.password = password;
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
	public long getId() {
		return id;
	}
/*	public void setId(long id) {
		this.id = id;
	}*/
	
	
}
