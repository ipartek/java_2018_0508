package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa Java que realice lo siguiente: declarar dos variables X e
 * Y de tipo int, dos variables N y M de tipo double y asigna a cada una un
 * valor. A continuación muestra por pantalla:<br>
 * El valor de cada variable.
 * El valor de cada variable.
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
1 + 2 = 3
1 - 2 = -1
1 * 2 = 2
1 / 2 = 0
1 % 2 = 1
4.7 + 3.2 = 7.9
4.7 - 3.2 = 1.5
4.7 * 3.2 = 15.040000000000001
4.7 / 3.2 = 1.46875
4.7 % 3.2 = 1.5
1 + 4.7 = 5.7
2 / 3.2 = 0.625
2 % 3.2 = 2.0
Variable X = 1 el doble es 2
Variable Y = 2 el doble es 4
Variable M = 3.2 el doble es 6.4
Variable N = 4.7 el doble es 9.4
1 + 2 + 4.7 + 3.2 = 10.9
1 * 2 * 4.7 * 3.2 = 30.080000000000002
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		int x = 3;
		int y = 1;
		double m = 2.89;
		double n = 1.67;
		//Asigno a cada uno un valor 
		System.out.println("El valor de x es = " + x);
		System.out.println("El valor de y es = " + y);
		System.out.println("El valor de m es = " + m);
		System.out.println("El valor de n es = " + n);
		//Calculo la operacion cada unos de ellos 
		System.out.println(" La suma de x + y  = " + (x + y));
		System.out.println(" La resta de x - y  = " + (x - y));
		System.out.println(" La multiplicacion de x * y = " + (x * y));
		System.out.println(" La division de x / y = " + (x / y));
		System.out.println(" El resto de la division de x % y = " + (x % y));
		System.out.println(" La suma de m + n  = " + (m + n));
		System.out.println(" La resta de m - n  = " + (m - n));
		System.out.println(" La multiplicacion de m * n = " + (m * n));
		System.out.println( " La division de m / n = " + ( m / n) );
		System.out.println( " El resto de la division de m / n = " + ( m / n));
		System.out.println( " La suma de m + y = " + (m + y));
		System.out.println( " La suma de n + x = " + (n + x));
		System.out.println( " El doble de x = " + (2 * x));
		System.out.println( " El dobre de y = " + (2 * y));
		System.out.println(" El dobre de m = " + ( 2 * m));
		System.out.println(" El doble de n = " + ( 2 * n));
		System.out.println(" La suma de todos los valores es = " + (x+y+m+n));
		System.out.println( " La multiplicacion de todos los valores es = " + (x*y*m*n));
		
	}

}
