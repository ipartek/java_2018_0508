package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		int variable1, variable2;
		int vacia = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero ");
		variable1 = sc.nextInt();
		System.out.println("Introudce otro numero");
		variable2 = sc.nextInt();
		
		vacia = variable1;
		variable1 = variable2;
		variable2 = vacia;
		System.out.println("Los valores han cambiado. Variable 1: " + variable1 + " variable 2: " + variable2);
		sc.close();
	}

}
