package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa que lea un número entero N de 5 cifras y muestre sus cifras
 *         desde el final igual que en el ejemplo.
 *
 */
public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("Introduzca un número de 5 cifras: ");
		num = sc.nextInt();
		System.out.println(num);
		System.out.println(num / 10);
		System.out.println(num / 100);
		System.out.println(num / 1000);
		System.out.println(num / 10000);

	}

}
