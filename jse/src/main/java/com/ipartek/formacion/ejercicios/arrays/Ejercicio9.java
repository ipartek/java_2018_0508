package com.ipartek.formacion.ejercicios.arrays;

import java.util.Random;
import java.util.Scanner;

/**
 * Escribir un método Java que llene un array de enteros con números aleatorios.
 * Los números aleatorios deberán estar comprendidos entre dos límites (desde,
 * hasta) ambos incluidos. El método recibe como parámetros los valores desde,
 * hasta y el tamaño del array. El método devuelve mediante return el array de
 * enteros creado. Para obtener números enteros aleatorios usaremos el método
 * nextInt() de la clase Random. Para que los números aleatorios obtenidos estén
 * dentro de los limites utilizaremos el método nextInt() de la siguiente fórma:
 * nextInt(hasta - desde + 1) + desde.
 * 
 * Si los números no se pueden repetir debemos complicar un poco más el código.
 * En este caso cada vez que se obtiene un número aleatorio se debe comprobar si
 * ya está en el array. Para hacer este trabajo vamos a escribir un método
 * llamado comprobarSiContiene. A este método se le envía el array, la posición
 * del elemento actual y el número aleatorio a insertar y devuelve true si el
 * número ya existe en el array. En ese caso se vuelve a sacar otro número
 * aleatorio.
 * 
 * 
 * @author andreaperez
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tamanio = 0;
		int desde = 0;
		int hasta = 0;

		do {
			System.out.println("Indica el tamanio del array : ");
			tamanio = sc.nextInt();

			System.out.println("Indica desde que numero empezamos: ");
			desde = sc.nextInt();

			System.out.println("Indica hasta que numero: ");
			hasta = sc.nextInt();

			if (tamanio < hasta) {
				System.out.println(
						"Uppss...El tamanio tiene que ser igual o mayor que el maximo de numeros aleatorio introducido...");
			}
		} while (tamanio < hasta);

		metodoAleatorio(tamanio, desde, hasta);

		sc.close();
	}

	static int[] metodoAleatorio(int tam, int d, int h) {

		Random rnd = new Random();
		int[] aAleatorio = new int[tam];

		for (int i = 0; i < aAleatorio.length; i++) {

			do {
				aAleatorio[i] = rnd.nextInt(h - d + 1) + d;
			} while (!comprobarSiContiene(aAleatorio, i, aAleatorio[i]));
			System.out.println("numero aleatorio " + (i + 1) + " " + aAleatorio[i]);
		}

		return null;
	}

	static boolean comprobarSiContiene(int[] array, int pos, int n) {
		boolean resul = true;
		for (int i = 0; i < pos; i++) {
			if (array[i] == n) {
				resul = false;
			}
		}
		return resul;
	}

}
