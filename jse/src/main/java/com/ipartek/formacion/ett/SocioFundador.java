package com.ipartek.formacion.ett;

public class SocioFundador extends Persona {
	
	public SocioFundador() {
		super();
	}

	public SocioFundador(String nombre, String dni, int salario) {
		super(nombre, dni, salario);
	}
	
	@Override
	double calcularSalario() {
		double resultado = 0;
		
		resultado = super.getSalario() * 3;
		
		return resultado;
	}

}
