package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
* Programa Java que lea un número entero N de 5 cifras y 
* muestre sus cifras igual que en el ejemplo.
* Por ejemplo para un número N = 12345    La salida debe ser:
* 
* 5
* 45
* 345
* 2345
* 12345
*/
public class Ejercicio12 {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		int numero;
		
		System.out.println("Introduce un número de 5 cifras");
		
		numero = sc.nextInt();
		
		System.out.println(numero%10);
        System.out.println(numero%100);
        System.out.println(numero%1000);
        System.out.println(numero%10000);
        System.out.println(numero);
		
        sc.close();

	}

}
