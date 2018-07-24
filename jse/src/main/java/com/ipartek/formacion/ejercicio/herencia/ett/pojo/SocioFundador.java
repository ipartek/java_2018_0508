package com.ipartek.formacion.ejercicio.herencia.ett.pojo;

public class SocioFundador extends Persona {

	private final double SALARIO_SOCIO = 5000;
	public SocioFundador() {
		super();
		this.setSalario(5.000);

	}

	public SocioFundador (String nombre, String dni) {
		this();		
		this.setSalario(SALARIO_SOCIO);
	}

	@Override
	double calcularSalario() {

		double sal = super.getSalario() * 3;
		return sal;

	}

}
