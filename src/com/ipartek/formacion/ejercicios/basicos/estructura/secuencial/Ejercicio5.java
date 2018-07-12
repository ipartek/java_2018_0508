package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
* Programa que lee por teclado el valor del radio de una circunferencia y calcula y 
* muestra por pantalla la longitud y el área de la circunferencia. 
* Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia = PI*Radio^2  
*/
public class Ejercicio5 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int radio;
		double longitud;
		double area;
		
		System.out.println("Introduce el radio de la circunferencia en cm");
		
		radio = sc.nextInt();
		
		longitud = 2 * Math.PI * radio;
		area = Math.PI * Math.pow(radio, 2);
		
		System.out.println("Longitud de la circunferencia = " + longitud + "cm");
		System.out.println("Area de la circunferencia = " + area + "cm2");
		
		sc.close();
		
	}

}
