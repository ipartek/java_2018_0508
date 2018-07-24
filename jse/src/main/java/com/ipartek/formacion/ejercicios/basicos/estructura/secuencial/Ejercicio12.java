package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/*Programa Java que lea un número entero N de 5 cifras y muestre sus cifras igual que en el ejemplo.
Por ejemplo para un número N = 12345    La salida debe ser:

5
45
345
2345
12345*/
public class Ejercicio12 {

	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  //Variables
	        int n;
	        System.out.print("Introduzca valor de N: ");
	        n = sc.nextInt();  //supondremos que el número introducido tiene 5 cifras
	        
	        
	        System.out.println(n%10);
	        System.out.printf("%02d %n",n%100);
	        System.out.printf("%03d %n",n%1000);
	        System.out.printf("%04d %n",n%10000);
	        System.out.printf("%05d %n",n);

	}

}
