package com.ipartek.formacion.ejercicio.ett;

public class SocioFundador extends Persona {

	public SocioFundador() {
		super();
	}

	public SocioFundador(String nombre, String dni, double salario) {
		super(nombre, dni, salario);
	}

	@Override
	public String toString() {
		return "SocioFundador " + super.toString();
	}

	@Override
	public double calcularSalario() {
		return getSalario()*3;
	}
	
}
