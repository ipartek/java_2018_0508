package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea dos números por teclado y muestre el resultado de la división del primer número<br>
 *  por el segundo. Se debe comprobar que el divisor no puede ser cero.<br>
 * @author Curso
 *
 */

public class Ejercicio7 {

	public static void main(String[] args) {

		float num;
		float num2;
		float result;
		
		Scanner sc=new Scanner(System.in);

		System.out.println("Introduce un numero de dividendo: ");
		num=sc.nextInt();
		System.out.println("Introduce otro numero de divisor: ");
		num2=sc.nextInt();
		
		if(num2==0) {
			System.out.println("La division no se puede hacer");
		}else {
			result=num/num2;
			System.out.println("La division de los dos numeros es : " + result);
		}
		
		sc.close();

	}

}
