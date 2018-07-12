package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
* Programa que lea dos caracteres por teclado y compruebe si son iguales.
*/
public class Ejercicio4 {

	public static void main(String[] args) {
		
		
		//TODO controlar que solo se introduzcan caracteres
		Scanner sc = new Scanner(System.in);
		
		char caracter1;
		char caracter2;
		
		System.out.println("Introduce 2 caracteres");
		
		caracter1 = sc.next().charAt(0);
		caracter2 = sc.next().charAt(0);
		
		if(caracter1 == caracter2) {
			System.out.println("Los caracteres '" + caracter1 + "' y '" + caracter2 + "' son iguales");
		}
		else {
			System.out.println("Los caracteres '" + caracter1 + "' y '" + caracter2 + "' no son iguales");
		}
		
		sc.close();

	}

}
