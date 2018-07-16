package com.ipartek.formacion.ejercicios;

public class Excepciones {

	public static void main(String[] args) {

		System.out.println("Comensamo ejecusio");

		// TODO capturar y conseguir que entre en un catch de ArrayIndexOfBoundException

		// TODO crear una nueva clase Excepciones2, con un metodo main, metodoA, metodoB
		// y metodoC
		
		//el metodo B lanza excepcion
		//el throws se lanza parriba
		//capturar excepciones para que se ejecuten todos los metodos como si no hubiera excepcion

		try {
			int[] numeros = new int[4];
			int excepcionArray = numeros[5];

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException -> Vamo a calmarno");
		} finally {
			System.out.println("Terminamos ejecucion (Siempre se debe ejecutar)");
		}
	}

}
