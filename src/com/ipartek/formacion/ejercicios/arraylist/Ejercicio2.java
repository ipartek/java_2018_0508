package com.ipartek.formacion.ejercicios.arraylist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Curso 2. Leer números por teclado hasta introducir -99. Calcular la<br>
 *         suma, la media y cuántos son mayores que la media.
 *
 */
public class Ejercicio2 {
	
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> numeros = new ArrayList();
		int numero = 0 ;
		int contadorMayor = 0;
		int contadorMenor = 0;
		double media = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (numero != 99) {
			System.out.println("Introduce un numero :");
			numero = Integer.parseInt(br.readLine());
			numeros.add(numero);
		}
		for (int x = 0; x < numeros.size(); x++) {
			media += numeros.get(x).intValue();
		}
		media = media / numeros.size();
		System.out.println("La media de altura de la clase es: " + String.format("%.2f", media));
		for (int x = 0; x < numeros.size(); x++) {
			if (numeros.get(x).intValue() > media) {
				contadorMayor += 1;
			} else {
				if (numeros.get(x).intValue() < media) {
					contadorMenor += 1;
				}
			}
		}
		System.out.println("Nº de alumnos por encima de la media: " + contadorMayor);
		System.out.println("Nº de alumnos por debajo de la media: " + contadorMenor);
		
	}
}
