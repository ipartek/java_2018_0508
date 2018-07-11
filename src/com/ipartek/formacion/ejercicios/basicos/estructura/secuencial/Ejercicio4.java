package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		double gradosC, gradosF;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cuantos grados hace? ");
		gradosC = sc.nextDouble();
		gradosF = 32 + ( 9 * gradosC / 5);
		
		System.out.println("Hace: " + gradosC + " ºC que son: " + gradosF + 
				" ºF ");

	}

}
