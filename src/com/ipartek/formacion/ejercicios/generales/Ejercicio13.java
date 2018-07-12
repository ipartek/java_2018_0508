package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java que pida por teclado un número entero N de más de una cifra y verifique si es capicúa
 * @author Curso
 *
 */
public class Ejercicio13 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		int inver = 0;
		int aux;
		int cifra;
		
		do {
            System.out.print("Introduce un número >= 10: ");
            n1 = teclado.nextInt();
        } while (n1 < 10);
		
		//Darle la vuelta al numero
		aux = n1;
		do {
			cifra = aux % 10;
			inver = inver * 10 + cifra;
			aux = aux / 10;
		} while (aux != 0);
		
		//Comprobar si es capicua
		System.out.println();
		if(n1 == inver) {
			System.out.println("Es capicua");
		}else {
			System.out.println("No es capicua");
		}
		teclado.close();
	}

}
