package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * @author andreaPerez Escribe un programa Java que lee un número entero por
 *         teclado y obtiene y muestra por pantalla el doble y el triple de ese
 *         número.
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int num=0;	
		
		System.out.print("Ingrese un numero entero:");
		num=sc.nextInt();
		System.out.println("El doble de " + num + " es: " + num*2);
		System.out.println("El triple de " + num +" es: " + num*3);
		//TODO falta validacion de entero
	}

}
