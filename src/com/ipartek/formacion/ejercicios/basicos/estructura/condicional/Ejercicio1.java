package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 1. Programa Java que lea un número entero y calcule si es par o
 *         impar.
 */
public class Ejercicio1 {
	public static void main(String[] args) throws Exception {
		
		int numero ;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce un numero :");
		numero = Integer.parseInt(br.readLine());
		
		System.out.println(numero%2== 0 ? "Es par" :"Es impar");
		
	}
}
