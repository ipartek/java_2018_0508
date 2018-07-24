package com.ipartek.ejercicios.estructura.secuencial;
import java.util.Scanner;
/**
 * Programa que lea un número entero N de 5 cifras y muestre sus cifras igual que en el ejemplo.
Por ejemplo para un número N = 12345   La salida debe ser:
1
12
123
1234
12345
 * @author Curso
 *
 */

public class Ejercicio11 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		int n;
        System.out.print("Introduzca valor de N: ");
        n = sc.nextInt(); //supondremos que el número introducido tiene 5 cifras
        System.out.println(n/10000);
        System.out.println(n/1000);
        System.out.println(n/100);
        System.out.println(n/10);
        System.out.println(n);
	}

}
