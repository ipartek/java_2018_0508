package com.ipartek.formacion.ejercicios;

public class Excepciones3 {

	public static void main(String[] args) {
		System.out.println("Comienzo el main");

		try {
			a();
		} catch (Exception e) {

		}

		System.out.println("Main terminamos");

	}

	private static void a() throws Exception {
		System.out.println("Metodo a entro");
		System.out.println("Metodo a salgo");
		b();
	}

	private static void b() throws Exception {
		System.out.println("Metodo b entro");

		c();

		System.out.println("Metodo b salgo");

	}

	private static void c() {
		Object o = null;
		o.toString();

	}

}
