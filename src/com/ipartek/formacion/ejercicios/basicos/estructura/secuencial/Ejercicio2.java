package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * @author andreaPerez
 *
 *         Programa Java que lea un nombre y muestre por pantalla: “Buenos dias
 *         nombre_introducido”
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String nombre = "";
		System.out.print("Ingrese un nombre: ");
		nombre = sc.next();
		System.out.println("Buenos dias " + nombre);
		sc.close();
		// TODO Hacer validacion si es String lo que ingresa.

	}

}
