package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		int n;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero de 5 cifras");
		n = sc.nextInt();
		
		System.out.println(n);
		System.out.println(n/10);
		System.out.println(n/100);
		System.out.println(n/1000);
		System.out.println(n/10000);
		
		sc.close();
	}

}
