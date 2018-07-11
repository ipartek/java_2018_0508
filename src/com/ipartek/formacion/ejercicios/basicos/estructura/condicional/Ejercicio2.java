package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		int numero;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		numero = sc.nextInt();
		
		if(numero%10 == 0) {
			System.out.println("Este numero es multiplo de 10");
		}
		else {
			System.out.println("Este numero no es multiplo de 10");
		}
	}

}
