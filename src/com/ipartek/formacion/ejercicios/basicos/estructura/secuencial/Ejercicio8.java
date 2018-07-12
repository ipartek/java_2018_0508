package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
* Programa que tome como dato de entrada un número que corresponde a la 
* longitud del radio una esfera y nos calcula y escribe el volumen de la 
* esfera que se corresponden con dicho radio.
* 
* La fórmula para calcular el volumen de la esfera es 
* v = (4/3)*PI*r^3
*/
public class Ejercicio8 {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		int radio;
		double volumen;
		
		System.out.println("Introduce el radio de una esfera");
		
		radio = sc.nextInt();
		
		volumen = (4/3) * Math.PI * Math.pow(radio, 3);
		
		System.out.println("El volumen de esa esfera es " + volumen + "cm3");
		
		sc.close();

	}

}
