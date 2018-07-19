package com.ipartek.formacion.ett;

public class Secretaria extends Persona {

	private int edad;

	public Secretaria() {
		super();
		this.edad = 0;
	}

	public Secretaria(long id, String dni, String nombre, int salario, int edad) {
		super(id, dni, nombre, salario);
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

}
