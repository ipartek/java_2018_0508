package com.ipartek.formacion.ett;

public class Contratado extends Persona{
	//Constantes
	public static final int SUELDO_BASE=600;
	public static final int SALARIO_DIVISION=2;
	//Atributos
	private int nSeguridadS;
	
	//Constructor
	public Contratado() {
		super();
		this.nSeguridadS=nSeguridadS;
	}
	

	void CalcularSalario() {
		System.out.println(SUELDO_BASE/SALARIO_DIVISION);
	}
	
	@Override
	public String toString() {
		return super.toString()+"\n -Contratado-"+
								"Numero Seguridad Social=" + nSeguridadS+
								"salarioFinal";
	}
	
	




	
	
}
