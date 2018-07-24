package com.ipartek.formacion.herencia;

public class Contratado extends Empresa {
	
	private int nSeguridadSocial;
	
	public Contratado() {
		
		super();
		this.nSeguridadSocial=0;
	}
	
	public Contratado(int salario, String nombre, String dni, int nSeguridadSocial) {
		
		super(salario, nombre, dni);
		this.nSeguridadSocial=nSeguridadSocial;
		
	}

	public int getnSeguridadSocial() {
		return nSeguridadSocial;
	}

	public void setnSeguridadSocial(int nSeguridadSocial) {
		this.nSeguridadSocial = nSeguridadSocial;
	}

	@Override
	public String toString() {
		return "Contratado [nSeguridadSocial=" + nSeguridadSocial + "]";
	}
	
	

}
