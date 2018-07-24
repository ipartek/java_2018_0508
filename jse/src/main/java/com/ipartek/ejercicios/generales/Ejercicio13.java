package com.ipartek.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa que pida por teclado un número entero N de más de una cifra y verifique si es capicúa
 * @author Curso
 *
 */

public class Ejercicio13 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
        sc = new Scanner(System.in);
        
        int N, aux, inverso = 0, cifra;
        
        do {
            System.out.print("Introduce un número >= 10: ");
            N = sc.nextInt();
        } while (N < 10);
       
        //le damos la vuelta al número
        aux = N;
        while (aux!=0){
            cifra = aux % 10;
            inverso = inverso * 10 + cifra;
            aux = aux / 10;
        }
    
        if(N == inverso){
            System.out.println("Es capicua");
        }else{
            System.out.println("No es capicua");
        }
    }
}


