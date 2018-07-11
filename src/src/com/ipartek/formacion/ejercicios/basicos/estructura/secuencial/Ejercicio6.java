package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por
 * teclado.
 */

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca la velocidad (km/h):  ");
		float velocity = teclado.nextFloat();
		System.out.println("Velocidad: " + velocity * 1000 + "m/s");
		teclado.close();

	}

}
