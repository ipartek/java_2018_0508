package com.ipartek.formacion.ejercicio.ett;

public class Contratado extends Persona {
	
	private float numSS;
	
	public Contratado() {
		super();
		this.numSS = 0;
	}

	public Contratado(String nombre, String dni, double salario, float numSS) {
		super(nombre, dni, salario);
		this.numSS = numSS;
	}

	public float getNumSS() {
		return numSS;
	}

	public void setNumSS(float numSS) {
		this.numSS = numSS;
	}

	@Override
	public String toString() {
		return "Contratado " + super.toString() + "numSS=" + numSS + "]";
	}

	@Override
	public double calcularSalario() {
		return getSalario()/2;
	}
	
}
