package com.ipartek.ejercicios.estructura.secuencial;
import java.util.Scanner;

/**
 * 1.      Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
 * @author Curso
 *
 */

public class Ejercicio1 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		int n1;
		int n2;
		
		sc = new Scanner(System.in);
		
		System.out.println("Introduce un número entero: "); 
        n1 = sc.nextInt();      //lee un numero entero por teclado
        //leer el segundo número
        System.out.println("Introduce otro número entero: "); 
        n2 = sc.nextInt();      //lee un numero entero por teclado
        //mostrar el resultado
        System.out.println("Ha introducido los números: " + n1 + " y " + n2);

		

		
	}
	

}
