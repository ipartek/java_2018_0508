package com.ipartek.formacion.ejercicios;

public class Excepciones4 {

	public static void main(String[] args) {
		System.out.println("Comienzo el main");

		a();

		System.out.println("Main terminamos");

	}

	private static void a() {
		System.out.println("Metodo a entro");
		System.out.println("Metodo a salgo");
		b();
	}

	private static void b() {
		System.out.println("Metodo b entro");

		c();

		System.out.println("Metodo b salgo");

	}

	private static void c() {

		try {
			Object o = null;
			o.toString();
		} catch (Exception e) {
			System.out.println("Excepcion capturada");
		}

	}

}
