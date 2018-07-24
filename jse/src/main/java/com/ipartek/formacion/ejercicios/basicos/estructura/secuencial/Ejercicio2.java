package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
* Programa Java que lea un nombre y muestre por pantalla:
* “Buenos dias nombre_introducido”
*/
public class Ejercicio2 {

	public static void main(String[] args) {
		

		//TODO controlar que solo se introduzcan Strings
		Scanner sc = new Scanner(System.in);
		String nombre = "";
		
		System.out.println("Escribe tu nombre");
		
		nombre = sc.next();
		
		System.out.println("Buenos días " + nombre);
		
		sc.close();
		
	}

}
