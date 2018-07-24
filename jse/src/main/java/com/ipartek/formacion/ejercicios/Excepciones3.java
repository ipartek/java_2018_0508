package com.ipartek.formacion.ejercicios;

public class Excepciones3 {

	public static void main(String[] args) {

		System.out.println("Empiezo metodo Main");
		try {

			metodoA();

		} catch (Exception e) {

			System.out.println("Ha ocurrido un NULL");

		} finally {
			System.out.println("Termino metodo Main");
		}
		
	}

	private static void metodoA() throws NullPointerException {

		System.out.println("	Empiezo metodo MetodoA");
		metodoB();
		System.out.println("	Termino metodo MetodoA");

	}

	private static void metodoB() throws NullPointerException {

		System.out.println("		Empiezo metodo MetodoB");
		metodoC();
		System.out.println("		Termino metodo MetodoB");

	}

	private static void metodoC() throws NullPointerException {
		
		System.out.println("			Empiezo metodo MetodoC");
		Object o = null;
		o.toString();
		System.out.println("			Termino metodo MetodoC");
	}

}
