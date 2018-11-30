package com.ipartek.formacion.repaso.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Alumno {

	private long id;

	@NotBlank
	@Length(max = 150, min = 1)
	private String nombre;
	@NotBlank
	@Length(max = 150, min = 1)
	private String apellido1;
	@NotBlank
	@Length(max = 150, min = 1)
	private String apellido2;

	@NotBlank
	@Length(max = 9, min = 9)
	private String dni;
	@NotBlank
	@Length(max = 45, min = 1)
	private String email;

	public Alumno() {
		super();
		this.id = -1;
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
		this.dni = "";
		this.email = "";
	}

	public Alumno(long id, String nombre, String apellido1, String apellido2, String dni, String email) {
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
