package com.ipartek.formacion.ett;

public class Secretaria extends Persona{

	private int edad;
	


	public Secretaria() {
		super();
		edad = 0;
	}

	public Secretaria(String nombre, long dni, int edad) {
		super(nombre, dni);
		this.setEdad(edad);
	}

	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public double CalcularSalario() {
		double salario = (double) ((this.getSueldoBase()*0.8) - this.getEdad());
		return salario;
	}
	

}
