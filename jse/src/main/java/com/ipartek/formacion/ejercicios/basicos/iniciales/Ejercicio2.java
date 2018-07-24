package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
* Escribe un programa Java que realice lo siguiente: declarar dos variables X e Y 
* de tipo int, dos variables N y M de tipo double y asigna a cada una un valor. 
* A continuación muestra por pantalla:
* El valor de cada variable.
* La suma  X + Y
* La diferencia  X – Y
* El producto  X * Y
* El cociente  X / Y
* El resto  X % Y
* La suma  N + M
* La diferencia  N – M
* El producto  N * M
* El cociente  N / M
* El resto  N % M
* La suma X + N
* El cociente Y / M
* El resto Y % M
* El doble de cada variable
* La suma de todas las variables
* El producto de todas las variables
* Si por ejemplo le hemos dado a X el valor 1, a Y el valor 2, a M el valor 3.2 
* y a N el valor 4.7 se debe mostrar por pantalla:
* Variable X = 1
* Variable Y = 2
* Variable M = 3.2
* Variable N = 4.7
*/
public class Ejercicio2 {

	public static void main(String[] args) {
		
		int x = 1;
		int y = 2;
		double n = 3.2;
		double m = 4.7;
		
		System.out.println("Variable X = " + x);
		System.out.println("Variable Y = " + y);
		System.out.println("Variable N = " + n);
		System.out.println("Variable M = " + m);
		
		System.out.println("La suma de X + Y = " + (x + y));
		System.out.println("La resta de X - Y = " + (x - y));
		System.out.println("La multiplicación de X * Y = " + (x * y));
		System.out.println("La división de X / Y = " + (x / y));
		System.out.println("El resto de X % Y = " + (x % y));
		
		System.out.println("La suma de N + M = " + (n + m));
		System.out.println("La resta de N - M = " + (n - m));
		System.out.println("La multiplicación de N * M = " + (n * m));
		System.out.println("La división de N / M = " + (n / m));
		System.out.println("El resto de N % M = " + (n % m));
		
		System.out.println("La suma de X + N = " + (x + n));
		System.out.println("La división de Y + M = " + (y / m));
		System.out.println("El resto de Y % M = " + (y % m));
		
		System.out.println("El doble de X es = " + (2 * x));
		System.out.println("El doble de Y es = " + (2 * y));
		System.out.println("El doble de N es = " + (2 * n));
		System.out.println("El doble de M es = " + (2 * m));
		
		System.out.println("La suma de todas las variables es = " + (x + y + n + m));
		System.out.println("La multiplicación de todas las variables es = " + (x * y * n * m));

	}

}
