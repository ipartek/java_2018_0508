package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que tome como dato de entrada un número que corresponde a la
 * longitud del radio una esfera y nos calcula y escribe el volumen de la esfera
 * que se corresponden con dicho radio. <br>
 * La fórmula para calcular el volumen de la esfera es v = (4/3)*PI*r^3
 */

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca el radio de una esfera:  ");
		float radius = teclado.nextFloat();
		System.out.println("El volumen es : " + (4.0f / 3.0f) * Math.PI * Math.pow(radius, 3));
		teclado.close();

	}

}
