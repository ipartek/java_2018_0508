package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 1 3. Programa que lea un carácter por teclado y compruebe si es
 *         una letra mayúscula.
 */
public class Ejercicio3 {
	public static void main(String[] args) throws Exception {
		String letra;
		String letraM;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce una letra :");
		letra = br.readLine();
		System.out.println(letra);
		letraM = letra.toUpperCase();
		System.out.println(letra == letraM ? "La letra es mayuscula" : "La letra es minuscula");
		
	}
}
