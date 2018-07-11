package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Ejercicio 9: Programa Java que calcule el área de un triángulo en función de
 * las longitudes de sus lados (a, b, c), según la siguiente fórmula: Area =
 * RaizCuadrada(p*(p-a)*(p-b)*(p-c)) donde p = (a+b+c)/2 Para calcular la raíz
 * cuadrada se utiliza el método Math.sqrt()
 * 
 * @author Curso
 *
 */
public class Ejercicio09 {

	public static void main(String[] args) {

		double a;
		double b;
		double c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("El primer lado del triangulo:");
		a = sc.nextDouble();
		System.out.println("El segundo lado del triangulo:");
		b = sc.nextDouble();
		System.out.println("El tercer lado del triangulo:");
		c = sc.nextDouble();
		
		double p = (a+b+c)/2;
		
		System.out.println("El area del triangulo es "+ Math.sqrt((p*(p-a)*(p-b)*(p-c))));
		sc.close();
	}

}
