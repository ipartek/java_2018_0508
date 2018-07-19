package com.ipartek.formacion.ett;

public class Contratado extends Persona {

	private int numSS;

	public Contratado() {
		super();
		this.numSS = 0;
	}

	public Contratado(long id, String dni, String nombre, int salario, int numSS) {
		super(id, dni, nombre, salario);
		this.numSS = numSS;
	}

	public int getNumSS() {
		return numSS;
	}

	public void setNumSS(int numSS) {
		this.numSS = numSS;
	}

	@Override
	public String toString() {
		return "Contratado [numSS=" + numSS + "]";
	}

}
