package com.ipartek.formacion.herencia;

import java.util.Date;

public class EBook extends LibroElectronico{

	public void encenderLuz() {
		System.out.println("Luz encendida");
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
