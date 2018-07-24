package com.ipartek.formacion.ett;

public class Contratado extends Persona {

	private int nSeguridadSocial;

	public Contratado() {
		super();
		this.nSeguridadSocial = 0;
	}

	public Contratado(String nombre, String dni, int salario, int nSeguridadSocial) {
		super(nombre, dni, salario);
		this.nSeguridadSocial = nSeguridadSocial;
	}
	
	@Override
	double calcularSalario() {
		
		double resultado = 0;
		
		resultado = super.getSalario() / 2;
		
		return resultado;
	}
	
	public int getnSeguridadSocial() {
		return nSeguridadSocial;
	}

	public void setnSeguridadSocial(int nSeguridadSocial) {
		this.nSeguridadSocial = nSeguridadSocial;
	}

}
