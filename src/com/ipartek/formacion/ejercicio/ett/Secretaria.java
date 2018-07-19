package com.ipartek.formacion.ejercicio.ett;

public class Secretaria extends Persona {
	
	private int edad;
	
	public Secretaria() {
		super();
		this.edad = 0;
	}

	public Secretaria(String nombre, String dni, double salario, int edad) {
		super(nombre, dni, salario);
		this.edad = edad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Secretaria " + super.toString() + "[edad=" + edad + "]";
	}

	@Override
	public double calcularSalario() {
		return (getSalario()*0.8)-edad;
	}
	
}
