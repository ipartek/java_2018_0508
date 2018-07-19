package com.ipartek.formacion.herencia;

import com.ipartek.formacion.pojo.LibroElectronico;;

public class Ebook extends LibroElectronico {

	public void encenderLuz () {
		System.out.println("Luz encendida");
	}
	
	
	@Override
	public String toString() {
		return super.toString();
	}


	
}
