package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa que calcula el área de un triángulo a partir de la longitud de sus
 * lados.
 * 
 * Area = RaizCuadrada(p*(p-a)*(p-b)*(p-c)) donde p = (a+b+c)/2 Para calcular la
 * raíz cuadrada se utiliza el método Math.sqrt()
 * 
 * @author Curso
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double lado1;
		double lado2;
		double lado3;
		double p;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el primer lado del triangulo");
		lado1 = sc.nextDouble();
		System.out.println("Introduce el segundo lado del triangulo");
		lado2 = sc.nextDouble();
		System.out.println("Introduce el tercer lado del triangulo");
		lado3 = sc.nextDouble();

		p = (lado1 + lado2 + lado3) / 2;

		System.out.println("El area del triangulo es: " + Math.sqrt(p * (p - lado1) * (p - lado2) * (p - lado3)));

		sc.close();
	}

}
