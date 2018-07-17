package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa que lea un número entero N de 5 cifras y muestre sus cifras desde el
 * principio como en el ejemplo.
 * Por ejemplo para un número N = 12345   
 * La salida debe ser:
 * 1
 * 12
 * 123
 * 1234
 * 12345
 * 
 * @author Curso
 *
 */
public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero de 5 cifras: ");
		numero = sc.nextInt();

		System.out.println(numero / 10000);
		System.out.println(numero / 1000);
		System.out.println(numero / 100);
		System.out.println(numero / 10);
		System.out.println(numero);

		sc.close();
	}

}
