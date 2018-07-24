package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que calcule el área de un triángulo en función de las
 * longitudes de sus lados (a, b, c), según la siguiente fórmula: Area =
 * RaizCuadrada(p*(p-a)*(p-b)*(p-c)) donde p = (a+b+c)/2 Para calcular la raíz
 * cuadrada se utiliza el método Math.sqrt()
 * 
 * @author valen
 *
 */

public class Ejercicio9 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double a;
		double b;
		double c;
		double p;
		System.out.println("Ingrese la primera longitud = ");
		a = s.nextDouble();
		System.out.println("Ingrese la segunda longitud = ");
		b = s.nextDouble();
		System.out.println("Ingrese la tercera longitud = ");
		c = s.nextDouble();
		p = (a + b + c) / 2;
		System.out.println(" La area de un triangulo es = " + Math.sqrt(p * (p - a) * (p - b) * (p - c)));

	}

}
