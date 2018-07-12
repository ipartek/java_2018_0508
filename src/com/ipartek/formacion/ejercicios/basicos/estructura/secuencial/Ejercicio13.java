package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que calcula el número de la suerte de una persona a partir de su
 * fecha de nacimiento.
 * 
 * @author andreaPerez
 *
 */
public class Ejercicio13 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int dia, mes, año, suerte, suma, cifra1, cifra2, cifra3, cifra4;
	        System.out.println("Introduzca fecha de nacimiento");
	        System.out.print("día: ");
	        dia = sc.nextInt();
	        System.out.print("mes: ");
	        mes = sc.nextInt();
	        System.out.print("año: ");
	        año = sc.nextInt();
	        suma = dia + mes + año;
	        cifra1 = suma/1000;      //obtiene la primera cifra
	        cifra2 = suma/100%10;  //obtiene la segunda cifra
	        cifra3 = suma/10%10;   //obtiene la tercera cifra
	        cifra4 = suma%10;        //obtiene la última cifra
	        suerte = cifra1 + cifra2 + cifra3 + cifra4;
	        System.out.println("Su número de la suerte es: " + suerte);
	        sc.close();

	}

}
