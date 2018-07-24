package com.ipartek.formacion.ett;

public class Secretaria extends Persona {
	
	private int edad;

	public Secretaria() {
		super();
		this.edad = 0;
	}

	public Secretaria(String nombre, String dni, int salario, int edad) {
		super(nombre, dni, salario);
		this.edad = edad;
	}

	@Override
	double calcularSalario() {
		double resultado = 0;
		
		resultado = (super.getSalario() * 0.8) - this.edad;
		
		return resultado;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
