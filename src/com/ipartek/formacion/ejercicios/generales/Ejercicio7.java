package com.ipartek.formacion.ejercicios.generales;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 7. Comprobar si dos números son amigos.
 *
 */
public class Ejercicio7 {
	public static void main(String[] args) throws Exception {
		int numero1;
		int numero2;
		int suma1 = 0;
		int suma2 = 0;

		System.out.println("Introduce el primer numero :");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numero1 = Integer.parseInt(br.readLine());

		System.out.println("Introduce el segundo numero :");
		numero2 = Integer.parseInt(br.readLine());

		for (int x = 1; x < numero1; x++) { 
			if (numero1 % x == 0) {
				suma1 = suma1 + x;
			}
		}
		
		for (int x = 1; x < numero2; x++) { 
			if (numero2 % x == 0) {
				suma2 = suma2 + x;
			}
		}
		System.out.println(suma2 == numero1 && suma1 == numero2 ? "Son numeros Amigos" : "No son numeros amigos");
		
	}
}
