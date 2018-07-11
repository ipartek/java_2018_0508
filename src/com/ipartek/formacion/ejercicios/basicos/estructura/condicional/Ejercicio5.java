package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author drohne 5. Programa que lea dos caractere y compruebe si son dos
 *         letras minúsculas.
 */
public class Ejercicio5 {
	public static void main(String[] args) throws Exception {
		char letra1;
		char letra2;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce la primera letra :");
		letra1 = br.readLine().charAt(0);
		System.out.println("Introduce la primera letra :");
		letra2 = br.readLine().charAt(0);
		System.out.println(Character.toLowerCase(letra1) == letra1 && Character.toLowerCase(letra2) == letra2
				? "Las 2 letras son minusculas"
				: "Una de las 2 letras es mayuscula");
	}
}
