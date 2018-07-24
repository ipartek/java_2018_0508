package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * El programa lee por teclado tres números enteros y calcula y muestra el mayor
 * de los tres.
 * 
 * @author valen
 *
 */

public class Ejercicio8 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		int numero1;
		int numero2;
		int numero3;
		System.out.println("Ingrese el primer numero = ");
		numero1 = p.nextInt();
		System.out.println("Ingrese el segundo numero = ");
		numero2 = p.nextInt();
		System.out.println("Ingrese el tercer numero = ");
		numero3 = p.nextInt();
		if (numero1 > numero2) {
			if (numero1 > numero3) {
				System.out.println("El numero mayor es: " + numero1);
			} else {
				System.out.println("El numero mayor es: " + numero3);
			}
		} else if (numero2 > numero3) {
			System.out.println("El numero mayor es: " + numero2);
		} else {
			System.out.println("El numero mayor es: " + numero3);
		}
	}

}
