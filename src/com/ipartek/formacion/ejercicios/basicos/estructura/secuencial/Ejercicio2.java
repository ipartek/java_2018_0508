package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 2. Programa Java que lea un nombre y muestre por pantalla:
 *         “Buenos dias nombre_introducido”.
 */
public class Ejercicio2 {
	public static void main(String[] args) throws Exception {
		System.out.println("Introduzca su nombre");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nombre = br.readLine();

		System.out.println("Buenos dias " + nombre);
	}
}
