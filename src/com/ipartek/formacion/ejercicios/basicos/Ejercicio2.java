package com.ipartek.formacion.ejercicios.basicos;

/**
 * Escribe un programa Java que realice lo siguiente: declarar dos variables <b>x</x> e <b>y</> de tipo int, <br>
 * dos variables <b>n</b> y <b>m</b> de tipo double y asigna a cada una un valor. A continuación muestra por pantalla:<br>
 *  El valor de cada variable.<br>
 *  La suma  X + Y<br>
 *  La diferencia  X – Y<br>
 *  El producto  X * Y<br>
 *  El cociente  X / Y<br>
 *  El resto  X % Y<br>
 *  La suma  N + M<br>
 *  La diferencia  N – M<br>
 *  El producto  N * M<br>
 *  El cociente  N / M<br>
 *  El resto  N % M<br>
 *  La suma X + N<br>
 *  El cociente Y / M<br>
 *  El resto Y % M<br>
 *  El doble de cada variable<br>
 *  La suma de todas las variables<br>
 *  El producto de todas las variables<br>
 *  Si por ejemplo le hemos dado a X el valor 1, a Y el valor 2, a M el valor 3.2 y a N el valor 4.7 se debe mostrar por pantalla:<br>
 *  Variable X = 1<br>
 *  Variable Y = 2<br>
 *  Variable M = 3.2<br>
 *  Variable N = 4.7<br>
 *  1 + 2 = 3<br>
 *  1 - 2 = -1<br>
 *  1 * 2 = 2<br>
 *  1 / 2 = 0<br>
 *  1 % 2 = 1<br>
 *  4.7 + 3.2 = 7.9<br>
 *  4.7 - 3.2 = 1.5<br>
 *  4.7 * 3.2 = 15.040000000000001<br>
 *  4.7 / 3.2 = 1.46875<br>
 *  4.7 % 3.2 = 1.5<br>
 *  1 + 4.7 = 5.7<br>
 *  2 / 3.2 = 0.625<br>
 *  2 % 3.2 = 2.0<br>
 *  Variable X = 1 el doble es 2<br>
 *  Variable Y = 2 el doble es 4<br>
 *  Variable M = 3.2 el doble es 6.4<br>
 *  Variable N = 4.7 el doble es 9.4<br>
 *  1 + 2 + 4.7 + 3.2 = 10.9<br>
 *  1 * 2 * 4.7 * 3.2 = 30.080000000000002<br>

 * @author Curso
 *
 */

public class Ejercicio2 {
	public static void main(String[] args){
		int x = 1;
		int y = 2;
		float n = 3.2f;
		float m = 4.7f;
		
		System.out.println("Variable X = " + x);
		System.out.println("Variable Y = "+ y);
		System.out.println("Variable M = "+ n);
		System.out.println("Variable N = "+ m);
		
		System.out.println("La suma  X + Y: " + (x+y));
		System.out.println("La diferencia  X – Y: " + (x-y));
		System.out.println("El producto  X * Y: " + x*y);
		System.out.println("El cociente  X / Y: " + x/y);
		System.out.println("El resto  X % Y: " + (x%y));
		System.out.println("La suma  N + M: " + (n+m) );
		System.out.println("La diferencia  N – M: " + (n-m));
		System.out.println("El producto  N * M: " + (n*m));
		System.out.println("El cociente  N / M: " + (n/m));
		System.out.println("El resto  N % M: " + (n%m));
		System.out.println("La suma X + N: " + (x+n));
		System.out.println("El cociente Y / M: " + (y/m));
		System.out.println("El resto Y % M: " + (y%m));
		System.out.println("El doble de X: " + (x*2) );
		System.out.println("El doble de Y: " + (y*2) );
		System.out.println("El doble de N: " + (n*2) );
		System.out.println("El doble de M: " + (m*2) );
		System.out.println("La suma de todas las variables: " + (x+y+n+m));
		System.out.println("El producto de todas las variables: " + (x*y*n*m));

		
	}
}
