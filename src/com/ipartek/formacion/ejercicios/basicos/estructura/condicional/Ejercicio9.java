package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea por teclado tres números enteros H, M, S correspondientes a hora, 
 * minutos y segundos respectivamente, y comprueba si la hora que indican es una hora válida. 
 *
 * Supondremos que leemos una hora en modo 24 Horas, es decir, 
 * el valor válido para las horas será mayor o igual que cero y menor que 24.
 *
 * El valor válido para los minutos y segundos estará comprendido entre 0 y 59 ambos incluidos
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int hora;
		int minutos;
		int segundos;
		
		System.out.println("Introduce las horas");
		hora = sc.nextInt();
		
		System.out.println("Introduce los minutos");
		minutos = sc.nextInt();
		
		System.out.println("Introduce los segundos");
		segundos = sc.nextInt();
		
		if((hora >= 0 && hora < 24) && (minutos >= 0 && minutos <= 59) && 
			(segundos >= 0 && segundos <= 59)) {
			System.out.println("La hora " + hora + ":" + minutos +":" + segundos + " es correcta");
		}
		else {
			System.out.println("La hora " + hora + ":" + minutos +":" + segundos + " no es correcta");
		}
		
		sc.close();

	}

}
