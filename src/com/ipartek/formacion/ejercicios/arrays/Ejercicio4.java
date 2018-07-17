package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * 4. Programa que crea un array de 20 elementos llamado Pares y guarde los 20<br>
 * primeros números pares. Mostrar por pantalla el contenido del array creado.<br>
 * 
 * @author Ainara
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		int i;
		int contador = 2;

		int[] par = new int[20];

		Scanner sc = new Scanner(System.in);

		for (i = 0; i < par.length; i++) {
			par[i] = contador;
			contador += 2;
		}

		for (i = 0; i < par.length; i++) {
			System.out.println(par[i]);
		}
		
		sc.close();
	}
}