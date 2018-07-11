package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		int dia, mes, anyo, suerte, suma, cifra1, cifra2, cifra3, cifra4;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe el dia de tu cumpleaños");
		dia = sc.nextInt();
		
		System.out.println("Escribe el mes de tu cumpleaños");
		mes = sc.nextInt();
		
		System.out.println("Escribe el año de tu cumpleaños");
		anyo = sc.nextInt();
		
		suma = dia + mes + anyo;
		
		cifra1 = suma/1000;
		cifra2 = suma/100 % 10;
		cifra3 = suma/10 % 10;
		cifra4 = suma %10;
		
		suerte = cifra1 + cifra2 + cifra3 + cifra4;
		
		System.out.println("Tu numero de la suerte es: " + suerte);
		
		sc.close();
	}

}
