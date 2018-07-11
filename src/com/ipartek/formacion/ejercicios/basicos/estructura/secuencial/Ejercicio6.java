package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		/**
		 * Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por teclado.
		 */

		Scanner leer = new Scanner(System.in);
		
		int velocidadKilometros;
		int velocidadMetros;
		
		System.out.println("¿A qué velocidad va el coche?");
		
		velocidadKilometros = leer.nextInt();
		
		velocidadMetros = velocidadKilometros * 1000 / 3600;
		
		System.out.println("El coche va a " + velocidadMetros + " m/s");
		
		leer.close();
		
	}

}
