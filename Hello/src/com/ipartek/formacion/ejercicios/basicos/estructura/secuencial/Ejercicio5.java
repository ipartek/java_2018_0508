package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que lee por teclado el valor del radio de una circunferencia y calcula y muestra por pantalla la longitud y <br>
 * el área de la circunferencia.<br>
 * Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia = PI*Radio^2<br>
 * @author Curso
 *
 */

public class Ejercicio5 {
	public static void main(String[] args){
		
		float radio;
		float longitud;
		float area;
		
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el radio de una circunferencia: "); 
        radio = sc.nextFloat();   
        longitud= (float) (2 * Math.PI * radio);
        area= (float) (Math.PI * Math.pow(radio, 2));
        System.out.println("Longitud de la circunferencia es: " + longitud);
        System.out.println("El area de la circunferencia es: " + area);
        sc.close();
	}
}
