package com.ipartek.formacion.basicos.estructura.condicional;

import java.util.Scanner;

import com.ipartek.formacion.util.Utilidades;

/**
 * Programa Java que lea un caracter y diga si es mayúscula.
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		char c;

		c =  Utilidades.leerString(sc).charAt(0);
		System.out.println(esMayusc(c) ? c + " es mayúscula" : c + " no es mayúscula");

	}

	private static boolean esMayusc(char c) {

		return (Character.isUpperCase(c)? true : false);
	}

}
