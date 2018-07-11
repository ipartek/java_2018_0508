package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * Programa que lea un carácter por teclado y compruebe si es una letra mayúscula
 */

public class Ejercicio3 {
	public static void main(String[] args) throws IOException {
		
		char c;
		
		//Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una letra: "); 
        c = (char)System.in.read(); 
		
		String mayus=(Character.isUpperCase(c))?"MAYUSCULAS":"MINUSCULAS";

		System.out.println("La letra " + c + " es: "+ mayus);
		
		//sc.close();
	}
}
