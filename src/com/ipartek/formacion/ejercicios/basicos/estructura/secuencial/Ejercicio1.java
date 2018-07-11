package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que lea dos numeros enteros por teclado y los muestre por
 * pantalla.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String respuesta = "";
		int primerNum = 0;
		int segundoNum = 0;
		boolean aux = false;
		int cont = 0;

		do {
			System.out.print("Ingresa un numero entero:");
			respuesta = sc.next();

			aux = isNumeric(respuesta);

			if (aux == true && cont == 0) {
				primerNum = Integer.parseInt(respuesta);
				cont++;
			} else if (aux == true && cont == 1) {
				segundoNum = Integer.parseInt(respuesta);
				cont++;
			} else {
				System.out.println("Error: Ingresa un numero entero,por favor.");
			}
		} while (cont != 2);

		System.out.println("El primer numero es " + primerNum + " y el segundo numero es " + segundoNum);
		sc.close();
	}

	/**
	 * Metodo que recoge la excepcion NumberFormatException si no es un numero entero
	 * 
	 * @param cadena
	 * @return boolean
	 */
	private static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}
