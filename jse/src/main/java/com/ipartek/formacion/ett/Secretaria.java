package com.ipartek.formacion.ett;

public class Secretaria extends Persona{
	
	private static final double PORCENTAJE = 0.8;
	
	private int edad;
	
	

	public Secretaria(String nombre, String dni, int salario, int edad) {
		super(nombre, dni, salario);
		this.edad = edad;
	}



	@Override
	int calcularSalario() {
		return (int) (this.getSueldoBase()*PORCENTAJE-this.edad);
	}

}
