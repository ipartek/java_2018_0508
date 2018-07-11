package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que lea un nombre y muestre por pantalla: “Buenos dias
 * nombre_introducido”
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca su nombre: ");
		String nom = teclado.next();

		System.out.println("Buenos dias " + nom);
		teclado.close();

	}

}
