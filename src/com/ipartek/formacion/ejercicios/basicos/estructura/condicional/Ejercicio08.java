package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Calcular el mayor de tres números enteros en Java.
 * 
 * El programa lee por teclado tres números enteros y calcula y muestra el mayor
 * de los tres.
 * 
 * @author Curso
 *
 */
public class Ejercicio08 {

	public static void main(String[] args) {

		int n1;
		int n2;
		int n3;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el primer numerito:");
		n1 = sc.nextInt();
		System.out.println("Introduce el segundo numerito:");
		n2 = sc.nextInt();
		System.out.println("Introduce el tercer numerito:");
		n3 = sc.nextInt();
		
		if(n1>=n2) {
			if(n1>=n3) {
				System.out.println("De los 3 numeritos ("+n1+","+n2+","+n3+") el mayor es "+n1);
			}else {
				System.out.println("De los 3 numeritos ("+n1+","+n2+","+n3+") el mayor es "+n3);
			}
		}else {
			if(n2>=n3) {
				System.out.println("De los 3 numeritos ("+n1+","+n2+","+n3+") el mayor es "+n2);
			}else {
				System.out.println("De los 3 numeritos ("+n1+","+n2+","+n3+") el mayor es "+n3);
			}
		}
		
		sc.close();

	}

}
