package com.ipartek.formacion.prestamos_libros.pojo;

public class UsuarioLogin {
	
	private String nombre;
	private String password;
	
	public UsuarioLogin() {
		super();
		this.nombre = "";
		this.password = "";
	}

		
	public UsuarioLogin(String nombre, String password) {
		this();
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "UsuarioLogin [nombre=" + nombre + ", password=" + password + "]";
	}

}
