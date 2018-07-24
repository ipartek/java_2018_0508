package com.ipartek.formacion.ejercicios.bucles.anidados;

import java.util.Scanner;

/**
 * Programa java que pide un número entero N no negativo y muestra el factorial de todos los números desde 0 hasta N
 * @author Curso
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		double factorial;
		
		do{
            System.out.print("Introduce un número > 0: ");
            n1 = teclado.nextInt();
        }while(n1<0);

		for (int i = 0; i <= n1; i++) { //Se repite mientras i sea menor al numero introducido
			
			factorial = 1;
			for (int j = 1; j <= i; j++) {//Calcular el factorial
				factorial = factorial * j;
			}
			
			System.out.printf("%2d! = %.0f %n", i, factorial);
		}
		
		teclado.close();
	}

}
