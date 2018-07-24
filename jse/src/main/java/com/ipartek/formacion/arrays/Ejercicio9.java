package com.ipartek.formacion.arrays;

import java.util.Random;
import java.util.Scanner;

/**
 * En esta entrada vamos a escribir un método Java que llene un array de enteros
 * con números aleatorios. Los números aleatorios deberán estar comprendidos
 * entre dos límites (desde, hasta) ambos incluidos. El método recibe como
 * parámetros los valores desde, hasta y el tamaño del array. El método devuelve
 * mediante return el array de enteros creado.
 * 
 * @author Curso
 *
 */
public class Ejercicio9 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array;
		int tam;
		int desde;
		int hasta;

		System.out.println("Tamaño del array: ");
		tam = sc.nextInt();

		System.out.println("Nº aleatorio desde: ");
		desde = sc.nextInt();

		System.out.println("Nº aleatorio hasta: ");
		hasta = sc.nextInt();

		array = llenarArrayAleatorio(desde, hasta, tam);

		print(array);

	}

	public static int[] llenarArrayAleatorio(int desde, int hasta, int tam) {

		int[] tmp = new int[tam];
		Random rnd = new Random();

		for (int i = 0; i < tam; i++) {
			tmp[i] = rnd.nextInt(hasta - desde + 1) + desde;
		}

		return tmp;
	}

	public static void print(int[] ar) {

		System.out.print("[");

		for (int i = 0; i < ar.length; i++) {
			System.out.print(i == ar.length - 1 ? ar[i] : ar[i] + ", ");
		}
		System.out.print("]");
	}

}
