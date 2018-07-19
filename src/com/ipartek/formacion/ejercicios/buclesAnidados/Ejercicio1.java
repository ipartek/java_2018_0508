package com.ipartek.formacion.ejercicios.buclesAnidados;

import java.util.Scanner;

/**
 * 
 * Número perfecto en java Qué es un número perfecto?
 * 
 * Un número es perfecto si es igual a la suma de todos sus divisores positivos
 * sin incluir el propio número.
 * 
 * Por ejemplo, el número 6 es perfecto.
 * 
 * El 6 tiene como divisores: 1, 2, 3 y 6 pero el 6 no se cuenta como divisor
 * para comprobar si es perfecto.
 * 
 * Si sumamos 1 + 2 + 3 = 6
 * 
 * Los siguientes números perfectos después del 6 son 28, 496, 8128, 33550336,
 * 8589869056.
 * 
 * En esta entrada vamos a desarrollar el algoritmo para comprobar si un número
 * es perfecto. El programa pide por teclado un número y muestra si es perfecto
 * o no. mediante un bucle for sumaremos los divisores del número. Al final si
 * esta suma es igual al número mostraremos el mensaje correspondiente.
 * 
 * Programa java para calcular si un número es perfecto:
 * 
 * @author Curso
 *
 */

public class Ejercicio1 {
	public static void main(String[] args) {
		int numero;
		int suma = 0;
		int i;
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un numero por favor = ");
		numero = s.nextInt();
		for (i = 0; i < numero; i++) {
			if (numero % i == 0) {
				suma = suma + i;

			}
		}
		if(suma == numero) {
			System.out.println("El numero ingresado es perfecto ");

		}else {
			System.out.println("El numero ingresado no es perfecto ");
		}

	}

}
