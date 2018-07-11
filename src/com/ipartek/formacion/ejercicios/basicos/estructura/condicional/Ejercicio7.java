package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;
import java.util.Scanner;

/**
 * Programa que lea dos números por teclado y muestre el resultado de la
 * división del primer número por el segundo. Se debe comprobar que el divisor
 * no puede ser cero.
 * 
 */

public class Ejercicio7 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca el primer numero: ");
		float x = teclado.nextInt();
		float y = 0.0f;
		while(y==0.0f) {
			System.out.print("Introduzca el segundo numero: ");		
			y = teclado.nextInt();
		}		
		System.out.println(x/y);
		teclado.close();

	}

}
