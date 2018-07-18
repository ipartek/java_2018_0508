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
		String texto;
		String cadenaLarga = "";
		
		do {
			System.out.println("¿Cuántas palabras quieres introducir en la lista?");
			cantidadPalabras = sc.nextInt();
		} while (cantidadPalabras <= 0);
		
		for (int i = 0; i < cantidadPalabras; i++) {
			System.out.println("Introduce una palabra");
			texto = sc.next();
			while(texto == "") {
				System.out.println("Debe escribir algo");
				texto = sc.next();
			}
			palabras.add(texto);
		}
		
		for (int i = 0; i < palabras.size(); i++) {
			if(palabras.get(i).length() > cadenaLarga.length()) {
				cadenaLarga = palabras.get(i);
			}
		}
		
		System.out.println("La cadena más larga de esta colección es " + cadenaLarga);
		
		sc.close();
		
	}

}
