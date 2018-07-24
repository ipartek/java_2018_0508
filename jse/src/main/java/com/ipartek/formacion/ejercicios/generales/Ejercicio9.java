package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Pasar de decimal a binario
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero;
		int binario;
		
		System.out.println("Introduce un número para pasarlo a binario");
		numero = sc.nextInt();
		
		while(numero != 0) {
			binario = numero % 2;
			numero /= 2;
			if(binario == 0) {
				binario = 1;
			}
			else {
				binario = 0;
			}
			System.out.print(binario);
		}
		
		sc.close();

	}

}
