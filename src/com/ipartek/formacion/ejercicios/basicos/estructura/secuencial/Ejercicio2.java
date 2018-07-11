package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		/**
		 * Programa Java que lea un nombre y muestre por pantalla:
		 * “Buenos dias nombre_introducido”
		 */

		//TODO controlar que solo se introduzcan Strings
		Scanner leer = new Scanner(System.in);
		String nombre = "";
		
		System.out.println("Escribe tu nombre");
		
		nombre = leer.nextLine();
		
		System.out.println("Buenos días " + nombre);
		
		leer.close();
		
	}

}
