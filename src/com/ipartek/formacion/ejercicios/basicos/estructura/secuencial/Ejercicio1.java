package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/*1.      Programa Java que lea dos números enteros por teclado y los muestre por pantalla.*/
public class Ejercicio1 {

	public static void main(String[] args) {
		//Variables
		int n1,n2;
		Scanner sc = new Scanner(System.in);
		
		//Pedir numeros
		System.out.println("Introduce un numero entero:");
		n1=sc.nextInt(); //Lee un entero por teclado
		
		System.out.println("Introduce otro numero entero:");
		n2=sc.nextInt();
		
		System.out.println("El numero introducido n1="+n1);
		System.out.println("El numero introducido n2="+n2);
	}

}
