package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Calcular el mayor de tres números enteros en Java.
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		int num = 8;
		int num2 = 7;
		int num3 = 10;

		if (num > num2) {
			if (num > num3) {
				System.out.println("El numero mayor es: " + num);
			} else {
				System.out.println("El numero mayor es: " + num3);
			}
		} else if (num2 > num3) {
			System.out.println("El numero mayor es: " + num2);
		} else {
			System.out.println("El numero mayor es: " + num3);
		}
	}

}
