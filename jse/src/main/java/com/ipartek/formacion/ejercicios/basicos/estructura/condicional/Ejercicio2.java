package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/*2. Programa que lea un número entero y muestre si el número es múltiplo de 10.

Podemos comprobar si un número entero es múltiplo de 10 si al dividirlo por 10 es resto de esta división es cero.*/
public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		//Variables
		int num;
		
		System.out.println("Introducir un numero");
		num=sc.nextInt();
		
		if(num%10==0) {
			System.out.println("El numero introducido es multiplo de 10");
		}else {
			System.out.println("EL numero introducido no es multiplo de 10");
		}
	}
}
