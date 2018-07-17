package com.ipartek.formacion.ejercicios.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 7. Leer N alturas y calcular la altura media. Calcular
 *         cuántas<br>
 *         hay superiores a la media y cuántas inferiores.
 */
public class Ejercicio7 {
	public static void main(String[] args) throws Exception {
		
		int nAlturas = 0;
		int mediaAltura = 0;
		int contadorM = 0;
		int contadorI = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el numero de alturas que calcularemos");
		nAlturas = Integer.parseInt(br.readLine());
		int[] alturas = new int[nAlturas];
		for (int x=0; x < nAlturas;x++){
			mediaAltura =mediaAltura + alturas[x];
		}
		
		mediaAltura = mediaAltura / nAlturas;
		
		for (int x = 0; x > nAlturas; x++) {
			if (alturas[x] > mediaAltura) {
				contadorM += 1;
			} else {
				if (alturas[x] < mediaAltura) {
					contadorI += 1;
				}
			}
		}
		
		System.out.println(("La media de altura esta en: " + mediaAltura));
		System.out.println(contadorM + " altura/s por encima de la media");
		System.out.println(contadorI + " altura/s por debajo de la media");
	}
}
