package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		int mes;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe un mes");
		mes = sc.nextInt();
		
		if(mes < 1 || mes > 12) {
			System.out.println("Mes incorrecto");
		}
		else {
			switch (mes) {
				case 1:
					System.out.println("Enero");
					break;
				case 2:
					System.out.println("Febrero");
					break;
				case 3:
					System.out.println("Marzo");
					break;
				case 4:
					System.out.println("Abril");
					break;
				case 5:
					System.out.println("Mayo");
					break;
				case 6:
					System.out.println("Junio");
					break;
				case 7:
					System.out.println("Julio");
					break;
				case 8:
					System.out.println("Agosto");
					break;
				case 9:
					System.out.println("Septiembre");
					break;
				case 10:
					System.out.println("Octubre");
					break;
				case 11:
					System.out.println("Noviembre");
					break;
				case 12:
					System.out.println("Diciembre");
					break;
			}
			
			if(mes == 1 || mes ==3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes ==12) {
				System.out.println("Este mes tiene 31 dias");
			}
			else if(mes == 2) {
				System.out.println("Este mes tiene 28 dias");
			}
			else {
				System.out.println("Este mes tiene 30 dias");
			}
		}
		sc.close();	
	}

}
