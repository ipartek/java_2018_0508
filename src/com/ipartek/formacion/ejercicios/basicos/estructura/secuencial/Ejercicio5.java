package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 * @author andreaPerez Programa que lee por teclado el valor del radio de una
 *         circunferencia y calcula y muestra por pantalla la longitud y el área
 *         de la circunferencia. Longitud de la circunferencia = 2*PI*Radio,
 *         Area de la circunferencia = PI*Radio^2
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.00");
		double radio = 0;
		double longitud;
		double area;
		

		System.out.print("Ingrese el radio de una circunferencia: ");
		radio = sc.nextDouble();

		longitud = 2 * Math.PI * radio;
		System.out.println("La longitud de la circunferencia con radio " + radio + " es: " + df.format(longitud));

		area = Math.PI * Math.pow(radio, 2);
		System.out.println("El area de la circunferencia con radio " + radio + " es: " + df.format(area));
	}

}
