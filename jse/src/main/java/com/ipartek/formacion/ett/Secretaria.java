package com.ipartek.formacion.ett;

public class Secretaria extends EmpresaEtt {
	private int edad;

	public Secretaria() {
		super();
		this.edad = 0;

	}

	public Secretaria(double salario, String nombre, String dni) {
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
		return "Secretaria [edad=" + edad + "]" + super.toString();
	}

}
