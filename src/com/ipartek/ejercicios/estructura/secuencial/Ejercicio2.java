package com.ipartek.ejercicios.estructura.secuencial;
import java.util.Scanner;

/**
 * 2.      Programa Java que lea un nombre y muestre por pantalla:
“Buenos dias nombre_introducido”
 * @author Curso
 *
 */

public class Ejercicio2 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		String nombre;
		
		System.out.println("Introduce un nombre");
		nombre= sc.nextLine();
		System.out.println("Buenos dias "+nombre);
	}

}
