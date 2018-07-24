package com.ipartek.formacion.ejercicios;

public class Excepciones2 {

	public static void main(String[] args) {

		System.out.println("Empiezo metodo Main");
		
		metodoA();

		System.out.println("Termino metodo Main");
	}

	private static void metodoA(){

		System.out.println("	Empiezo metodo MetodoA");
		metodoB();
		System.out.println("	Termino metodo MetodoA");

	}

	private static void metodoB(){

		System.out.println("		Empiezo metodo MetodoB");
		metodoC();
		System.out.println("		Termino metodo MetodoB");

	}

	private static void metodoC(){

		System.out.println("			Empiezo metodo MetodoC");
		Object o = null;
		o.toString();
		System.out.println("			Termino metodo MetodoC");
	}

}
