package com.ipartek.formacion.ett;

public class Contratado extends Persona {
	
	private long nSS;
	
	


	public Contratado() {
		super();
		nSS = 0;
	}

	public Contratado(String nombre, long dni) {
		super(nombre, dni);
		this.setnSS(nSS);
	}

	public long getnSS() {
		return nSS;
	}

	public void setnSS(int nSS) {
		this.nSS = nSS;
	}


	@Override
	public double CalcularSalario() {
		double salario = (double) this.getSueldoBase()/2;
		return salario;
	}
	
	
	
	
}
