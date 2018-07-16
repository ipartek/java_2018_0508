package com.ipartek.formacion.ejercicios.array;

import java.util.Random;
import java.util.Scanner;

/**
 * Método Java que llene un array de enteros con números aleatorios
 * Los números aleatorios deberán estar comprendidos entre dos límites (desde,  hasta) ambos incluidos.
 * El método recibe como parámetros los valores desde, hasta y el tamaño del array.
 * El método devuelve mediante return el array de enteros creado.
 * Para obtener números enteros aleatorios usaremos el método nextInt() de la clase Random.
 * @author Alain
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int desde;
		int hasta;
		int tam;
		
		System.out.println("Introduce desde donde empezaran los numeros aleatorios:");
		desde = teclado.nextInt();
		System.out.println("Introduce hasta donde llegaran los numeros aleatorios:");
		hasta = teclado.nextInt();
		System.out.println("Introduce el tamaño que tendra el array de numeros aleatorios:");
		tam = teclado.nextInt();
		
		llenarArrayAleatorio(desde, hasta, tam);
		
		teclado.close();
	}
	
	/**
	 * Metodo para generar el array de numeros
	 * @param desde
	 * @param hasta
	 * @param tam
	 * @return
	 */
	public static int[] llenarArrayAleatorio(int desde, int hasta, int tam){
		int[] numeros = new int[tam];
		
		Random rnd = new Random();
		
		for (int n = 0; n < numeros.length; n++) {
			numeros[n] = rnd.nextInt(hasta - desde +1) + desde;
			
			comprobarSiContiene(numeros, n, numeros[n]);
		}
		
		return numeros;
	}
	
	/**
	 * Metodo para comprobar si el array ya contiene el numero
	 * @param numeros
	 * @param indice
	 * @param valor
	 * @return
	 */
	public static boolean comprobarSiContiene(int[] numeros, int indice, int valor) {
		boolean result = false;
        for (int i = 0; i < indice; i++) {
            if (numeros[i] == valor) {
            	result = true;
            }
        }
        return result;
}

}
