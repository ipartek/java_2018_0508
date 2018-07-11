package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

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
	}

}
