package com.ipartek.formacion.ett;

public class Secretaria extends Personas{

	private int edad;

	public Secretaria() {
		super();
		this.edad = 0;
	}

	public Secretaria(float salario, String nombre, String dni, int edad) {
		super(salario, nombre, dni);
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
		return super.toString() + "Secretaria [edad=" + edad + "]";
	}
}
