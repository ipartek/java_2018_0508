package com.ipartek.formacion.ejercicios;

public class Excepciones2 {

	public static void main(String[] args) {

		System.out.println("Dentro del main");

		metodoA();

		System.out.println("salgo del main");
	}

	public static void metodoA() {

		System.out.println("entro del metodoA");
		metodoB();
		System.out.println("salgo del metodoA");
	}

	public static void metodoB() {

		System.out.println("entro del metodoB");

		metodoC();
		System.out.println("salgo del metodoB");
	}

	public static void metodoC() {

		System.out.println("dentro del metodoC");
		try {
			Object o = null;
			o.toString();
		} catch (Exception e) {
			System.out.println("Recogida excepcion nullPoint");
		}

		System.out.println("salgo del metodoC");
	}

	// TODO Ejercicio4 capturar excepciones para que se ejecuten todos los metodos
	// como si no hubiera excepcion.(no se manda mensaje)

}
