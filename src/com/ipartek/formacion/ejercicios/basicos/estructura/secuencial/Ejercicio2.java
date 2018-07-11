package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 2. Programa Java que lea un nombre y muestre por pantalla: “Buenos <br>
 * dias nombre_introducido”.
 * 
 * @author Curso
 *
 */
public class Ejercicio2 {

	public static String name;
	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		System.out.println("¿Como te llamas?");

		name = scan.nextLine();
		
		System.out.println("Buenos dias "+name);

	}

}
