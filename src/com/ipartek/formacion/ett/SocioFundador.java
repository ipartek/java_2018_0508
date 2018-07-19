package com.ipartek.formacion.ett;

public class SocioFundador extends Persona implements Ett {

	public SocioFundador() {
		super();
		this.setSalario(5000);
	}

	public SocioFundador(String nombre, String dni, double salario) {
		super(nombre, dni, salario);
	}

	@Override
	public double calcularSalario() {
		double result = 0;

		result = this.getSalario() * 3;

		return result;
	}

}
