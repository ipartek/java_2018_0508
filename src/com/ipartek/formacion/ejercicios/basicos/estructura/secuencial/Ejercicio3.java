package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 3. Escribe un programa Java que lee un número entero por teclado y obtiene y
 * muestra por pantalla el doble y el triple de ese número.
 * 
 * @author Curso
 *
 */

public class Ejercicio3 {
	public static void main(String[] args) {

		Scanner p = new Scanner(System.in);
		int a = 0;
		System.out.println("Introduce tu un numero entero:" + a);
		a = p.nextInt();

		System.out.println("el numero ingresado" + a);
		System.out.println("El dobre de a es " + 2 * a);
		System.out.println("El tripe de a es " + 3 * a);

	}

}
