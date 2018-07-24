package com.ipartek.formacion.ejercicios.cadenasDeCaracteres;

/**
 * 1. Contar el número de palabras de una frase.
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		String frase = "Hola holita vecinito";
		
		System.out.println("La frase: "+frase);
		
		int palabras = 1;
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == ' ') {
				palabras++;
			}
		}
		
		System.out.println("Tiene "+palabras+" palabras");
	}

}
