package com.ipartek.ejercicios.basicos.iniciales;

/**
 * Escribe un programa Java que realice lo siguiente: declarar dos variables X e Y de tipo int, dos variables N y M de tipo double y asigna a cada una un valor. A continuación muestra por pantalla:
El valor de cada variable.
La suma  X + Y
La diferencia  X – Y
El producto  X * Y
El cociente  X / Y
El resto  X % Y
La suma  N + M
La diferencia  N – M
El producto  N * M
El cociente  N / M
El resto  N % M
La suma X + N
El cociente Y / M
El resto Y % M
El doble de cada variable
La suma de todas las variables
El producto de todas las variables
Si por ejemplo le hemos dado a X el valor 1, a Y el valor 2, a M el valor 3.2 y a N el valor 4.7 se debe mostrar por pantalla:
Variable X = 1
Variable Y = 2
Variable M = 3.2
Variable N = 4.7
 * @author Curso
 *
 */

public class Ejercicio2 {
	
	public static void main(String[] args) {
		
		int x=1;
		int y=2;
		double m=3.2;
		double n=4.7;
		
		System.out.println("La suma de X e Y es: "+(x+y));
		System.out.println("La diferencia entre X e Y es: "+(x-y));
		System.out.println("El producto de X*Y es: "+(x*y));
		System.out.println("El cociente de X/Y es: "+(x/y));
		System.out.println("El resto de X%Y es: "+(x%y));
		System.out.println("La suma de N+M es: "+(n+m));
		System.out.println("La diferencia de N-M es: "+(n-m));
		System.out.println("El producto de N*M es: "+(n*m));
		System.out.println("El cociente de N/M es: "+n/m);
		System.out.println("El resto de N%M es: "+(n%m));
		System.out.println("La suma de X+N es: "+(x+n));
		System.out.println("El cociente de Y/M es: "+(y/m));
		System.out.println("El resto de Y%M es: "+(y%m));
		System.out.println("El doble de la variable x es: "+(x*2));
		System.out.println("El doble de la variable y es: "+(y*2));
		System.out.println("El doble de la variable m es: "+(m*2));
		System.out.println("El doble de la variable n es: "+(n*2));
		System.out.println("La suma de todas las variables es: "+(x+y+m+n));
		System.out.println("El producto de todas las variables es: "+(x*y*m*n));
		
		
	}
	

}
