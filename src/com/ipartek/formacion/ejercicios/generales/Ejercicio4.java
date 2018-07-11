package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 *Programa Java que lea un número entero N y muestre la tabla de multiplicar de 
 *ese número. Por ejemplo, si se lee el valor 7 se mostrará por pantalla:
 *
 *Tabla del 7
 *--------------
 *7 * 1  =  7
 *7 * 2  = 14
 *7 * 3  = 21
 *7 * 4  = 28
 *7 * 5  = 35
 *7 * 6  = 42
 *7 * 7  = 49
 *7 * 8  = 56
 *7 * 9  = 63
 *7 * 10 = 70
 */

public class Ejercicio4 {

	public static void main(String[] args) {
		int numero;
		int resultado;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero ");
		numero = sc.nextInt();
		
		System.out.println("Tabla del " + numero);
		System.out.println("--------------");
		for(int i=1; i<=10; i++) {
			resultado = numero * i;
			System.out.println(numero + " * " + i + " = " + resultado);
		}
		
		sc.close();
	}

}
