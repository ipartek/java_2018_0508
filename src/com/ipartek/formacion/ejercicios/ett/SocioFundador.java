package com.ipartek.formacion.ejercicios.ett;

public class SocioFundador extends Persona {
	
	public SocioFundador() {
		super();
	}

	public SocioFundador(String dni, String nombre, int salario) {
		super(dni, nombre,salario);
	}
	

	@Override
	public String toString() {
		return super.toString() + "SocioFundador []";
	}
	void calcularSalario(int salario) {
		salario=salario*3;
	}

}
