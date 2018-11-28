package com.ipartek.personas.personas.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Persona {

	private long id;

	@NotBlank(message = "El DNI no puede estar vacío.")
	@Size(max = 9, min = 9, message = "El DNI debe contener exactamente 9 caracteres.")
	private String dni;

	@NotBlank(message = "El nombre no puede estar vacío.")
	@Size(max = 45, min = 2, message = "El nombre debe contener entre 2 y 45 caracteres.")
	private String nombre;

	@NotBlank(message = "El apellido1 no puede estar vacío.")
	@Size(max = 45, min = 2, message = "El apellido1 debe contener entre 2 y 45 caracteres.")
	private String apellido1;

	@NotBlank(message = "El apellido2 no puede estar vacío.")
	@Size(max = 45, min = 2, message = "El apellido2 debe contener entre 2 y 45 caracteres.")
	private String apellido2;

	@NotBlank(message = "El email no puede estar vacío.")
	@Email(message = "Formato de email incorrecto.")
	@Size(max = 45, min = 10, message = "El email debe contener entre 10 y 45 caracteres.")
	private String email;

	@NotBlank(message = "El rol no puede estar vacío.")
	@Size(max = 45, min = 2, message = "El rol debe contener entre 2 y 45 caracteres.")
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
