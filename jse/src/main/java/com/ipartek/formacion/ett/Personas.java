package com.ipartek.formacion.ett;

public class Personas{

	private float salario;
	private String nombre;
	private String dni;
	
	public Personas() {
		super();
		this.salario = 0;
		this.nombre = "";
		this.dni = "";
	}
	
	public Personas(float salario, String nombre, String dni) {
		this();
		this.salario = salario;
		this.nombre = nombre;
		this.dni = dni;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Personas [salario=" + salario + ", nombre=" + nombre + ", dni=" + dni + "]";
	}
}
