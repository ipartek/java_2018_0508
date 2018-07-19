package com.ipartek.formacion.ejercicio.herencia.ett.pojo;

public class Contratado extends Persona {

	private int numSegSocial;

	public Contratado() {
		super();
		this.setSalario(600);
		this.numSegSocial = 0;
	}

	public Contratado(double salario, String nombre, String dni, int numSegSocial) {
		this();
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
		return "Contratado [numSegSocial=" + numSegSocial + "]";
	}

	@Override
	double calcularSalario() {

		double sal = super.getSalario() / 2;
		return sal;

	}

}
