package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * 
 * @author Curso Escribe un programa Java que realice lo siguiente: declarar dos
 *         variables X e Y de tipo int, dos variables N y M de tipo double y
 *         asigna a cada una un valor. A continuación muestra por pantalla: El
 *         valor de cada variable. La suma X + Y La diferencia X – Y El producto
 *         X * Y El cociente X / Y El resto X % Y La suma N + M La diferencia N
 *         – M El producto N * M El cociente N / M El resto N % M La suma X + N
 *         El cociente Y / M El resto Y % M El doble de cada variable La suma de
 *         todas las variables El producto de todas las variables Si por ejemplo
 *         le hemos dado a X el valor 1, a Y el valor 2, a M el valor 3.2 y a N
 *         el valor 4.7 se debe mostrar por pantalla:
 */
public class Ejercicio2 {
	public static void main(String[] args) {

		int x = 7;
		int y = 3;
		double m = 2.5;
		double n = 10.0;
		System.out.println("La suma de x + y: " + (x + y));
		System.out.println("La resta de x - y: " + (x - y));
		System.out.println("La multiplicacion dex * y: " + (x * y));
		System.out.println(" El cociente de x / y: " + (x / y));
		System.out.println(" El resto de x entre y : " + (x % y));
		System.out.println("La suma de m + n: " + (m + n));
		System.out.println("La resta de m - n: " + (m - n));
		System.out.println("La multiplicacion de m * n: " + (m * n));
		System.out.println("La division de m / n: " + (m / n));
		System.out.println("El resto de m / n: " + (m % n));
		System.out.println("El doble de x: " + (x * 2));
		System.out.println("El doble de y: " + (y * 2));
		System.out.println("El doble de m: " + (m * 2));
		System.out.println("El doble de n: " + (n * 2));
		System.out.println("La suma de todas las variables: " + (x + y + m + n));
		System.out.println("El producto de todas las variables es: " + (x * y * m * n));

	}

}
