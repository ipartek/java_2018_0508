package com.ipartek.formacion.ejercicios;

public class Excepciones {
	public static void main(String[] args) {

		System.out.println("Comenzamos ejecucion.....");

		try {

			/*
			 * Object o = null; o.toString();
			 */

			int[] aEnteros = new int[5];
			int excepcionArray = aEnteros[5];

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException => Nos hemo salido del array");

		} catch (NullPointerException e) {
			System.out.println("NULL exception");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("USUARIO => Lo sentimos pero ha sugido un problema");

			System.out.println("LOG => " + e);

		} finally {
			System.out.println("Terminamos ejecucion ( Siempre se debe ejecutar)");
		}

	}
}
