package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * rograma para intercambiar el valor de dos variables. Los valores iniciales se
 * leen por teclado.
 * 
 * Por ejemplo, suponiendo que las variables se llaman A y B, si A contiene 3 y
 * B contiene 5, después del intercambio A contendrá 5 y B 3.
 * 
 * En este ejemplo, para intercambiar el valor entre dos variables utilizaremos
 * una avariable auxiliar donde guardar el valor de una de ellas. Después
 * veremos la forma de hacerlo sin usar una variable auxiliar para el
 * intercambio.
 * 
 * Las instrucciones a realizar son:
 * 
 * AUX = A; A = B; B = AUX;
 * 
 * @author valen
 *
 */

public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		int a;
		int b;
		int aux;

		System.out.println("Ingrese el valor de la primera variable = ");
		a = p.nextInt();
		System.out.println("Ingrese el valor de la segunda variable = ");
		b = p.nextInt();
		System.out.println("La variable ingresada de a es = " + a + " La variable ingresa de b es = ");

		aux = a;
		a = b;
		b = aux;
		System.out.println(" Ahora el valor de b es = " + b + " Ahora el valor de a es = " + a);

	}

}
