package com.ipartek.formacion.ejercicios;

public class Excepciones {

	public static void main(String[] args) {

		System.out.println("Comenzamos ejecución....");

		try {

			int[] numeros = new int[5];
			for (int i = 0; i <= numeros.length; i++) {
				numeros[i] = i;
			}

			// TODO capturar una excepcion que entre en un catch de ArrayIndexo...
			// TOTO crear una nueva clase llamada Excepciones2, con un metodo main, a, b, c
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("El array no tiene tantas posiciones");

		} catch (NullPointerException e) {
			System.out.println("Null exception");

		} catch (Exception e) {
			System.out.println("USUARIO=> Lo sentimos, pero ha surgido un problema");

		} finally {
			System.out.println("Terminamos ejecución");
		}

	}

}
