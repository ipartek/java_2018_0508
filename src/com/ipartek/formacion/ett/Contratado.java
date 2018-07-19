package com.ipartek.formacion.ett;

public class Contratado extends Persona implements Ett {

	private String numSS;
	private double salario;

	public Contratado() {
		super();
		this.numSS = "363738382893993093";
		this.salario = 600;
	}

	public Contratado(String numSS, double salario) {
		this();
		this.numSS = numSS;
		this.salario = salario;

	}

	public String getNumSS() {
		return numSS;
	}

	public void setNumSS(String numSS) {
		this.numSS = numSS;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
	
	
	@Override
	public double calcularSalario() {
		double result = 0;

		result = this.getSalario() / 2;

		return result;
	}

}
