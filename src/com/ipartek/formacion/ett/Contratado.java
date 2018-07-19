package com.ipartek.formacion.ett;

public class Contratado extends Persona {

	public Contratado(String nombre, String dni, int salario) {
		super(nombre, dni, salario);
	}

	@Override
	int calcularSalario() {
		// Su salario base entre dos
		return this.getSueldoBase() / 2;
	}

}
