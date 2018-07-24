package com.ipartek.formacion.ejercicios.cadenasDeCaracteres;

/**
 * 3. Contar el número de veces que aparece un carácter en un texto.
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		String frase = "Hola holita vecinito";

		System.out.println("La frase: " + frase);

		int veces = 0;
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == 'o') {
				veces++;
			}
		}

		System.out.println("Tiene " + veces + "veces la letra o.");

	}

}
