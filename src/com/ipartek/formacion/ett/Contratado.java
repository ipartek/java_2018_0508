package com.ipartek.formacion.ett;

public class Contratado extends Personas{

	private int numSegSocial;

	public Contratado() {
		super();
		this.numSegSocial = 0;
	}

	public Contratado(float salario, String nombre, String dni, int numSegSocial) {
		super(salario, nombre, dni);
		this.numSegSocial = numSegSocial;
	}

	public int getNumSegSocial() {
		return numSegSocial;
	}

	public void setNumSegSocial(int numSegSocial) {
		this.numSegSocial = numSegSocial;
	}

	@Override
	public String toString() {
		return super.toString() + "Contratado [numSegSocial=" + numSegSocial + "]";
	}
	
	
	
}
