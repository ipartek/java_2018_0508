package com.ipartek.formacion.ejercicios.buclesAnidados;

import java.util.Scanner;

/**
 * Primera relación de ejercicios para practicar con los bucles anidados en
 * Java. En este caso todos los ejercicios propuestos se resuelven anidando dos
 * bucles for aunque también se podrían resolver mediante dos bucles while o
 * do..while anidados o mediante combinaciones de los tres tipos: for, while,
 * do..while. Te animo a que los resuelvas utilizando bucles distintos al for
 * utilizado aquí. 1. Leer por teclado un número entero N no negativo y mostrar
 * el factorial de todos los números desde 0 hasta N. El factorial de un número
 * entero se expresa mediante el símbolo ‘!’ y se define de la siguiente forma:
 * Si n = 0 entonces 0! = 1 Si n > 0 entonces n! = n * (n – 1) * (n – 2) * …. *
 * 3 * 2 * 1 Por ejemplo, n = 5 entonces 5! = 5 * 4 * 3 * 2 * 1 = 120
 * 
 * @author Curso
 *
 */
public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		 long factorial=1;
	        int num;
	        Scanner numero = new Scanner(System.in);
	        System.out.print("Ingrese el numero por favor : ");
	        num = numero.nextInt();
	        for (int i = num; i > 0; i--) {
	            factorial = factorial * i;
	        }
	        System.out.println("El factorial es: " + factorial);
	    }
}
