package com.ipartek.formacion.ett;

public abstract class Persona implements Ett {
	private String nombre;
	private String dni;
	private double salario;

	public Persona() {
		super();
		this.nombre = "";
		this.dni = "5643212W";
		this.salario = 0;
	}

	public Persona(String nombre, String dni, double salario) {
		this();
		this.nombre = nombre;
		this.dni = dni;
		this.setSalario(salario);

	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
	
	@Override
	public
	abstract double calcularSalario();
	
	
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + "]";
	}

	

}
