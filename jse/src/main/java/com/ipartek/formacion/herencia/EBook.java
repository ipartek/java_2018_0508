package com.ipartek.formacion.herencia;

public class EBook extends LibroElectronico{

	public void encenderLuz() {
		System.out.println("Luz encendida");
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
