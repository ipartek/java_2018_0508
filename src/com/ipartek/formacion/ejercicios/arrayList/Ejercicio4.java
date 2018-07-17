package com.ipartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cadena más larga contenida en un ArrayList de Strings.
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> palabras = new ArrayList<String>();
		
		int cantidadPalabras;
		
		do {
			System.out.println("¿Cuántas palabras quieres introducir en la lista?");
			cantidadPalabras = sc.nextInt();
		} while (cantidadPalabras <= 0);
		
		for (int i = 0; i < cantidadPalabras; i++) {
			
		}
		
	}

}
