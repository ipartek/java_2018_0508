package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que lea un nombre y muestre por pantalla:
 * “Buenos dias nombre_introducido”
 * @author Curso
 *
 */  

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String nombre;
		
		System.out.println("Escribe un nombre:");
		nombre = teclado.nextLine();
		
		System.out.println();
		System.out.println("Buenos días " + nombre);

		teclado.close();
	}

}
