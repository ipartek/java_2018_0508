package com.ipartek.formacion.ejercicios;

public class Excepciones2 {

	public static void main(String[] args) {
		System.out.println("MAIN COMENZAMOS");
		metodoA();
		System.out.println("MAIN SALIMOS");

	}
	
	static void metodoA() {
		System.out.println("Entro METODO A");
		metodoB();
		System.out.println("Salgo METODO A");
	}
	
	static void metodoB() {
		System.out.println("Entro METODO B");
		metodoC();
		System.out.println("Salgo METODO B");
	}
	
	static void metodoC() {
		System.out.println("Entro METODO C");
		
		Object o = null;
		o.toString();
		
		System.out.println("Salgo METODO C");
	}

}
