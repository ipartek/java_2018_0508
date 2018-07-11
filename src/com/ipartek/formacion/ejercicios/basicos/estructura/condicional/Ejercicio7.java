package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		double dividendo, divisor;
		double resultado;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el dividendo");
		dividendo = sc.nextDouble();

		System.out.println("Introduce el divisor");
		divisor = sc.nextDouble();
		
		resultado = dividendo /divisor;
		
		if(divisor == 0) {
			System.out.println("No se puede dividir por cero");
		}
		else {
			System.out.println("Dividendo: " + dividendo + " / " + divisor + " = " + resultado);
		}
		
		sc.close();
	}

}
