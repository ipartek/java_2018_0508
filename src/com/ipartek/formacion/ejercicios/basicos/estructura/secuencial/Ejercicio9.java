package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		double a, b, c, p;
		double area;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el valor de a");
		a = sc.nextDouble();
		
		System.out.println("Introduce el valor de b");
		b = sc.nextDouble();
		
		System.out.println("Introduce el valor de c");
		c = sc.nextDouble();
		
		p = (a + b + c)/2;
		
		area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		System.out.println("El area de ese triangulo es: " + area);
	}

}
