package com.formaciion.ipartek.gestor.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Persona {

	long id;
	@NotBlank
	@Size(min = 2, max = 45)
	String nombre;
	@NotBlank
	@Size(min = 2, max = 45)
	String apellido1;
	@NotBlank
	@Size(min = 2, max = 45)
	String apellido2;
	@NotBlank
	@Size(min = 2, max = 50)
	String email;
	@NotBlank
	@Size(min = 9, max = 9)
	String dni;

	public Persona() {

		super();
		this.id = -1;
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
		this.dni = "";
		this.email = "";

	}

	public Persona(long id, String nombre, String apellido1, String apellido2, String dni, String email) {

		this();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.email = email;

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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
