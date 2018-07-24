package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea por teclado tres números enteros H, M, S correspondientes a
 * hora, minutos y segundos respectivamente, y comprueba si la hora que indican
 * es una hora válida.
 * 
 * Supondremos que se leemos una hora en modo 24 Horas, es decir, el valor
 * válido para las horas será mayor o igual que cero y menor que 24.
 * 
 * El valor válido para los minutos y segundos estará comprendido entre 0 y 59
 * ambos incluidos
 * 
 * @author Curso
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		int num1;
		int num2;
		int num3;
		int resul = 0;
		
		System.out.print("Introduce hora: ");
		num1 = sc.nextInt();
		System.out.print("Introduce minutos: ");
		num2 = sc.nextInt();
		System.out.print("Introduce segundos: ");
		num3 = sc.nextInt();
			
		
		sc.close();
	}

}
