package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso1 8. Calcular el mayor de tres números enteros en Java.
 *
 */
public class Ejercicio8 {
	public static void main(String[] args) throws Exception {
		int[] vector = { 0, 0, 0 };
		int numeroM = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el priemr numero :");
		vector[0] = Integer.parseInt(br.readLine());
		System.out.println("Introduce el segundo numero :");
		vector[1] = Integer.parseInt(br.readLine());
		System.out.println("Introduce el tercer numero :");
		vector[2] = Integer.parseInt(br.readLine());
		for (int x = 0; x < vector.length; x++) {
			if (vector[x] > numeroM) {
				numeroM = vector[x];
			}
		}
		System.out.println("El mayor de los numeros introducidos es: " + numeroM);
	}
}
