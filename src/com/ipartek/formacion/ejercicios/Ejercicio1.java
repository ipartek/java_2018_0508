package com.ipartek.formacion.ejercicios;

/***
 * Escribe un programa Java que realice lo siguiente: declarar una variable
 * <b>n</b> de tipo int, una variable <b>a</b> de tipo double y una variable
 * <b>c</b> de tipo char y asigna a cada una un valor. A continuación muestra
 * por pantalla: El valor de cada variable. La suma de n + a La diferencia de a
 * - n El valor numérico correspondiente al carácter que contiene la variable c.
 * Si por ejemplo le hemos dado a n el valor 5, a A el valor 4.56 y a c el valor
 * ‘a’, se debe mostrar por pantalla:
 * 
 * Variable N = 5<br>
 * Variable A = 4.56<br>
 * Variable C = a 5 + 4.56 = 9.559999999999999<br>
 * 4.56 - 5 = -0.4400000000000004<br>
 * Valor numérico del carácter a = 97<br>
 * 
 * 
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		int n = 2;
		double a = 3;
		char c = 'C';
		System.out.println("n: " + n);
		System.out.println("a: " + a);
		System.out.println("c: " + c);
		System.out.println("n+a: " + (n + a));
		System.out.println("a-n: " + (a - n));
		System.out.println("n: " + (int) c);

	}

}
