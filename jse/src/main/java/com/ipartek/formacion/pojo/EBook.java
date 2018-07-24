package com.ipartek.formacion.pojo;

public class EBook extends Libro{

	public void encenderLuz() {
		System.out.println("Luz encendida");
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void imprimible() {
		System.out.println("PRINT en EBook");
	}
	
	
	
}
