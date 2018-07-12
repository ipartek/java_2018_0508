package com.ipartek.formacion.ejercicios;

import java.util.Scanner;

/**
 * Solicita numeros por pantalla y los suma, hasta que el usuario quiera parar.
 * @author ur00
 *
 */
public class PedirDatosPorConsola {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String stop = "n";
		int numero = 0;
		int total = 0;
		
		do {
			
			System.out.println("Dime un numero: ");
			numero = sc.nextInt();
			
			total += numero;
			
			
			System.out.println("¿ Quiere seguir sumando ?   's' -> SI  'n' -> NO ");
			stop = sc.next();
			
		}while( "s".equalsIgnoreCase(stop) );
		
		System.out.println("TOTAL: " + total );
		sc.close();
		

	}

}
