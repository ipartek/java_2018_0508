package com.ipartek.formacion.ett;

public class SocioFundador extends Persona {

	// CONSTRUCTORES
	public SocioFundador() {
		super();
	}
	
	public SocioFundador(String nombre, String dni, float salario) {
		super(nombre, dni, salario);
	}

	// OTROS MÉTODOS
	@Override
	float calcularSalario() {

		return this.getSalario() * 3f;
	}

}
