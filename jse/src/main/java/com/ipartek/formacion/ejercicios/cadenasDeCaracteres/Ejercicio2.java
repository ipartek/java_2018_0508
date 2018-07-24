package com.ipartek.formacion.ejercicios.cadenasDeCaracteres;

/**
 * 2. Eliminar la última palabra de una frase.
 * 
 * @author Curso
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		String frase = "Hola holita vecinito";

		System.out.println("La frase: " + frase);

		int palabras = 0;
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == ' ') {
				palabras = i;
			}
		}

		frase = frase.substring(0, palabras);
		
		System.out.println("Si quitamos la ultima palabra, la frase queda: " + frase);

	}

}
