package com.ipartek.formacion.ejercicio.herencia.ett.pojo;

public class Secretaria extends Persona {
	private final double SALARIO_SECRETARIA = 1000;
	private int edad;

	public Secretaria() {
		super();
		this.setSalario(SALARIO_SECRETARIA);
		this.edad = 18;

	}

	public Secretaria(String nombre, String dni, int edad) {
		this();
		this.edad = edad;
		this.setSalario(SALARIO_SECRETARIA);
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	double calcularSalario() {

		double sal = super.getSalario() / 0.8;
		return sal;

	}

}
