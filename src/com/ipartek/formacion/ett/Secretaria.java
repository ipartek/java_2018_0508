package com.ipartek.formacion.ett;

public class Secretaria extends Persona implements Ett {

	private int edad;

	public Secretaria() {
		super();
		this.edad = 35;
		this.setSalario(1000);
	}

	public Secretaria(int edad) {
		this();
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
		return "Secretaria [edad=" + edad + "]";
	}

	@Override
	public double calcularSalario() {
		double result = 0;

		result = (this.getSalario() * 0.8) - this.getEdad();

		return result;
	}

}
