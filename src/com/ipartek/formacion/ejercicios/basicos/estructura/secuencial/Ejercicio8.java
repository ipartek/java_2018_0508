package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.*;

/**
 * Programa que tome como dato de entrada un número que corresponde a la
 * longitud del radio una esfera y nos calcula y escribe el volumen de la esfera
 * que se corresponden con dicho radio.
 * 
 * La fórmula para calcular el volumen de la esfera es v = (4/3)*PI*r^3
 * 
 * @author Curso
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		float radio;
		
		System.out.print("Introduce el radio: ");
		radio = sc.nextFloat();
		System.out.println("Volumen: " + ((4f/3)*Math.PI*Math.pow(radio, 3)));
		
		sc.close();
	
	}

}
