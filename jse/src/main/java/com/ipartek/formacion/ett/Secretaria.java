package com.ipartek.formacion.ett;

public class Secretaria extends Persona{
	//Constantes
	public static final int SUELDO_BASE=800;
	public static final double SALARIO_DIVISION=0.8;
	//Atributos
	private int edad;
	
	//Constructor
	public Secretaria() {
		super();
		this.edad=edad;
	}

	/*TODO MIRAR TODO SECRETARIA*/
	@Override
	 void CalcularSalario() {
		int salarioFinal=(int)(SUELDO_BASE/SALARIO_DIVISION);//Casteamos porque uno es int y el otro double
		System.out.println("El salario es de:"+ (salarioFinal-edad));
	}


	@Override
	public String toString() {
		return super.toString()+"\n -Secretaria-"+
								"\nEdad=" + edad+
								"\nSalario";
	}

	
	
}
