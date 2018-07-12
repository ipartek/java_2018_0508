package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * Leer números y contar cuántos acaban en 2.
 */

public class Ejercicio5 {

	public static void main(String[] args) throws IOException {

		Scanner teclado = new Scanner(System.in);
		int cont=0;
		char ch = 'S';		
		while(ch == 'S' || ch == 's') {
			System.out.print("Introducir un numero: ");
			int num = teclado.nextInt();
			if(num%10 == 2) {
				cont++;
			}
			System.out.print("Repetir proceso? (S/N): ");
			ch = (char) System.in.read();
		}
		System.out.println(cont+" numeros acaban en 2");
		teclado.close();
		

	}

}
