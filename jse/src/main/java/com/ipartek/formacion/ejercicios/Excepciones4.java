package com.ipartek.formacion.ejercicios;

public class Excepciones4 {

	public static void main(String[] args) {

		System.out.println("Empiezo metodo Main");
		try {

			metodoA();

		} catch (Exception e) {

		} finally {
			System.out.println("Termino metodo Main");
		}
	}

	private static void metodoA() {

		System.out.println("	Empiezo metodo MetodoA");
		try {
			metodoB();
		} catch (Exception e) {
			
		}finally {
			System.out.println("	Termino metodo MetodoA");	
		}

	}

	private static void metodoB() {

		System.out.println("		Empiezo metodo MetodoB");
		try {
			metodoC();
		} catch (Exception e) {
			
		}finally {
			System.out.println("		Termino metodo MetodoB");

		}
		
	}

	private static void metodoC() {

		System.out.println("			Empiezo metodo MetodoC");
		try {
			Object o = null;
			o.toString();
		} catch (Exception e) {
			
		}finally {
			System.out.println("			Termino metodo MetodoC");	
		}
	}

}
