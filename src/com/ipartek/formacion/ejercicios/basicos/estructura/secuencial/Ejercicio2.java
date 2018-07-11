package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.*;

/**
 * Programa Java que lea un nombre y muestre por pantalla: “Buenos dias
 * nombre_introducido”
 * 
 * @author Curso
 *
 */

public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Nombre: ");
		String nombre = sc.nextLine();

		System.out.println("Buenos dias " + nombre);

		sc.close();
	}

}
