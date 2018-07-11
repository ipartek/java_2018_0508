package com.ipartek.formacion.ejercicios.basicos.iniciales;

/***
 * Escribe un programa Java que realice lo siguiente: declarar dos variables X e
 * Y de tipo int, dos variables N y M de tipo double y asigna a cada una un
 * valor. A continuación muestra por pantalla:
 * 
 * El valor de cada variable.<br>
 * La suma X + Y<br>
 * La diferencia X – Y<br>
 * El producto X * Y<br>
 * El cociente X / Y<br>
 * El resto X % Y<br>
 * La suma N + M<br>
 * La diferencia N – M<br>
 * El producto N * M<br>
 * El cociente N / M <br>
 * El resto N % M <br>
 * La suma X + N <br>
 * El cociente Y / M <br>
 * El resto Y % M <br>
 * El doble de cada variable <br>
 * La suma de todas las variables <br>
 * El producto de todas las variables <br>
 *
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		int x = 2;
		int y = 3;
		double n = 4;
		double m = 5;
		System.out.println("La suma X + Y: " + (x + y));
		System.out.println("La diferencia X – Y: " + (x - y));
		System.out.println("El producto X * Y: " + (x * y));
		System.out.println("El cociente X / Y: " + (x / y));
		System.out.println("El resto X % Y: " + (x % y));
		System.out.println("La suma N + M: " + (n + m));
		System.out.println("La diferencia N – M: " + (n - m));
		System.out.println("El producto N * M: " + (n * m));
		System.out.println("El cociente N / M : " + (n / m));
		System.out.println("El resto N % M : " + (n % m));
		System.out.println("La suma X + N : " + (x + m));
		System.out.println("El cociente Y / M : " + (y / m));
		System.out.println("El resto Y % M : " + (y % m));
		System.out.println("El doble de cada variable : " + (x * 2) + ", " + (y * 2) + ", " + (n * 2) + ", " + (m * 2));
		System.out.println("La suma de todas las variables : " + (x + y + n + m));
		System.out.println("El producto de todas las variables : " + (x * y * n * m));
	}

}
