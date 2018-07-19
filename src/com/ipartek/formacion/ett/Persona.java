package com.ipartek.formacion.ett;

public abstract class Persona {

	// VARIABLES
	private String nombre;
	private String dni;
	private float salario;

	// CONSTRUCTOR
	public Persona() {
		super();
		this.nombre = "";
		this.dni = "";
		this.salario = 0f;

	}

	public Persona(String nombre, String dni, float salario) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.salario = salario;
	}

	// GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre;
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni != null) {
			this.dni = dni;
		}
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	// OTROS MÉTODOS
	abstract float calcularSalario();
}
