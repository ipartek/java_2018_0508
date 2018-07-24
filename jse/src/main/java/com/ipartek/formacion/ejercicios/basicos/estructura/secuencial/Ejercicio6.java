package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
* Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por teclado.
*/
public class Ejercicio6 {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		int velocidadKilometros;
		int velocidadMetros;
		
		System.out.println("¿A qué velocidad va el coche?");
		
		velocidadKilometros = sc.nextInt();
		
		velocidadMetros = velocidadKilometros * 1000 / 3600;
		
		System.out.println("El coche va a " + velocidadMetros + " m/s");
		
		sc.close();
		
	}

}
