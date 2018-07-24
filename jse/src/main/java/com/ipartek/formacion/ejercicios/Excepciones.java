package com.ipartek.formacion.ejercicios;

public class Excepciones {

	public static void main(String[] args) {

		System.out.println("Comenzando main...");
		try {
			metodoA();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Saliendo main...");

	}

	private static void metodoA() throws Exception {

		System.out.println("Entrando A...");
		metodoB();
		System.out.println("Saliendo A...");

	}

	private static void metodoB() throws Exception {

		System.out.println("Entrando B...");
		metodoC();
		System.out.println("Saliendo B...");

	}

	private static void metodoC() throws Exception {
		System.out.println("Entrando C...");
		throw new Exception("Excepción capturada.");
		// System.out.println("Saliendo C...");

	}

}
