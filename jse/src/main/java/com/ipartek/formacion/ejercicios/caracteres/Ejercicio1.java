package com.ipartek.formacion.ejercicios.caracteres;

import java.util.Scanner;

/**
 * Programa Java para contar el número de palabras que contiene una frase.
 * El programa lee un texto por teclado y lo guarda en un String. 
 * A continuación mostrará el número de palabras que contiene.
 * @author Adrian Garcia
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String texto;
		int cantidadPalabras;
		
		System.out.println("Introduce una frase cualquiera");
		texto = sc.nextLine();
		
		String palabras[] = texto.split(" ");
		
		cantidadPalabras = palabras.length;
		
		System.out.println("La frase '" + texto + "' contiene " + cantidadPalabras + " palabras");
		
		//System.out.println(texto);
		
		sc.close();
		
	}

}
