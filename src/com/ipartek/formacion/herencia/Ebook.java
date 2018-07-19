package com.ipartek.formacion.herencia;

import com.ipartek.formacion.pojo.LibroElectronico;

public class Ebook extends LibroElectronico{
	
	void encenderLuz() {
		
		System.out.println("Luz encendida");
	}
	
	public String toString() {
		return super.toString();
	}

}
