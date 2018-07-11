package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

/**
 *  Programa que lea un número entero y muestre si el número es múltiplo de 10.<br>
 *  Podemos comprobar si un número entero es múltiplo de 10 si al dividirlo por 10 es resto de esta división es cero.<br>
 */

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args){
		
		int num;
		
		Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: "); 
        num = sc.nextInt(); 
		
		String multi=(num%10==0)?"MULTIPLO":"NO MULTIPLO";

		System.out.println("El numero " + num + " es: "+ multi);
		
		sc.close();
	}
}
