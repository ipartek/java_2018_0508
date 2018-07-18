package com.ipartek.formacion.ejercicios;

public class Excepciones {
	public static void main(String[] args) {

		System.out.println("Comentamos ejecucion....");
		
		int[] aEnteros = new int[5];
		int excepcionArrar = aEnteros[5];

		try {

			/*
			 * Object o = null; o.toString();
			 */

			// capturar y conseguir que entre es un catch de ArrayIndexBoundException
			// crear una nueva clase de Excepciones2, con un metodo main, metodoA, metodoB y
			// metodoC

			// el main lleva a el b a c y despues poner la exception

		} catch (Exception e) {

			System.out.println("Lo sentimos ha surgido un problema");
			System.out.println("LOG =>" + e);

		} finally {

			System.out.println("Terminamos ejecucion (Siempre se debe ejecutar )");

		}

	}

}
