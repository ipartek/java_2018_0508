package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa java que lea una variable entera mes y compruebe si el valor corresponde
 * a un mes de 30 días. Se debe comprobar que el valor introducido esté
 * comprendido entre 1 y 12
 */
public class Ejercicio10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int mes;
		
		System.out.println("Introduzca un mes (el número)");
		mes = sc.nextInt();
		
		while(mes < 1 || mes > 12) {
			System.out.println("Introduzca un mes real");
			mes = sc.nextInt();
		}
		
		switch (mes) {
		
		case 1:
			System.out.println("Estamos en Enero, que tiene 31 días");
			break;
			
		case 2:
			System.out.println("Estamos en Febrero, que tiene 28 días");
			break;
			
		case 3:
			System.out.println("Estamos en Marzo, que tiene 31 días");
			break;
			
		case 4:
			System.out.println("Estamos en Abril, que tiene 30 días");
			break;
			
		case 5:
			System.out.println("Estamos en Mayo, que tiene 31 días");
			break;
			
		case 6:
			System.out.println("Estamos en Junio, que tiene 30 días");
			break;
			
		case 7:
			System.out.println("Estamos en Julio, que tiene 31 días");
			break;
			
		case 8:
			System.out.println("Estamos en Agosto, que tiene 31 días");
			break;
			
		case 9:
			System.out.println("Estamos en Septiembre, que tiene 30 días");
			break;
			
		case 10:
			System.out.println("Estamos en Octubre, que tiene 31 días");
			break;
			
		case 11:
			System.out.println("Estamos en Noviembre, que tiene 30 días");
			break;
			
		case 12:
			System.out.println("Estamos en Diciembre, que tiene 31 días");
			break;

		}
		
		sc.close();

	}

}
