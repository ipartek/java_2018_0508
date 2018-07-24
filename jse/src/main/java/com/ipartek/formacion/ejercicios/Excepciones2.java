package com.ipartek.formacion.ejercicios;

public class Excepciones2 {

	public static void main(String[] args) {

		System.out.println("Comenzando main...");
		metodoA();
		System.out.println("Saliendo main...");

	}

	private static void metodoA() {

		System.out.println("Entrando A...");
		metodoB();
		System.out.println("Saliendo A...");

	}

	private static void metodoB() {

		System.out.println("Entrando B...");
		metodoC();
		System.out.println("Saliendo B...");

	}

	private static void metodoC() {
		System.out.println("Entrando C...");

		try {
			Object o = null;
			o.toString();
		} catch (Exception e) {
			// NO hacer nada
		}
		System.out.println("Saliendo C...");

	}

}
