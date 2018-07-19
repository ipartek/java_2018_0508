package com.ipartek.formacion.ett;

public class Persona {

	long id;
	String dni, nombre;
	int salario;

	public Persona() {
		super();
		this.id = -1;
		this.dni = "";
		this.nombre = "";
		this.salario = 0;
	}

	public Persona(long id, String dni, String nombre, int salario) {
		this();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.salario = salario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", salario=" + salario + "]";
	}
}
