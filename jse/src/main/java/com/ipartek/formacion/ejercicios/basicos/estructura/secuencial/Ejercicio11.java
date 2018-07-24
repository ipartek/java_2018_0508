package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Programa que lea un número entero n de 5 cifras y muestre sus cifras desde el
 * principio como en el ejemplo. Ejemplo para un número n = 12345 La salida debe
 * ser: 1 12 123 1234 12345
 * 
 * @author andreaPerez
 *
 */
public class Ejercicio11 {

	public static void main(String[] args) {
		int num = 12345;
		System.out.println("El numero " + 12345 + " lo separamos en: " + (num / 10000) + "; " + (num / 1000) + "; "
				+ (num / 100) + "; " + (num / 10) + "; " + num);
	}

}
