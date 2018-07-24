package com.ipartek.formacion.ett;

public class Secretaria extends Persona {

	// VARIABLES
	private int edad;

	// CONSTRUCTORES
	public Secretaria() {
		super();
	}
	
	public Secretaria(String nombre, String dni, float salario, int edad) {
		super(nombre, dni, salario);
		this.edad = edad;
	}

	// GETTERS AND SETTERS

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	// OTROS MÉTODOS
	@Override
	float calcularSalario() {
		// TODO Auto-generated method stub
		return ((this.getSalario() * 0.8f) - this.edad);
	}

}
