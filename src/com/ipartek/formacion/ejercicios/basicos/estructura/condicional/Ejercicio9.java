package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

/**
 * Programa que lea por teclado tres números enteros H, M, S correspondientes a hora, 
 * minutos y segundos respectivamente, y comprueba si la hora que indican es una hora válida. 
 * Supondremos que se leemos una hora en modo 24 Horas, es decir, el valor válido 
 * para las horas será mayor o igual que cero y menor que 24.
 * El valor válido para los minutos y segundos estará comprendido entre 0 y 59 
 * ambos incluidos
 */

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		int h, m, s;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce la hora");
		h = sc.nextInt();
		
		System.out.println("Introduce los minutos");
		m = sc.nextInt();
		
		System.out.println("Introduce los segundos");
		s = sc.nextInt();
		
		if(h < 24) {
			if(m < 60) {
				if(s < 60) {
					System.out.println("Son las " + h + " : " + m + " : " + s);
				}
				else {
					m = m + 1;
					s = s -60;
					System.out.println("Son las " + h + " : " + m + " : " + s);
				}
			}
			else {
				h = h + 1;
				m = m - 60;
				System.out.println("Son las " + h + " : " + m + " : " + s);
			}
		}
		else{
			System.out.println("La hora no es valida");
		}
		sc.close();
	}

}
