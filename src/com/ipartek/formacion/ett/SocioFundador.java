package com.ipartek.formacion.ett;

public class SocioFundador extends Persona {

	public SocioFundador() {
		super();
	}

	@Override
	float calcularSalario() {

		return this.getSalario() * 3f;
	}

}
