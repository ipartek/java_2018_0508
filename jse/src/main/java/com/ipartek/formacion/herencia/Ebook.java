package com.ipartek.formacion.herencia;

public class Ebook extends LibroElectronico {

	public void encenderLuz() {

		System.out.println("Luz encendida.");

	}

	public void apagarLuz() {

		System.out.println("Luz apagada.");

	}

	@Override
	public String toString() {
		return super.toString();
	}

}
