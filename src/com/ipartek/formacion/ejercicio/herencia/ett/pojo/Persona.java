package com.ipartek.formacion.ejercicio.herencia.ett.pojo;

public abstract class Persona {

	private double salario;
	private String nombre;
	private String dni;

	
	
	
	public Persona() {
		super();
		this.salario=calcularSalario();
		this.nombre="";
		this.dni="";
	}
	
	

	public Persona(double salario, String nombre, String dni) {
		this();
		this.salario = salario;
		this.nombre = nombre;
		this.dni = dni;
	}



	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
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

	abstract double calcularSalario();



	@Override
	public String toString() {
		return "Persona [salario=" + salario + ", nombre=" + nombre + ", dni=" + dni + "]";
	}

}
