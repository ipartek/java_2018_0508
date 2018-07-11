package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 4. Programa que lea una cantidad de grados centígrados y la
 *         pase a grados Fahrenheit. La fórmula correspondiente es: F = 32 + ( 9
 *         * C / 5)
 */
public class Ejercicio4 {
	public static void main(String[] args) throws Exception {
		System.out.println("Introduzca su temperatura en grados centigrados");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// convertimos la entrada a entero directamente
		int temperaturaC = Integer.parseInt(br.readLine());
		int temperaturaF = 32 + (9 * temperaturaC / 5);
		System.out.println("La temperatura de " + temperaturaC + " centigrados, es equivalente a : " + temperaturaF
				+ " grados farenheit");
	}
}
