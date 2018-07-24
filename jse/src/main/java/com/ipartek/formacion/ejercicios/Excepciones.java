package com.ipartek.formacion.ejercicios;

public class Excepciones {

	public static void main(String[] args) {

		System.out.println("Comenzamos ejecucion....");

		try {
			/*
			 * Object o = null; o.toString();
			 */

			// Declaraci�n el ArrayList
			//int[] array = new int[5];
			//int exceptionArray = array[5];
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("ArrayIndexOutOfBoundsException");

		} catch (NullPointerException e) {
			System.out.println("Null exception");
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("USUARIO=> Upps,Lo sentimos pero ha surgido un problema");

			System.out.println("LOG=> " + e);
		} finally {
			System.out.println("terminamos ejecucion(Siempre se debe ejecutar)");

		}

	}

}
