package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea por teclado tres números enteros H, M, S correspondientes a hora, minutos y segundos respectivamente, y comprueba si la hora que indican es una hora válida. 
 * Supondremos que se leemos una hora en modo 24 Horas, es decir, el valor válido para las horas será mayor o igual que cero y menor que 24.
 * El valor válido para los minutos y segundos estará comprendido entre 0 y 59 ambos incluidos
 * @author Curso
 *
 */

public class Ejercicio9 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int hora;
		int minuto;
		int segundo;
		
		System.out.println("Introduce la hora:");
		hora = teclado.nextInt();
		
		System.out.println("Introduce los minutos:");
		minuto = teclado.nextInt();
		
		System.out.println("Introduce los segundos:");
		segundo = teclado.nextInt();
		
		System.out.println();
		if( hora >= 0 && hora < 24) {
			if(minuto >= 0 && minuto <= 59) {
				if(segundo >= 0 && segundo <= 59) {
					System.out.println(hora + ":" + minuto + ":" + segundo);
				}else {
					System.out.println("El segundo " + segundo + " no es correcto.");
				}
			}else {
				System.out.println("El minuto " + minuto + " no es correcto.");
			}
		}else {
			System.out.println("La hora " + hora + " no es correcta.");
		}

		teclado.close();
	}

}
