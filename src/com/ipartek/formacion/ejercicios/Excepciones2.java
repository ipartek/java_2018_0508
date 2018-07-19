package com.ipartek.formacion.ejercicios;

public class Excepciones2 {

	public static void main(String[] args) {
		System.out.println("Main comenzamos");

		metodoA();

		System.out.println("Main Terminamos");
	}

	static void metodoA() {
		System.out.println("    metodoA entro");
		metodoB();
		System.out.println("    metodoA salgo");
	}

	@SuppressWarnings("null")
	static void metodoB() {
		System.out.println("        metodoB entro");

		Object o = null;
		o.toString();

		System.out.println("        metodoB salgo");
	}

}
