package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que lea un nombre y muestre por pantalla:
“Buenos dias nombre_introducido”
 * @author Curso
 *
 */

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		String cadena;
		System.out.println("Introduce tu nombre :");
		cadena = p.nextLine();
		System.out.println("Buenos dias " + cadena);

	}

}
