package com.ipartek.personas.personas.pojo;

public class Persona {
	
	private long id;
	private String dni;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	private String email;

	private String rol;

	public Persona() {
		super();
		this.id = -1;
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
		this.dni = "";
		this.email = "";
		this.rol = "";

	}

	public Persona(String nombre, String apellido1, String apellido2, String dni, String email, String rol) {
		this();
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.email = email;
		this.nombre = nombre;
		this.rol = rol;
	}
	

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public String getDni() {
		return dni;
	}

	public String getEmail() {
		return email;
	}

	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", email=" + email + ", rol=" + rol + "]";
	}


}
