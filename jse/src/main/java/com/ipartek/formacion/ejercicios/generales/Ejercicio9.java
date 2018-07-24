package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa java para convertir un número de decimal a binario
 * @author Curso
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		int n1;
		int n2 = 0;
		double binario = 0;
		int digito;
		
		do{  
            System.out.print("Introduce un numero entero >= 0: ");
            n1 = teclado.nextInt();
        }while(n1<0);
		
		System.out.println();
		System.out.print("El numero " + n1 + " en decimal equivale a ");
		do {
			digito = n1 % 2;
			binario = binario + digito * Math.pow(10, n2);
			n2++;
			n1 = n1 / 2;
		}while(n1 != 0);
		
		System.out.println(binario + " en binario.");
		
		teclado.close();
	}

}
