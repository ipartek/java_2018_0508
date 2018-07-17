package com.ipartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Leer números por teclado hasta introducir -99. 
 * Calcular la suma, la media y cuántos son mayores que la media.
 * @author Adrian Garcia
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		int numero;
		double suma = 0;
		double media;
		int contador = 0;

		System.out.println("Introduce un número (-99 para terminar)");
		numero = sc.nextInt();
		
		while(numero != -99) {
			numeros.add(numero);
			System.out.println("Introduce un número (-99 para terminar)");
			numero = sc.nextInt();
		}
		
		for (Integer i : numeros) {
			suma += i;
		}
		
		media = suma / numeros.size();
		
		for (Integer i : numeros) {
			if(i > media) {
				contador++;
			}
		}
		
		System.out.println("La suma total es " + suma);
		System.out.println("La media es " + media);
		System.out.println("Hay " + contador + " números mayores a la media");
		
		sc.close();
				
	}

}
