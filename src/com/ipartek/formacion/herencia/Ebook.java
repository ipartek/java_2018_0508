package com.ipartek.formacion.herencia;

import com.ipartek.formacion.libreria.LibroElectronico;

public class Ebook extends LibroElectronico{
	
	void encenderLuz() {
		System.out.println("Luz encendida");
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
}
