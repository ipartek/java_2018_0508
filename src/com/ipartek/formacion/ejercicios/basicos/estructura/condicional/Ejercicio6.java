package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		char c;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un caracter");
		c = sc.next().charAt(0);
		
		if(Character.isDigit(c)) {
			System.out.println("Este caracter es un numero");
		}
		else {
			System.out.println("Este caracter es una letra");
		}
	}

}
