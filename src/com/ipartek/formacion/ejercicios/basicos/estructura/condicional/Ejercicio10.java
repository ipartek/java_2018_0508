package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea una variable entera mes y compruebe si el valor corresponde
 * a un mes de 30 días, de 31 o de 28.
 *
 */

public class Ejercicio10 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int m =0;
		do {
			System.out.print("Introduce el numero correspondiente a un mes: ");
			m = teclado.nextInt();
		}while(m<=0 || m>12);
		
		if( (m<=7 && m%2==0 && m!=2) || (m>8 && m%2!=0)) {
			System.out.println("Tiene 30 dias");
		}else if(m==2){
			System.out.println("Tiene 28 dias");
		}else {
			System.out.println("Tiene 31 dias");
		}
		teclado.close();

	}

}
