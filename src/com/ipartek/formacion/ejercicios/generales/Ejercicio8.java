package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa java que muestra los N primeros números de la serie. El valor de N se lee por teclado.
 * @author Curso
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		int n1;
		int fibo1 = 1;
		int fibo2 = 1;
		
		do{
            System.out.print("Introduce numero mayor que 1: ");
            n1 = teclado.nextInt();
        }while(n1<=1);
		
		System.out.println();
		System.out.println("Los primeros " + n1 + " números de la serie de Fibonacci son:");
		
		System.out.println();
		System.out.print(fibo1 + " ");
        for(int i=2;i<=n1;i++){
             System.out.print(fibo2 + " ");
             fibo2 = fibo1 + fibo2;
             fibo1 = fibo2 - fibo1;
        }
		
		teclado.close();
	}

}
