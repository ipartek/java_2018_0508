package com.ipartek.formacion.ett;

public class SocioFundador extends Persona{
	//Constantes
	public static final int SUELDO_BASE=5000;
	public static final int SALARIO_MULTIPLICACION=3;
	
	//Constructor
	public SocioFundador() {
		super();
	}

	/*TODO MIRAR TODO SECRETARIA*/
	@Override
	 void CalcularSalario() {
		int salarioFinal=SUELDO_BASE*SALARIO_MULTIPLICACION;
		System.out.println("El salario es de:"+salarioFinal);
	}


	@Override
	public String toString() {
		return super.toString()+"\n -SocioFundador-"+
								"\nSalario";
	}

	
	
}
