package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que tome como dato de entrada un número que corresponde a la
 * longitud del radio una esfera y nos calcula y escribe el volumen de la esfera
 * que se corresponden con dicho radio.
 * 
 * La fórmula para calcular el volumen de la esfera es v = (4/3)*PI*r^3
 * 
 * @author valen
 *
 */

public class Ejercicio8 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		double longitud;
		double radio;

		System.out.println("Ingresa el  numero corresponde al radio de una esfera =  ");
		radio = p.nextDouble();
		System.out.println(" El volumen de la esfera radio es =" + (4.0 / 3) * Math.PI * Math.pow(radio, 3));
	}

}
