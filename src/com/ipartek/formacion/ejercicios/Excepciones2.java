package com.ipartek.formacion.ejercicios;

public class Excepciones2 {

	public static void main(String[] args) {
		System.out.println("main entro");
		
		metodoA();
		
		System.out.println("main salgo");
	}

	public static void metodoA() {
		System.out.println("metodoA entro");
		metodoB();
		System.out.println("metodoA salgo");
	}

	public static void metodoB() {
		System.out.println("metodoB entro");
		/*
		Object o = null;
		o.toString();
		*/
		metodoC();

		System.out.println("metodoB salgo");

			}

	public static void metodoC() {

	}

	
}

