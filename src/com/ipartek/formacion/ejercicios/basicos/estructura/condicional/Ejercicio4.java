package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) throws IOException {
		char letra1, letra2;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una letra");
		letra1 = sc.next().charAt(0);
		
		System.out.println("Introduce otra letra");
		letra2 = sc.next().charAt(0);

		if(letra1 == letra2) {
			System.out.println("Ambas letras son iguales");
		}
		else {
			System.out.println("Las letras son diferentes");
		}
		sc.close();
	}

}
