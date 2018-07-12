package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa que pase una velocidad en Km/h a m/s. La velocidad se lee
 *         por teclado. La manera de convertir km/h a m/s es dividir 1000
 *         metros/3600s y el número resultante multiplicarlo por la velocidad en
 *         km/h.
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		float vel = 0.0f;
		float velFinal = 0.0f;

		System.out.println("Introduzca una velocidad en Km/h:");
		Scanner sc = new Scanner(System.in);
		vel = sc.nextFloat();
		velFinal = vel * 0.2778f;
		System.out.println("La velocidad introducida convertida a m/s es: " + velFinal);
		sc.close();

	}

}
