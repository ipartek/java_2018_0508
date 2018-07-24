package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Pasar de decimal a binario
 */
public class Ejercicio9 {

	public static void main(String[] args) {
	        
	        Scanner teclado = new Scanner(System.in);
	        System.out.print("Introduce un numero: ");
	        int num = teclado.nextInt();
	        int digit = 0;
	        double binary= 0;
	        int exp= 0;
	        while(num>0){
                digit = num % 2;            
                binary += digit * Math.pow(10, exp);   
                exp++;
                num = num/2;
	        }
	        System.out.println("El binario es: "+(int)binary);
	        teclado.close();

	        

	}

}
