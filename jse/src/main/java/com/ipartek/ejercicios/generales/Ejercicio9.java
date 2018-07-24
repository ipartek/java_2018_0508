package com.ipartek.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa que pasa un numero de decimal a binario
 * @author Curso
 *
 */

public class Ejercicio9 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int numero;
		int exp;
		int digito;
		double binario;
		
		do {
			System.out.println("Introduce un numero entero mayor a 1: ");
			numero= sc.nextInt();
		}
		while(numero<0);
		
		exp= 0;
		binario= 0;
		while(numero!=0) {
			
			digito= numero%2;            
            binario= binario + digito * Math.pow(10, exp);   
            exp++;
            numero= numero/2;
    }
        
		System.out.printf("Binario: %.0f %n", binario);
				
}

}
	

