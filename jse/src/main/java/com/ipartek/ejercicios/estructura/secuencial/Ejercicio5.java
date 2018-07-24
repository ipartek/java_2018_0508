package com.ipartek.ejercicios.estructura.secuencial;
import java.util.Scanner;
/**
 *  Programa que lee por teclado el valor del radio de una circunferencia y calcula y muestra por pantalla la longitud y el área de la circunferencia. 
 * @author Curso
 *
 */

public class Ejercicio5 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		double radio, longitud, area;
        System.out.println("Introduce radio de la circunferencia:");
        radio = sc.nextDouble();
        longitud = 2 * Math.PI * radio; 
        area = Math.PI * Math.pow(radio, 2);
        System.out.println("Longitud de la circunferencia: " + longitud);
        System.out.println("Area de la circunferencia: " + area);
	}

}
