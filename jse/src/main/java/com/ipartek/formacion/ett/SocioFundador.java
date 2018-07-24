package com.ipartek.formacion.ett;

public class SocioFundador extends Persona {

	public SocioFundador(String nombre, String dni, int salario) {
		super(nombre, dni, salario);
	}
	
	@Override
	int calcularSalario() {
		return getSueldoBase() * 3;
	}

}
