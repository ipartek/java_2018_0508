package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Programa que tome como dato de entrada un número que corresponde a la longitud 
 * del radio una esfera y nos calcula y escribe el volumen de la esfera que se 
 * corresponden con dicho radio.
 * 
 * La fórmula para calcular el volumen de la esfera es 
 * v = (4/3)*PI*r^3
 */

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		double radio;
		double volumen;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cual es el radio de tu esfera? ");
		radio = sc.nextDouble();
		volumen = (4/3)*Math.PI* Math.pow(radio, 3);
		
		System.out.println("Tu esfera de " + radio + " centimetros, tiene un volumen de "
				+ volumen + " centimetros cubicos");

		sc.close();
	}

}
