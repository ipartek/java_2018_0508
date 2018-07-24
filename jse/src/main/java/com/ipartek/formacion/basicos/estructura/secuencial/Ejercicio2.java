package com.ipartek.formacion.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que lea un nombre y muestre por pantalla: ¡Buenos dias
 * nombre_introducido!.
 * 
 * @author Curso
 *
 */

public class Ejercicio2 {

	static Scanner sc = new Scanner(System.in);
	static String nombre;

	public static void main(String[] args) {

		System.out.println("¿Cómo te llamas?");
		nombre = sc.nextLine();
		System.out.println("!Buenos días " + nombre + "!");
	}

}
