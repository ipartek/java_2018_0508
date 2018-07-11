package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		String respuesta = "no";
		int gradosC;
		int gradosF;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Cuantos grados hace?");
			gradosC = sc.nextInt();
			
			gradosF = gradosC + 273;
			
			System.out.println("Hacen " + gradosF + " ºF");
			System.out.println("Repetir proceso? si/no");
			respuesta = sc.next();
			
		}while(("si").equals(respuesta));
		
		sc.close();
	}

}
