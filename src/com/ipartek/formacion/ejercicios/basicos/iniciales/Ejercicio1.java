package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa Java que realice lo siguiente: declarar una variable
 * <b>n</b> de tipo int, una variable <b>a</b> de tipo double y una variable
 * <b>c</b> de tipo char y asigna a cada una un valor. A continuación muestra
 * por pantalla: El valor de cada variable. La suma de n + a La diferencia de a
 * - n El valor numérico correspondiente al carácter que contiene la variable c.
 * Si por ejemplo le hemos dado a n el valor 5, a a el valor 4.56 y a c el valor
 * ‘a’, se debe mostrar por pantalla:
 * 
 * Variable N = 5 Variable A = 4.56 Variable C = a 5 + 4.56 = 9.559999999999999
 * 4.56 - 5 = -0.4400000000000004 Valor numérico del carácter a = 97
 *
 * 
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		int n = 5;
		double a = 4.96;
		char c = 'c';

		System.out.println("Variable n = " + n);
		System.out.println("Variable a = " + a);
		System.out.println("Variable c = " + c);

		System.out.println("n+a es igual a " + (n + a) + "\n a-n es igual a " + (a - n));

		System.out.println("El valor numerico de " + c + " es " + (int) c);

	}

}
