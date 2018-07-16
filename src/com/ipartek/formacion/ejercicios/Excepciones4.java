package com.ipartek.formacion.ejercicios;

public class Excepciones4 {
	public static void main(String[] args) {
		System.out.println("Comentamos ejecucion....");
		// Ejercicio 4 capturar excepciones para que se ejecuten todos los metodos como
		// si no hubiera excepcion
	}

	static void metodoA() {
		try {
			System.out.println("    Metodo A entro ");
			metodoB();
			System.out.println("    Salgo A salgo ");

		} catch (Exception e) {
			System.out.println("Lo sentimos a surgido un problema ");
		} finally {
			System.out.println("terinamos la ejecucion (siempre se debe ejecutar");
		}

	}

	static void metodoB() {
		System.out.println("         Metodo B entro ");

		try {Object o = null;
		o.toString();
	} catch (Exception e) {
		System.out.println("Lo sentimos a surgido un problema ");
		System.out.println("         Salgo B salgo ");
	}

	}
}
