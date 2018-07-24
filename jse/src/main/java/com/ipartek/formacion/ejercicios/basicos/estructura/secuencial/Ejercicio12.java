package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que lea un número entero N de 5 cifras y muestre sus cifras igual que en el ejemplo.<br>
 * Por ejemplo para un número N = 12345    La salida debe ser:<br>
 * 5
 * 45
 * 345
 * 2345
 * 12345
 * 
 * @author Curso
 *
 */

public class Ejercicio12 {
	public static void main(String[] args) {
		
		int num;

		Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca un numero de cinco cifras: ");
        num = sc.nextInt();
        
        System.out.println(num%10);
        
        System.out.println(num%100);
        
        System.out.println(num%1000);
        
        System.out.println(num%10000);
        
        System.out.println(num);
        
        sc.close();
    }
}
