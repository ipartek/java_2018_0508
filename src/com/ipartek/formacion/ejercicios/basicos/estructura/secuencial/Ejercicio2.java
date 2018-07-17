package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/*2.      Programa Java que lea un nombre y muestre por pantalla:*/
public class Ejercicio2 {

	public static void main(String[] args) {
		//Variables
		String cadena;
		Scanner sc = new Scanner(System.in);
		
		//Pedir
		System.out.println("Introduce un nombre:");
		cadena=sc.nextLine();
		
		System.out.println("EL nombre introducido es:"+cadena);
	}

}
