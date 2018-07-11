package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author drohne 2. Programa que lea un número entero y muestre si el número es
 *         múltiplo de 10.
 */
public class Ejercicio2 {
	public static void main(String[] args) throws Exception {
		int numero;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce un numero entero :");
		numero = Integer.parseInt(br.readLine());

		System.out.println(numero % 10 == 0 ? numero + " Es multiplo de 10" : numero + " No es multiplo de 10");
	}
}
