package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * @author Asier Cornejo
 *
 *         Programa Java que lea un nombre y muestre por pantalla: “Buenos dias
 *         nombre_introducido”.
 */
public class Ejercicio2 {
	public static void main(String[] args) {

		String nombre = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor introduzca su nombre.");
		nombre = sc.nextLine();
		System.out.println("Buenos dias " + nombre);
	}
}
