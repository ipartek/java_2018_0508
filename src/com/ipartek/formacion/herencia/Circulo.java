package com.ipartek.formacion.herencia;

public class Circulo extends ObjetoGrafico {

	@Override
	void dibujar() {
		System.out.println("Dibujo un circulo");
		
	}

	public Circulo() {
		super();
		//En el constructor llamamos al padre
	}

}
