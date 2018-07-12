package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso1 6. Programa que lea un carácter y compruebe si es un número
 *         (Carácter entre '0' y '9').
 */
public class Ejercicio6 {
	public static void main(String[] args) throws Exception {
		char caracter;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce un caracter para comprobar si es un numero :");
		caracter = br.readLine().charAt(0);
		System.out.println(Character.isDigit(caracter) ? caracter + " Es un numero" : caracter + " No es un numero");
	}
}
