package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.*;

/**
 * Programa que lee por teclado el valor del radio de una circunferencia y
 * calcula y muestra por pantalla la longitud y el área de la circunferencia.
 * 
 * @author Curso
 *
 */

public class Ejercicio5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		float radio;
		
		System.out.print("Introduce el radio: ");
		radio = sc.nextFloat();
		System.out.println("Perimetro: " + 2*Math.PI*radio);
		System.out.println("Area: " + Math.PI*Math.pow(radio,2));
		
		sc.close();
	}

}
