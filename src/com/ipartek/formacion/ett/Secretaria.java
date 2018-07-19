package com.ipartek.formacion.ett;

public class Secretaria extends Persona {

	// VARIABLES
	private int edad;

	// CONSTRUCTORES
	public Secretaria() {
		super();
	}

	// GETTERS AND SETTERS
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

	// OTROS MÉTODOS
	@Override
	float calcularSalario() {
		// TODO Auto-generated method stub
		return ((this.getSalario() * 0.8f) - this.edad);
	}

}
