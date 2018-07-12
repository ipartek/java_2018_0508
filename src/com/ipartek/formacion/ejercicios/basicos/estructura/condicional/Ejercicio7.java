package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso1 7. Programa que lea dos números por teclado y muestre el<br>
 *         resultado de la división del primero por el segundo. Se debe<br>
 *         comprobar que el divisor no puede ser cero.<br>
 *
 */
public class Ejercicio7 {
	public static void main(String[] args) throws Exception {
		int numero1;
		int numero2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce un numero :");
		numero1 = Integer.parseInt(br.readLine());
		System.out.println("Introduce el divisor :");
		numero2 = Integer.parseInt(br.readLine());
		System.out.println(numero2 != 0 ? (numero1/numero2) : "El divisor no puede ser 0");
		
		
	}
}
